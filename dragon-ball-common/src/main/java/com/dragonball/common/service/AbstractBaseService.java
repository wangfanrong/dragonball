package com.dragonball.common.service;


import com.dragonball.common.context.response.AbstractServiceResponse;
import com.dragonball.common.enums.CommonResponseCodes;
import com.dragonball.common.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;

public abstract class AbstractBaseService {

    public AbstractBaseService() {
    }

    protected void success(AbstractServiceResponse response) {
        this.success(response, (String)null);
    }

    protected void success(AbstractServiceResponse response, String message) {
        ResponseStatus status = new ResponseStatus();
        if (message == null) {
            message = CommonResponseCodes.Success.getCode();
        }

        response.setSuccess(true);
        response.setIsException(false);
        status.setStatus(CommonResponseCodes.Success.getCode(), message);
        response.setResponseStatus(status);
    }

    protected void error(AbstractServiceResponse response, String message) {
        ResponseStatus status = new ResponseStatus();
        if (message == null) {
            message = CommonResponseCodes.Error.getCode();
        }

        response.setSuccess(false);
        response.setIsException(false);
        status.setStatus(CommonResponseCodes.Error.getCode(), message);
        response.setResponseStatus(status);
    }

    protected void error(AbstractServiceResponse response, BusinessException e) {
        ResponseStatus status = new ResponseStatus();
        String message = e.getErrorCode();
        if (StringUtils.isEmpty(message)) {
            message = e.getErrorMsg();
        }

        if (e.getArgs() != null && e.getArgs().length > 0) {
            message = String.format(message, (Object[])e.getArgs());
        }

        response.setSuccess(false);
        response.setIsException(false);
        status.setStatus(e.getErrorCode(), message);
        response.setResponseStatus(status);
    }
}
