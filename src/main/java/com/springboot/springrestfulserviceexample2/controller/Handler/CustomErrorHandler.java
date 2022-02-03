package com.springboot.springrestfulserviceexample2.controller.Handler;

import com.springboot.springrestfulserviceexample2.controller.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class CustomErrorHandler {
    @ExceptionHandler(StringIndexOutOfBoundsException.class)
    public ErrorResponse handleError2(StringIndexOutOfBoundsException e) {
        ErrorResponse errorResponse = new ErrorResponse(false, "Short index");
        log.error("Error result: {} ", errorResponse);
        return errorResponse;
    }

    @ExceptionHandler(NullPointerException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> handleError(NullPointerException e) {
        ErrorResponse errorResponse = new ErrorResponse(false, "Internal server error");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
