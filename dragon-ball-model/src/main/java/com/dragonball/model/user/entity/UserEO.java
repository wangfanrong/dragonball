package com.dragonball.model.user.entity;

import com.dragonball.common.model.BaseEntity;

import java.io.Serializable;

/**
 * Created by 汪先森 on 2018/3/21.
 * 用户
 */
public class UserEO extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private int num;

    private String userName;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//
//        UserEO userEO = (UserEO) o;
//
//        if (num != userEO.num) return false;
//        return userName != null ? userName.equals(userEO.userName) : userEO.userName == null;
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result = super.hashCode();
//        result = 31 * result + num;
//        result = 31 * result + (userName != null ? userName.hashCode() : 0);
//        return result;
//    }
}
