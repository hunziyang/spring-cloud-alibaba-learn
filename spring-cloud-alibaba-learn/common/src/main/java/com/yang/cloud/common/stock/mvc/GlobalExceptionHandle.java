package com.yang.cloud.common.stock.mvc;

import com.yang.cloud.common.stock.result.Result;
import com.yang.cloud.common.stock.result.ResultCode;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(Exception.class)
    public Result exception(Exception e){
        return Result.error(ResultCode.BAD_REQUEST);
    }
}
