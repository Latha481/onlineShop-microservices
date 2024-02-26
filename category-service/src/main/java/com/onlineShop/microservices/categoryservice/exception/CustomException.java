package com.onlineShop.microservices.categoryservice.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class CustomException{

    private LocalDateTime timestamp;
    private String message;
    private String details;
}
