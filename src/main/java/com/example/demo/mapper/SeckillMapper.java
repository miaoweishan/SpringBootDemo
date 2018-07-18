package com.example.demo.mapper;

import java.util.Date;
import java.util.List;

import com.example.demo.dao.Seckill;
import com.example.demo.utils.MyMapper;

public interface SeckillMapper extends MyMapper<Seckill> {
	/*
	 * 查询所有秒杀
	 */
	List<Seckill> getSeckillList();
	
	/*
	 * 查询单条秒杀记录
	 */
	Seckill getSeckillById(long id);
	
    /**
     * 减库存
     * @param seckillId
     * @param killTime
     * @return 如果影响行数>1,表示更新的记录行数
     */
	int reduceNumber(long seckillId, Date killTime);
	
}