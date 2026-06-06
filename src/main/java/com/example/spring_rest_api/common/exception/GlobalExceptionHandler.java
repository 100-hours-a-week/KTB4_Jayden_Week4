package com.example.spring_rest_api.common.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ErrorResponseDto handleBusiness(BusinessException exception) {
        return ErrorResponseDto.of(exception.getMessage());
    }
}
