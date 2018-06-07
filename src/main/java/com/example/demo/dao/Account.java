package com.example.demo.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import com.example.demo.dao.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Account {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 帐户编码
     */
    private String no;

    /**
     * 用户id
     */
    @JsonInclude(Include.NON_NULL)
    @Column(name = "userId")
    private Long userid;

    /**
     * 帐户余额
     */
    @JsonInclude(Include.NON_NULL)
    private BigDecimal balance;

    /**
     * 帐户角色
INVESTOR-投资人，BORROWERS-借款人,GUARANTEECORP-担保机构,PLATFORM_COMPENSATORY-平台代偿账户
     */
    @JsonInclude(Include.NON_NULL)
    private String role;

    /**
     * 创建时间
     */
    @JsonInclude(Include.NON_NULL)
    @Column(name = "createDate")
    private Date createdate;

    /**
     * 调整时间
     */
    @JsonInclude(Include.NON_NULL)
    @Column(name = "modifyDate")
    private Date modifydate;

    /**
     * 用户活期历史总收益
     */
    @JsonInclude(Include.NON_NULL)
    @Column(name = "currentRevenue")
    private BigDecimal currentrevenue;

    /**
     * 定期历史总收益
     */
    @JsonInclude(Include.NON_NULL)
    @Column(name = "periodicalRevenue")
    private BigDecimal periodicalrevenue;

    /**
     * 等额本息产品历史总利息
     */
    @JsonInclude(Include.NON_NULL)
    @Column(name = "averageRevenue")
    private BigDecimal averagerevenue;

    /**
     * 虚拟收入
     */
    @JsonInclude(Include.NON_NULL)
    @Column(name = "virtualIncome")
    private BigDecimal virtualincome;

    /**
     * 虚拟转出
     */
    @JsonInclude(Include.NON_NULL)
    @Column(name = "virtualOut")
    private BigDecimal virtualout;

    /**
     * 备注
     */
    @JsonInclude(Include.NON_NULL)
    private String remark;

    /**
     * 帐户类型;  person,个人账户, enterprise企业帐户, platform平台帐户;
     */
    @JsonInclude(Include.NON_NULL)
    private String type;

    /**
     * 账户是否删除 0：未删除；1：已删除
     */
    @JsonInclude(Include.NON_NULL)
    private Boolean deleted;

    /**
     * 账户冻结金额
     */
    @JsonInclude(Include.NON_NULL)
    private BigDecimal freeze;

    /**
     * 审核状态
     */
    @JsonInclude(Include.NON_NULL)
    @Column(name = "auditState")
    private String auditstate;

    /**
     * 状态(DEACTIVATED未开户,ACTIVATED已激活,NO_ACTIVATED待激活)
     */
    @JsonInclude(Include.NON_NULL)
    private String state;

    /**
     * 是否存管
     */
    @JsonInclude(Include.NON_NULL)
    private Boolean custodyed;

    /**
     * 开户时间
     */
    @JsonInclude(Include.NON_NULL)
    @Column(name = "openTime")
    private Date opentime;
    
    @JsonInclude(Include.NON_NULL)
    private Long version;

    /**
     * 渠道号
     */
    @JsonInclude(Include.NON_NULL)
    @Column(name = "providerNo")
    private String providerno;

    /**
     * e签宝账户id
     */
    @JsonInclude(Include.NON_NULL)
    private String esign;
    
    @JsonInclude(Include.NON_NULL)
    private List<User> user;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取帐户编码
     *
     * @return no - 帐户编码
     */
    public String getNo() {
        return no;
    }

    /**
     * 设置帐户编码
     *
     * @param no 帐户编码
     */
    public void setNo(String no) {
        this.no = no;
    }

    /**
     * 获取用户id
     *
     * @return userId - 用户id
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * 设置用户id
     *
     * @param userid 用户id
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * 获取帐户余额
     *
     * @return balance - 帐户余额
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * 设置帐户余额
     *
     * @param balance 帐户余额
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * 获取帐户角色
INVESTOR-投资人，BORROWERS-借款人,GUARANTEECORP-担保机构,PLATFORM_COMPENSATORY-平台代偿账户
     *
     * @return role - 帐户角色
INVESTOR-投资人，BORROWERS-借款人,GUARANTEECORP-担保机构,PLATFORM_COMPENSATORY-平台代偿账户
     */
    public String getRole() {
        return role;
    }

    /**
     * 设置帐户角色
INVESTOR-投资人，BORROWERS-借款人,GUARANTEECORP-担保机构,PLATFORM_COMPENSATORY-平台代偿账户
     *
     * @param role 帐户角色
INVESTOR-投资人，BORROWERS-借款人,GUARANTEECORP-担保机构,PLATFORM_COMPENSATORY-平台代偿账户
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * 获取创建时间
     *
     * @return createDate - 创建时间
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 设置创建时间
     *
     * @param createdate 创建时间
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * 获取调整时间
     *
     * @return modifyDate - 调整时间
     */
    public Date getModifydate() {
        return modifydate;
    }

    /**
     * 设置调整时间
     *
     * @param modifydate 调整时间
     */
    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    /**
     * 获取用户活期历史总收益
     *
     * @return currentRevenue - 用户活期历史总收益
     */
    public BigDecimal getCurrentrevenue() {
        return currentrevenue;
    }

    /**
     * 设置用户活期历史总收益
     *
     * @param currentrevenue 用户活期历史总收益
     */
    public void setCurrentrevenue(BigDecimal currentrevenue) {
        this.currentrevenue = currentrevenue;
    }

    /**
     * 获取定期历史总收益
     *
     * @return periodicalRevenue - 定期历史总收益
     */
    public BigDecimal getPeriodicalrevenue() {
        return periodicalrevenue;
    }

    /**
     * 设置定期历史总收益
     *
     * @param periodicalrevenue 定期历史总收益
     */
    public void setPeriodicalrevenue(BigDecimal periodicalrevenue) {
        this.periodicalrevenue = periodicalrevenue;
    }

    /**
     * 获取等额本息产品历史总利息
     *
     * @return averageRevenue - 等额本息产品历史总利息
     */
    public BigDecimal getAveragerevenue() {
        return averagerevenue;
    }

    /**
     * 设置等额本息产品历史总利息
     *
     * @param averagerevenue 等额本息产品历史总利息
     */
    public void setAveragerevenue(BigDecimal averagerevenue) {
        this.averagerevenue = averagerevenue;
    }

    /**
     * 获取虚拟收入
     *
     * @return virtualIncome - 虚拟收入
     */
    public BigDecimal getVirtualincome() {
        return virtualincome;
    }

    /**
     * 设置虚拟收入
     *
     * @param virtualincome 虚拟收入
     */
    public void setVirtualincome(BigDecimal virtualincome) {
        this.virtualincome = virtualincome;
    }

    /**
     * 获取虚拟转出
     *
     * @return virtualOut - 虚拟转出
     */
    public BigDecimal getVirtualout() {
        return virtualout;
    }

    /**
     * 设置虚拟转出
     *
     * @param virtualout 虚拟转出
     */
    public void setVirtualout(BigDecimal virtualout) {
        this.virtualout = virtualout;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取帐户类型;  person,个人账户, enterprise企业帐户, platform平台帐户;
     *
     * @return type - 帐户类型;  person,个人账户, enterprise企业帐户, platform平台帐户;
     */
    public String getType() {
        return type;
    }

    /**
     * 设置帐户类型;  person,个人账户, enterprise企业帐户, platform平台帐户;
     *
     * @param type 帐户类型;  person,个人账户, enterprise企业帐户, platform平台帐户;
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取账户是否删除 0：未删除；1：已删除
     *
     * @return deleted - 账户是否删除 0：未删除；1：已删除
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * 设置账户是否删除 0：未删除；1：已删除
     *
     * @param deleted 账户是否删除 0：未删除；1：已删除
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * 获取账户冻结金额
     *
     * @return freeze - 账户冻结金额
     */
    public BigDecimal getFreeze() {
        return freeze;
    }

    /**
     * 设置账户冻结金额
     *
     * @param freeze 账户冻结金额
     */
    public void setFreeze(BigDecimal freeze) {
        this.freeze = freeze;
    }

    /**
     * 获取审核状态
     *
     * @return auditState - 审核状态
     */
    public String getAuditstate() {
        return auditstate;
    }

    /**
     * 设置审核状态
     *
     * @param auditstate 审核状态
     */
    public void setAuditstate(String auditstate) {
        this.auditstate = auditstate;
    }

    /**
     * 获取状态(DEACTIVATED未开户,ACTIVATED已激活,NO_ACTIVATED待激活)
     *
     * @return state - 状态(DEACTIVATED未开户,ACTIVATED已激活,NO_ACTIVATED待激活)
     */
    public String getState() {
        return state;
    }

    /**
     * 设置状态(DEACTIVATED未开户,ACTIVATED已激活,NO_ACTIVATED待激活)
     *
     * @param state 状态(DEACTIVATED未开户,ACTIVATED已激活,NO_ACTIVATED待激活)
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 获取是否存管
     *
     * @return custodyed - 是否存管
     */
    public Boolean getCustodyed() {
        return custodyed;
    }

    /**
     * 设置是否存管
     *
     * @param custodyed 是否存管
     */
    public void setCustodyed(Boolean custodyed) {
        this.custodyed = custodyed;
    }

    /**
     * 获取开户时间
     *
     * @return openTime - 开户时间
     */
    public Date getOpentime() {
        return opentime;
    }

    /**
     * 设置开户时间
     *
     * @param opentime 开户时间
     */
    public void setOpentime(Date opentime) {
        this.opentime = opentime;
    }

    /**
     * @return version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * @param version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * 获取渠道号
     *
     * @return providerNo - 渠道号
     */
    public String getProviderno() {
        return providerno;
    }

    /**
     * 设置渠道号
     *
     * @param providerno 渠道号
     */
    public void setProviderno(String providerno) {
        this.providerno = providerno;
    }

    /**
     * 获取e签宝账户id
     *
     * @return esign - e签宝账户id
     */
    public String getEsign() {
        return esign;
    }

    /**
     * 设置e签宝账户id
     *
     * @param esign e签宝账户id
     */
    public void setEsign(String esign) {
        this.esign = esign;
    }

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}
    
}