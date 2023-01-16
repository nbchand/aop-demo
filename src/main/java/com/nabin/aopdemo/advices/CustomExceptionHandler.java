package com.nabin.aopdemo.advices;

import com.nabin.aopdemo.dtos.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Narendra
 * @version 1.0
 * @since 2023-01-16
 */
@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception exception) {
        return new ResponseEntity<>(new ErrorResponse(exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
