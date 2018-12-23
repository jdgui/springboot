package com.jundagui.support;

import com.jundagui.web.ErrorEnum;

public class BusinessException extends RuntimeException{

    private Integer errorCode;

    public BusinessException(ErrorEnum errorEnum){
        super(errorEnum.desc);
        this.errorCode=errorEnum.status;
    }

    public Integer getErrorCode() {
        return errorCode;
    }
}
