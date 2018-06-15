package com.dragonball.common.service;

public class ResponseStatus {
    private String code;
    private String message;

    public ResponseStatus() {
    }

    public ResponseStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public void setStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

