package cn.edu.guet.common.exception;

import cn.edu.guet.common.Result;
import cn.edu.guet.exception.addException;
import cn.edu.guet.exception.deleteException;
import cn.edu.guet.exception.updateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result handler(MethodArgumentNotValidException e) {
        log.error("实体校验异常：----------------{}", e);
        BindingResult bindingResult = e.getBindingResult();
        ObjectError objectError = bindingResult.getAllErrors().stream().findFirst().get();

        return Result.fail(objectError.getDefaultMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = deleteException.class)
    public Result handler(deleteException e) {
        log.error("删除异常：----------------{}", e);
        return Result.fail(e.getMessage());
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = addException.class)
    public Result handler(addException e) {
        log.error("添加异常：----------------{}", e);
        return Result.fail(e.getMessage());
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = updateException.class)
    public Result handler(updateException e) {
        log.error("修改异常：----------------{}", e);
        return Result.fail(e.getMessage());
    }
}