package com.cola.sakura.common.exception;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.cola.sakura.common.enums.ResultEnum;
import com.cola.sakura.common.result.DataResult;
import com.cola.sakura.common.result.Result;
import com.cola.sakura.common.util.DataResultUtil;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.security.auth.message.AuthException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * @Author: cola
 * @License: (C) Copyright 2019-2020, liangyx Corporation Limited.
 * @Contact: Email: cola_nsd@163.com
 * @Date: 2020/7/16 18:42
 * @Version: 1.0
 * @Description:
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Log log = LogFactory.get();

    /**
     * @Description: 参数校验错误
     * @Author cola
     * @Date 2020/7/16 18:45
     **/
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public Result handleError(MissingServletRequestParameterException e) {
        log.warn("Missing Request Parameter", e);
        String message = String.format("Missing Request Parameter: %s", e.getParameterName());
        return DataResultUtil.error(ResultEnum.BAD_REQUEST.getValue(),message);
    }

    /**
     * @Description: 参数校验错误
     * @Author cola
     * @Date 2020/7/16 18:45
     **/
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public Result handleError(MethodArgumentTypeMismatchException e) {
        log.warn("Method Argument Type Mismatch", e);
        String message = String.format("Method Argument Type Mismatch: %s", e.getName());
        return DataResultUtil.error(ResultEnum.BAD_REQUEST.getValue(),message);
    }

    /**
     * @Description: 参数校验错误
     * @Author cola
     * @Date 2020/7/16 18:45
     **/
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Result handleError(MethodArgumentNotValidException e) {
        log.warn("Method Argument Not Valid", e);
        BindingResult result = e.getBindingResult();
        FieldError error = result.getFieldError();
        String message = String.format("%s:%s", error.getField(), error.getDefaultMessage());
        return DataResultUtil.error(ResultEnum.BAD_REQUEST.getValue(),message);
    }

    /**
     * @Description: 参数校验错误异常
     * @Author cola
     * @Date 2020/7/16 18:45
     **/
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Result handleError(BindException e) {
        log.warn("Bind Exception", e);
        FieldError error = e.getFieldError();
        String message = String.format("%s:%s", error.getField(), error.getDefaultMessage());
        return DataResultUtil.error(ResultEnum.BAD_REQUEST.getValue(),message);
    }

    /**
     * @Description: 参数校验错误异常
     * @Author cola
     * @Date 2020/7/16 18:45
     **/
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public Result handleError(ConstraintViolationException e) {
        log.warn("Constraint Violation", e);
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        ConstraintViolation<?> violation = violations.iterator().next();
        String path = ((PathImpl) violation.getPropertyPath()).getLeafNode().getName();
        String message = String.format("%s:%s", path, violation.getMessage());
        return DataResultUtil.error(ResultEnum.BAD_REQUEST.getValue(),message);
    }

    /**
     * @Description: 参数校验错误异常
     * @Author cola
     * @Date 2020/7/16 18:45
     **/
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Result handleError(HttpMessageNotReadableException e) {
        log.warn("HttpMessageNotReadableException ", e);
        String message = String.format("HttpMessageNotReadableException:%s", e.getMessage());
        return DataResultUtil.error(ResultEnum.BAD_REQUEST.getValue(),message);
    }


}
