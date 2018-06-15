package com.dragonball.common.exception;

public class BusinessException extends BaseException {
    private static final long serialVersionUID = 1L;

    public BusinessException(String errorCode, String... args) {
        super(errorCode, args);
    }

    public BusinessException(String errorCode, String errorMsg, String... args) {
        super(errorCode, errorMsg, args);
    }

    public BusinessException(String errorCode, Throwable t) {
        super(errorCode, t);
    }
}
