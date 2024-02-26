package com.onlineShop.microservices.categoryservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class HandlerMethodValidationException extends RuntimeException{
    public HandlerMethodValidationException() {
    }
}
