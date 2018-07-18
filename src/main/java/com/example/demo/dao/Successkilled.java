package com.example.demo.dao;

import java.util.Date;
import javax.persistence.*;

public class Successkilled {
    @Id
    @Column(name = "seckillId")
    private Long seckillid;

    @Column(name = "userPhone")
    private String userphone;

    private Boolean state;

    @Column(name = "createTime")
    private Date createtime;
    
    private Seckill seckill;

    public Seckill getSeckill() {
		return seckill;
	}

	public void setSeckill(Seckill seckill) {
		this.seckill = seckill;
	}

	/**
     * @return seckillId
     */
    public Long getSeckillid() {
        return seckillid;
    }

    /**
     * @param seckillid
     */
    public void setSeckillid(Long seckillid) {
        this.seckillid = seckillid;
    }

    /**
     * @return userPhone
     */
    public String getUserphone() {
        return userphone;
    }

    /**
     * @param userphone
     */
    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    /**
     * @return state
     */
    public Boolean getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(Boolean state) {
        this.state = state;
    }

    /**
     * @return createTime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}