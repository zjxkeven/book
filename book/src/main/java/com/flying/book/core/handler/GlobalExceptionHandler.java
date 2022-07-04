package com.flying.book.core.handler;

import com.flying.book.core.ResultCode;
import com.flying.book.core.exception.BaseException;
import com.flying.book.core.exception.BusinessException;
import com.flying.book.core.web.AjaxResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 基础异常
     */
    @ExceptionHandler(BaseException.class)
    public AjaxResult baseException(BaseException e) {
        log.error(e.getMessage(), e);
        return AjaxResult.error(e.getMessage());
    }

    /**
     * 自定义业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public AjaxResult businessException(BusinessException e) {
        log.error("自定义业务异常：", e);
        if (e.getMessage().contains("Caller doesn't have normal practice status")) {
            e.setMessage(e.getMessage().replace("Caller doesn't have normal practice status", "用户积分不足，已被停业"));
        }
        return AjaxResult.error(Integer.valueOf(e.getCode()), e.getMessage());
    }

    /**
     * 参数读取异常
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public AjaxResult httpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error("参数读取异常：" , e);
        String msg = e.getMessage();
        String param = msg.substring(msg.indexOf("[\"") + 2, msg.indexOf("\"]"));
        return AjaxResult.error(400, String.format(ResultCode.PARAM_READABLE_ERR.message(), param));
    }


    /**
     * 数据异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(DataAccessException.class)
    public AjaxResult dataAccessException(DataAccessException e) {
        log.error(e.getMessage(), e);
        return AjaxResult.error("数据异常，请联系管理员！");
    }

    /**
     * 数据库sql异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(SQLException.class)
    public AjaxResult sqlException(SQLException e) {
        log.error(e.getMessage(), e);
        return AjaxResult.error("系统错误，请联系管理员！");
    }

    /**
     * 自定义验证异常
     */
    @ExceptionHandler(BindException.class)
    public AjaxResult validatedBindException(BindException e) {
        log.error(e.getMessage(), e);
        String message = e.getAllErrors().get(0).getDefaultMessage();
        return AjaxResult.error(message);
    }

    /**
     * 类转换异常
     */
    @ExceptionHandler(ClassCastException.class)
    public AjaxResult handleClassCastException(ClassCastException e) {
        log.error(e.getMessage(), e);
        return AjaxResult.error(ResultCode.CLASS_CAST_EXCEPTION.code(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public AjaxResult handleException(Exception e) {
        log.error(e.getMessage(), e);
        return AjaxResult.error(e.getMessage());
    }
}
