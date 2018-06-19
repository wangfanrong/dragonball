package com.dragonball.model.user.enums;

/**
 * Created by 汪先森 on 2018/6/15.
 * 性别枚举
 */
public enum Sex {

    Boy(1,"男"),
    girl(2,"女");

    private int code;

    private String value;

    Sex(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public int getCode() {
        return code;
    }

    public static Sex getSexByCode(int code){
        for (Sex sex : Sex.values()){
            if (sex.getCode() == code){
                return sex;
            }
        }
        throw new IllegalArgumentException("未能找到匹配的Sex:"+ code);
    }
}
