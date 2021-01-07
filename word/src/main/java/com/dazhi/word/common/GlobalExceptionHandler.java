 package com.dazhi.word.common;

import org.omg.PortableInterceptor.SUCCESSFUL;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author dazhi
 * @date 2021/01/06
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理自定义异常
     *
     */
    @ExceptionHandler(value = BaseException.class)
    @ResponseBody
    public Result bizExceptionHandler(BaseException e) {
        return Result.error(e.getMessage());
    }

    /**
     * 处理其他异常
     *
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionHandler(Exception e) {
        return Result.ok("FAILS");
    }
}
