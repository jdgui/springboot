package com.jundagui.web;

import com.jundagui.support.BusinessException;
import com.jundagui.web.vo.WebResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value = Exception.class)
    public WebResponse<Void> handleException(Exception e){
        log.warn("Got exception", e);
        if (e instanceof NullPointerException
                || e instanceof IllegalArgumentException
                || e instanceof UnsatisfiedServletRequestParameterException
                || e instanceof ServletRequestBindingException
                || e instanceof BindException) {
            return WebResponse.fail(ErrorEnum.ILLEGAL_ARGUMENT.status, e.getMessage());
        } else if (e instanceof BusinessException) {
            BusinessException be = (BusinessException) e;
            return WebResponse.fail(be.getErrorCode(), be.getMessage());
        } else {
            return WebResponse.fail(ErrorEnum.SYSTEM_ERROR.status, "system error");
        }
    }
}
