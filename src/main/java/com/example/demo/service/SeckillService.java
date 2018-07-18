package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.dao.Seckill;
import com.example.demo.dto.ExposerRsp;
import com.example.demo.dto.SeckillExecutionRsp;
import com.example.exception.RepeatKillException;
import com.example.exception.SeckillCloseException;
import com.example.exception.SeckillException;

public interface SeckillService {
	/*
	 * 查询所有秒杀
	 */
	List<Seckill> getSeckillList();
	
	/*
	 * 查询单条秒杀记录
	 */
	Seckill getSeckillById(long seckillId);
	
    /**
     * 秒杀开启时，输出秒杀接口地址，
     * 否则输出系统时间和秒杀时间
     *
     * @param seckillId
     */
	ExposerRsp exprotSeckillUrl(long seckillId);
	
    /**
     * 执行秒杀操作
     *
     * @param seckillId
     * @param userPhone
     * @param md5
     */
	SeckillExecutionRsp executeSeckill(long seckillId, String userPhone, String md5)
			throws SeckillException,RepeatKillException,SeckillCloseException;
	
	/*
	 * md5加密
	 */
	String getMD5(long seckillId);
}
