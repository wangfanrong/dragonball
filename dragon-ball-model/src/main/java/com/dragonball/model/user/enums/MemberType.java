package com.dragonball.model.user.enums;

/**
 * Created by 汪先森 on 2018/6/15.
 * 性别枚举
 */
public enum MemberType {

    REGULAR_MEMBER (1, "普通会员"),
    GOLD_MEMBER (2, "黄金会员"),
    DIAMOND_MEMBER (3, "钻石会员"),
    SUPREME_MEMBER (4, "至尊会员"),
    ADMIN (5, "管理员");

    private int code;

    private String value;

    MemberType(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public int getCode() {
        return code;
    }

    public static MemberType getMemberTypeByCode(int code){
        for (MemberType memberType : MemberType.values()){
            if (memberType.getCode() == code){
                return memberType;
            }
        }
        throw new IllegalArgumentException("未能找到匹配的MemberType:"+ code);
    }
}
