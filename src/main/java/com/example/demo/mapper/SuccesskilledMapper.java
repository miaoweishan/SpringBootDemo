package com.example.demo.mapper;

import com.example.demo.dao.Successkilled;
import com.example.demo.utils.MyMapper;

public interface SuccesskilledMapper extends MyMapper<Successkilled> {
	/*
	 * 插入数据
	 */
	int insertSuccessKilled(long seckillId,String userPhone);
	
	/*
	 *通过条件查询 
	 */
	Successkilled queryByIdWithSeckill(long seckillId,String userPhone);
}