package com.dragonball.common.enums;

import org.apache.commons.lang3.StringUtils;

public enum ErrorCodeType {
    InternalError("SE001", "内部错误"),
    ExternalError("SE002", "外部错误"),
    IllegalArgument("S0102", "向服务器传递了不合法或不正确的参数");

    private String code;
    private String description;

    ErrorCodeType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static ErrorCodeType getErrorCodeTypeByCode(String code) {
        if (StringUtils.isEmpty(code)) {
            throw new NullPointerException("错误类型编码为空");
        } else {
            ErrorCodeType[] var1 = values();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                ErrorCodeType errorCodeType = var1[var3];
                if (errorCodeType.getCode().equals(code)) {
                    return errorCodeType;
                }
            }

            throw new IllegalArgumentException("未能找到匹配的ErrorCodeType:" + code);
        }
    }

    public String getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }
}

