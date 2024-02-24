package com.onlineShop.microservices.categoryservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class ProductNotSavedException extends RuntimeException{
    public ProductNotSavedException() {
    }

    public ProductNotSavedException(String message) {
        super(message);
    }
}
