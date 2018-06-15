package com.dragonball.common.context.response;

import com.dragonball.common.context.AbstractBaseDTO;
import com.dragonball.common.service.ResponseStatus;


public class AbstractServiceResponse extends AbstractBaseDTO implements IServiceResponse {
    protected ResponseStatus responseStatus;
    private boolean success = true;
    private boolean isException = false;

    public AbstractServiceResponse() {
    }

    public ResponseStatus getResponseStatus() {
        return this.responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean getIsException() {
        return this.isException;
    }

    public void setIsException(boolean isException) {
        this.isException = isException;
    }
}
