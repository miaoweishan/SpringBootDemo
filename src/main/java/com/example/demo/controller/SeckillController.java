package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.Seckill;
import com.example.demo.dto.ExposerRsp;
import com.example.demo.dto.SeckillExecutionRsp;
import com.example.demo.dto.SeckillResult;
import com.example.demo.enums.SeckillStatEnum;
import com.example.demo.service.SeckillService;
import com.example.exception.RepeatKillException;
import com.example.exception.SeckillCloseException;

@RestController
@RequestMapping("seckill")
public class SeckillController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SeckillService seckillservice;
	
	/*
	 * 获取秒杀商品信息列表
	 * 获取 表 seckill 中的全部信息
	 */
	@GetMapping("list")
	public List<Seckill> querySeckillList(){
		return seckillservice.getSeckillList();
		
	}
	
	/*
	 * 获取单条秒杀商品信息
	 * 通过id 查询 seckill 表信息
	 */
	@PostMapping("getseckillbyid")
	public Seckill querySeckillByid(long id) {
		if("".equals(id)) {
			return null;
		}
		return seckillservice.getSeckillById(id);
		
	}
	
	/*
	 * 通过当前时间跟开始、结束时间比对
	 * 判断活动是否开始
	 */
	@PostMapping("exposer")
	public SeckillResult<ExposerRsp> exposer(long seckillId){
		SeckillResult<ExposerRsp> result;
		
		try {
			ExposerRsp exposer=seckillservice.exprotSeckillUrl(seckillId);
			result=new SeckillResult<ExposerRsp>(true,exposer);
		}catch(Exception e) {
			logger.error(e.getMessage(),e);
			result=new SeckillResult<>(false, e.getMessage());
		}
			
		return result;
	}
	
	@PostMapping("execute")
	public SeckillResult<SeckillExecutionRsp> execute(Long seckillId, String md5, String phone){
		if(phone==null) {
			return new SeckillResult<SeckillExecutionRsp>(false, "未注册");
		}
		
		try {
			SeckillExecutionRsp executionRsp = seckillservice.executeSeckill(seckillId, phone, md5);
			return new SeckillResult<SeckillExecutionRsp>(true, executionRsp);
		}catch(RepeatKillException e) {
			//重复秒杀
			SeckillExecutionRsp executionRsp = new SeckillExecutionRsp(seckillId, SeckillStatEnum.REPEAT_KILL);
			return new SeckillResult<SeckillExecutionRsp>(true, executionRsp);
		}catch(SeckillCloseException e) {
			//秒杀结束
			SeckillExecutionRsp executionRsp = new SeckillExecutionRsp(seckillId, SeckillStatEnum.END);
			return new SeckillResult<SeckillExecutionRsp>(true, executionRsp);			
		}catch(Exception e) {
			//代码报错
			logger.error(e.getMessage(),e);
			SeckillExecutionRsp executionRsp = new SeckillExecutionRsp(seckillId, SeckillStatEnum.INNER_ERROR);
			return new SeckillResult<SeckillExecutionRsp>(true, executionRsp);
		}
		
	}
	
    @RequestMapping(value = "/time/now", method = RequestMethod.GET)
    @ResponseBody
    public SeckillResult<Long> time(){
        Date now = new Date();
        return new SeckillResult(true, now.getTime());
    }
    
    @GetMapping("MD5")
    public SeckillResult seckillIdByMD5(long seckillid){
    	String seckillIdmd5 = seckillservice.getMD5(seckillid);
    	return new SeckillResult(true, seckillIdmd5);
    }

}
