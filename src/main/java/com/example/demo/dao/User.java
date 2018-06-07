package com.example.demo.dao;

import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class User {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 用户手机号
     */
    @JsonInclude(Include.NON_NULL)
    private String mobile;

    /**
     * 用户登录密码
     */
    @JsonInclude(Include.NON_NULL)
    private String password;

    /**
     * 用户昵称
     */
    @JsonInclude(Include.NON_NULL)
    private String nickname;

    /**
     * 支付密码
     */
    @JsonInclude(Include.NON_NULL)
    @Column(name = "payPassword")
    private String paypassword;

    /**
     * 手势登陆密码
     */
    @JsonInclude(Include.NON_NULL)
    @Column(name = "gesturesPassword")
    private String gesturespassword;

    /**
     * 身份证号码
     */
    @JsonInclude(Include.NON_NULL)
    @Column(name = "idCard")
    private String idcard;

    /**
     * 实名（姓名）
     */
    @JsonInclude(Include.NON_NULL)
    private String realname;

    /**
     * 是否已经实名认证
     */
    @JsonInclude(Include.NON_NULL)
    private Boolean authenticated;

    /**
     * 用户注册时间
     */
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss", locale="zh", timezone="GMT+8")
    @JsonInclude(Include.NON_NULL)
    @Column(name = "createDate")
    private Date createdate;

    /**
     * 用户信息修改时间
     */
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss", locale="zh", timezone="GMT+8")
    @JsonInclude(Include.NON_NULL)
    @Column(name = "modifyDate")
    private Date modifydate;

    /**
     * 用户唯一标识
     */
    @JsonInclude(Include.NON_NULL)
    @Column(name = "userKey")
    private String userkey;

    /**
     * 用户注册邀请源
     */
    @JsonInclude(Include.NON_NULL)
    @Column(name = "inviteSource")
    private String invitesource;

    /**
     * 用户注册渠道
     */
    @JsonInclude(Include.NON_NULL)
    private String source;

    /**
     * 微信用户openId
     */
    @JsonInclude(Include.NON_NULL)
    @Column(name = "openId")
    private String openid;

    /**
     * 微信是否免登陆
     */
    @JsonInclude(Include.NON_NULL)
    @Column(name = "weChat")
    private Boolean wechat;

    /**
     * 帐户是否冻结
     */
    @JsonInclude(Include.NON_NULL)
    private Boolean freeze;

    /**
     * 邀请码
     */
    @JsonInclude(Include.NON_NULL)
    @Column(name = "invitationCode")
    private Long invitationcode;

    /**
     *  0 个人用户，1 企业用户
     */
    @JsonInclude(Include.NON_NULL)
    private Boolean type;

    /**
     * 头像
     */
    @JsonInclude(Include.NON_NULL)
    private String avatar;

    /**
     * APP推送的用户唯一标识
     */
    @JsonInclude(Include.NON_NULL)
    private String cid;

    @JsonInclude(Include.NON_NULL)
    @Column(name = "noMerchant")
    private Boolean nomerchant;

    /**
     * 用途标识，0：外部账号；1：内部账户；2：中间户
     */
    @JsonInclude(Include.NON_NULL)
    private Boolean flag;

    /**
     * 用户名
     */
    @JsonInclude(Include.NON_NULL)
    @Column(name = "userName")
    private String username;

    /**
     * 备注
     */
    @JsonInclude(Include.NON_NULL)
    private String remark;

    /**
     * 风控风险分数
     */
    @JsonInclude(Include.NON_NULL)
    private Integer score;

    /**
     * 存管余额复投是否开启
     */
    @JsonInclude(Include.NON_NULL)
    @Column(name = "automaticInvestOpen")
    private Byte automaticinvestopen;

    /**
     * 是否激活（0-未激活，1-已激活）
     */
    @JsonInclude(Include.NON_NULL)
    private Boolean active;

    /**
     * 会员等级，1为普通级别
     */
    @JsonInclude(Include.NON_NULL)
    @Column(name = "levelId")
    private Long levelid;

    /**
     * VIP体验卡对应的会员等级，1表示不在VIP体验卡使用中
     */
    @JsonInclude(Include.NON_NULL)
    @Column(name = "expCardLevelId")
    private Long expcardlevelid;

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
     * 获取用户手机号
     *
     * @return mobile - 用户手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置用户手机号
     *
     * @param mobile 用户手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取用户登录密码
     *
     * @return password - 用户登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置用户登录密码
     *
     * @param password 用户登录密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取用户昵称
     *
     * @return nickname - 用户昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置用户昵称
     *
     * @param nickname 用户昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取支付密码
     *
     * @return payPassword - 支付密码
     */
    public String getPaypassword() {
        return paypassword;
    }

    /**
     * 设置支付密码
     *
     * @param paypassword 支付密码
     */
    public void setPaypassword(String paypassword) {
        this.paypassword = paypassword;
    }

    /**
     * 获取手势登陆密码
     *
     * @return gesturesPassword - 手势登陆密码
     */
    public String getGesturespassword() {
        return gesturespassword;
    }

    /**
     * 设置手势登陆密码
     *
     * @param gesturespassword 手势登陆密码
     */
    public void setGesturespassword(String gesturespassword) {
        this.gesturespassword = gesturespassword;
    }

    /**
     * 获取身份证号码
     *
     * @return idCard - 身份证号码
     */
    public String getIdcard() {
        return idcard;
    }

    /**
     * 设置身份证号码
     *
     * @param idcard 身份证号码
     */
    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    /**
     * 获取实名（姓名）
     *
     * @return realname - 实名（姓名）
     */
    public String getRealname() {
        return realname;
    }

    /**
     * 设置实名（姓名）
     *
     * @param realname 实名（姓名）
     */
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /**
     * 获取是否已经实名认证
     *
     * @return authenticated - 是否已经实名认证
     */
    public Boolean getAuthenticated() {
        return authenticated;
    }

    /**
     * 设置是否已经实名认证
     *
     * @param authenticated 是否已经实名认证
     */
    public void setAuthenticated(Boolean authenticated) {
        this.authenticated = authenticated;
    }

    /**
     * 获取用户注册时间
     *
     * @return createDate - 用户注册时间
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 设置用户注册时间
     *
     * @param createdate 用户注册时间
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * 获取用户信息修改时间
     *
     * @return modifyDate - 用户信息修改时间
     */
    public Date getModifydate() {
        return modifydate;
    }

    /**
     * 设置用户信息修改时间
     *
     * @param modifydate 用户信息修改时间
     */
    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    /**
     * 获取用户唯一标识
     *
     * @return userKey - 用户唯一标识
     */
    public String getUserkey() {
        return userkey;
    }

    /**
     * 设置用户唯一标识
     *
     * @param userkey 用户唯一标识
     */
    public void setUserkey(String userkey) {
        this.userkey = userkey;
    }

    /**
     * 获取用户注册邀请源
     *
     * @return inviteSource - 用户注册邀请源
     */
    public String getInvitesource() {
        return invitesource;
    }

    /**
     * 设置用户注册邀请源
     *
     * @param invitesource 用户注册邀请源
     */
    public void setInvitesource(String invitesource) {
        this.invitesource = invitesource;
    }

    /**
     * 获取用户注册渠道
     *
     * @return source - 用户注册渠道
     */
    public String getSource() {
        return source;
    }

    /**
     * 设置用户注册渠道
     *
     * @param source 用户注册渠道
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * 获取微信用户openId
     *
     * @return openId - 微信用户openId
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 设置微信用户openId
     *
     * @param openid 微信用户openId
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * 获取微信是否免登陆
     *
     * @return weChat - 微信是否免登陆
     */
    public Boolean getWechat() {
        return wechat;
    }

    /**
     * 设置微信是否免登陆
     *
     * @param wechat 微信是否免登陆
     */
    public void setWechat(Boolean wechat) {
        this.wechat = wechat;
    }

    /**
     * 获取帐户是否冻结
     *
     * @return freeze - 帐户是否冻结
     */
    public Boolean getFreeze() {
        return freeze;
    }

    /**
     * 设置帐户是否冻结
     *
     * @param freeze 帐户是否冻结
     */
    public void setFreeze(Boolean freeze) {
        this.freeze = freeze;
    }

    /**
     * 获取邀请码
     *
     * @return invitationCode - 邀请码
     */
    public Long getInvitationcode() {
        return invitationcode;
    }

    /**
     * 设置邀请码
     *
     * @param invitationcode 邀请码
     */
    public void setInvitationcode(Long invitationcode) {
        this.invitationcode = invitationcode;
    }

    /**
     * 获取 0 个人用户，1 企业用户
     *
     * @return type -  0 个人用户，1 企业用户
     */
    public Boolean getType() {
        return type;
    }

    /**
     * 设置 0 个人用户，1 企业用户
     *
     * @param type  0 个人用户，1 企业用户
     */
    public void setType(Boolean type) {
        this.type = type;
    }

    /**
     * 获取头像
     *
     * @return avatar - 头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置头像
     *
     * @param avatar 头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取APP推送的用户唯一标识
     *
     * @return cid - APP推送的用户唯一标识
     */
    public String getCid() {
        return cid;
    }

    /**
     * 设置APP推送的用户唯一标识
     *
     * @param cid APP推送的用户唯一标识
     */
    public void setCid(String cid) {
        this.cid = cid;
    }

    /**
     * @return noMerchant
     */
    public Boolean getNomerchant() {
        return nomerchant;
    }

    /**
     * @param nomerchant
     */
    public void setNomerchant(Boolean nomerchant) {
        this.nomerchant = nomerchant;
    }

    /**
     * 获取用途标识，0：外部账号；1：内部账户；2：中间户
     *
     * @return flag - 用途标识，0：外部账号；1：内部账户；2：中间户
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * 设置用途标识，0：外部账号；1：内部账户；2：中间户
     *
     * @param flag 用途标识，0：外部账号；1：内部账户；2：中间户
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    /**
     * 获取用户名
     *
     * @return userName - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
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
     * 获取风控风险分数
     *
     * @return score - 风控风险分数
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 设置风控风险分数
     *
     * @param score 风控风险分数
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 获取存管余额复投是否开启
     *
     * @return automaticInvestOpen - 存管余额复投是否开启
     */
    public Byte getAutomaticinvestopen() {
        return automaticinvestopen;
    }

    /**
     * 设置存管余额复投是否开启
     *
     * @param automaticinvestopen 存管余额复投是否开启
     */
    public void setAutomaticinvestopen(Byte automaticinvestopen) {
        this.automaticinvestopen = automaticinvestopen;
    }

    /**
     * 获取是否激活（0-未激活，1-已激活）
     *
     * @return active - 是否激活（0-未激活，1-已激活）
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * 设置是否激活（0-未激活，1-已激活）
     *
     * @param active 是否激活（0-未激活，1-已激活）
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * 获取会员等级，1为普通级别
     *
     * @return levelId - 会员等级，1为普通级别
     */
    public Long getLevelid() {
        return levelid;
    }

    /**
     * 设置会员等级，1为普通级别
     *
     * @param levelid 会员等级，1为普通级别
     */
    public void setLevelid(Long levelid) {
        this.levelid = levelid;
    }

    /**
     * 获取VIP体验卡对应的会员等级，1表示不在VIP体验卡使用中
     *
     * @return expCardLevelId - VIP体验卡对应的会员等级，1表示不在VIP体验卡使用中
     */
    public Long getExpcardlevelid() {
        return expcardlevelid;
    }

    /**
     * 设置VIP体验卡对应的会员等级，1表示不在VIP体验卡使用中
     *
     * @param expcardlevelid VIP体验卡对应的会员等级，1表示不在VIP体验卡使用中
     */
    public void setExpcardlevelid(Long expcardlevelid) {
        this.expcardlevelid = expcardlevelid;
    }
}