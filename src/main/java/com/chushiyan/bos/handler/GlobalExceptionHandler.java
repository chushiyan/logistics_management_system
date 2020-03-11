package com.chushiyan.bos.handler;

import com.chushiyan.bos.entity.Result;
import com.chushiyan.bos.entity.StatusCode;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author chushiyan
 * @email chushiyan0415@163.com
 * @description
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理所有参数校验时抛出的异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleBindException(ValidationException ex) {

        // 获取所有异常
        List<String> errors = new LinkedList<String>();
        if (ex instanceof ConstraintViolationException) {
            ConstraintViolationException exs = (ConstraintViolationException) ex;
            Set<ConstraintViolation<?>> violations = exs.getConstraintViolations();
            for (ConstraintViolation<?> item : violations) {
                errors.add(item.getMessage());
            }
        }
        String msg = StringUtils.join(errors, "/");
        return new Result(false, StatusCode.ERROR, msg);
    }

    /**
     * 处理所有校验失败的异常（MethodArgumentNotValidException异常）
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    // 设置响应状态码为400
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleBindGetException(MethodArgumentNotValidException ex) {
        // 获取所有异常
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());
        String msg = StringUtils.join(errors, "/");
        return new Result(false, StatusCode.ERROR, msg);
    }

    // Catch Shiro Exception
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public Result handle401(ShiroException e) {
        return new Result(false, StatusCode.ERROR, e.getMessage());
    }

    // Catch UnauthorizedException
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public Result handle401() {
        return new Result(false, StatusCode.ERROR, "没有权限");
    }


    @ExceptionHandler(RuntimeException.class)
    public Result globalException(RuntimeException e) {
        return new Result(false, StatusCode.ERROR, e.getMessage());
    }



    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result globalException(Exception e) {
        return new Result(false, StatusCode.ERROR, e.getMessage());
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
