package com.dragonball.model.user.entity;

import com.dragonball.common.model.BaseEntity;

import java.io.Serializable;

/**
 * Created by 汪先森 on 2018/3/21.
 * 用户
 */
public class UserEO extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 真实姓名
     */
    private String userName;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 用户账号
     */
    private String account;
    /**
     * 账号密码
     */
    private String password;
    /**
     * 头像
     */
    private String headPhoto;
    /**
     * 个性签名
     */
    private String signature;
    /**
     * QQ
     */
    private String QQ;
    /**
     * 微信
     */
    private String weiXin;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号码
     */
    private String phoneNumber;
    /**
     * 是否启用
     */
    private Boolean isEnable;
    /**
     * 成员等级
     */
    private Integer memberType;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadPhoto() {
        return headPhoto;
    }

    public void setHeadPhoto(String headPhoto) {
        this.headPhoto = headPhoto;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getWeiXin() {
        return weiXin;
    }

    public void setWeiXin(String weiXin) {
        this.weiXin = weiXin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
    }

    public Integer getMemberType() {
        return memberType;
    }

    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }
}
