package com.dragonball.common.enums;

import org.apache.commons.lang3.StringUtils;

public enum CommonResponseCodes {
    Success("00"),
    Error("01"),
    UserNotLogin("11"),
    AccessNotAllow("12"),
    UnKnownError("X00"),
    AccessItfError("X01"),
    FileDealError("X02");

    private String code;

    private CommonResponseCodes(String code) {
        this.code = code;
    }

    public static CommonResponseCodes getResponseByCode(String code) {
        if (StringUtils.isEmpty(code)) {
            throw new NullPointerException("响应编码为空");
        } else {
            CommonResponseCodes[] var1 = values();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                CommonResponseCodes responseCode = var1[var3];
                if (responseCode.getCode().equals(code)) {
                    return responseCode;
                }
            }

            throw new IllegalArgumentException("未能找到匹配的CommonResponseCode:" + code);
        }
    }

    public String getCode() {
        return this.code;
    }
}

