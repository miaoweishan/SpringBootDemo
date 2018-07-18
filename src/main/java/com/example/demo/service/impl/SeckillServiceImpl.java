package com.example.demo.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import com.example.demo.dao.Seckill;
import com.example.demo.dao.Successkilled;
import com.example.demo.dto.ExposerRsp;
import com.example.demo.dto.SeckillExecutionRsp;
import com.example.demo.enums.SeckillStatEnum;
import com.example.demo.mapper.SeckillMapper;
import com.example.demo.mapper.SuccesskilledMapper;
import com.example.demo.service.SeckillService;
import com.example.exception.RepeatKillException;
import com.example.exception.SeckillCloseException;
import com.example.exception.SeckillException;

@Service
public class SeckillServiceImpl implements SeckillService{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//  md5盐值字符串，用于混淆MD5
	private final String slat = "sdaafdalk21dsaasmdl^&%^";
	
	@Autowired
	private SeckillMapper seckillmapper;
	
	@Autowired
	private SuccesskilledMapper successkilledmapper;

	@Override
	public List<Seckill> getSeckillList() {
		// TODO Auto-generated method stub
		return seckillmapper.getSeckillList();
	}

	@Override
	public Seckill getSeckillById(long id) {
		// TODO Auto-generated method stub
		logger.error("seckillmapper.getSeckillById(id) "+seckillmapper.getSeckillById(id).getStarttime());
		return seckillmapper.getSeckillById(id);
	}

	@Override
	public ExposerRsp exprotSeckillUrl(long seckillId) {
		// TODO Auto-generated method stub
		Seckill seckill = seckillmapper.getSeckillById(seckillId);
		if(seckill==null) {
			return new ExposerRsp(false, seckillId);
		}
		
		Date startTime = seckill.getStarttime();
		logger.error("==startTime: "+startTime);
		
		Date endTime = seckill.getEndtime();
		logger.error("==endTime: "+endTime);
		
		Date nowTime = new Date();
		logger.error("==nowTime: "+nowTime);
		if(nowTime.getTime()<startTime.getTime() || nowTime.getTime()>endTime.getTime()) {
			return new ExposerRsp(false, seckillId, nowTime.getTime(), 
					startTime.getTime(), endTime.getTime());
		}
		String md5 = getMD5(seckillId);
		return new ExposerRsp(true, md5, seckillId);
	}
	
	/*
	 * md5加密
	 * @see com.example.demo.service.SeckillService#getMD5(long)
	 */
	@Override
    public String getMD5(long seckillId){
        String base = seckillId + "/" + slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }
    
    /**
     * 使用注解控制事务方法的优点
     * 1.开发团队达成一致约定，明确标注事务方法的编程风格
     * 2.保证事务方法的执行时间尽可能短，不要穿插其他网络操作，RPC/HTTP请求 或者 剥离到事务方法之外
     * 3.不是所有的方法都需要事务，如只有一条修改操作，只读操作不需要事务控制。
     */
    @Transactional
	@Override
	public SeckillExecutionRsp executeSeckill(long seckillId, String userPhone, String md5) throws SeckillException,RepeatKillException,SeckillCloseException {
		// TODO Auto-generated method stub
		if(md5==null || !md5.equals(getMD5(seckillId))) {
			throw new SeckillCloseException("seckill is closed");
		}
		
		//执行秒杀逻辑：减库存 + 记录购买行为
		Date nowtime = new Date();
		
		try {
			int updateCount = seckillmapper.reduceNumber(seckillId, nowtime);		
			if(updateCount<=0) {
				//没有更新到记录
				throw new SeckillCloseException("seckill is closed");
			}else {
				//记录购买行为
				int insertCount = successkilledmapper.insertSuccessKilled(seckillId, userPhone);
				if(insertCount <=0) {
					throw new RepeatKillException("seckill repeated");
				}else {
					//秒杀成功
					Successkilled successkilled = successkilledmapper.queryByIdWithSeckill(seckillId, userPhone);
					return new SeckillExecutionRsp(seckillId, SeckillStatEnum.SUCCESS, successkilled);
				}
			}
		}catch(SeckillCloseException e1) {
			throw e1;
		}catch(RepeatKillException e2) {
			throw e2;
		}catch(SeckillException e) {
			logger.error(e.getMessage(),e);
//          所有编译期异常转化为运行期异常
			throw new SeckillException("seckill inner error:"+e.getMessage());
		}

	}

}
