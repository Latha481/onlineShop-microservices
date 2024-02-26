package com.onlineShop.microservices.categoryservice.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.method.MethodValidationResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.function.Predicate;


@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public final ResponseEntity<CustomException> handleProductNotFoundException(Exception ex, WebRequest request) throws Exception {
        CustomException exception = CustomException.builder()
                .timestamp(LocalDateTime.now())
                .message("Product Not Found for the requested filter")
                .details(request.getDescription(false)).build();
        return new ResponseEntity<CustomException>(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public final ResponseEntity<CustomException> handleCategoryNotFoundException(Exception ex, WebRequest request) throws Exception {
        CustomException exception = CustomException.builder()
                .timestamp(LocalDateTime.now())
                .message("Category requested not found")
                .details(request.getDescription(false)).build();
        return new ResponseEntity<CustomException>(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductNotSavedException.class)
    public final ResponseEntity<CustomException> handleSaveException(Exception ex, WebRequest request) throws Exception {
        CustomException exception = CustomException.builder()
                .timestamp(LocalDateTime.now())
                .message("Product save failed")
                .details(request.getDescription(false)).build();
        return new ResponseEntity<CustomException>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<CustomException> handleAllException(Exception ex, WebRequest request) throws Exception {
        CustomException exception = CustomException.builder()
                .timestamp(LocalDateTime.now())
                .message("Internal Server Error")
                .details(request.getDescription(false)).build();
        return new ResponseEntity<CustomException>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    public final ResponseEntity<CustomException> handleValidationException(Exception ex, WebRequest request) throws Exception {
        CustomException exception = CustomException.builder()
                .timestamp(LocalDateTime.now())
                .message("Request Validation Error")
                .details(ex.getMessage()).build();
        return new ResponseEntity<CustomException>(exception, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<CustomException> handleConstraintViolationException(Exception ex, WebRequest request) throws Exception {
        CustomException exception = CustomException.builder()
                .timestamp(LocalDateTime.now())
                .message("Request Validation Error")
                .details(ex.getMessage()).build();
        return new ResponseEntity<CustomException>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<CustomException> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, WebRequest request) {

        CustomException exception = CustomException.builder()
                .timestamp(LocalDateTime.now())
                .message("Constraint Validation Error")
                .details(ex.getMessage()).build();
        return new ResponseEntity<CustomException>(exception, HttpStatus.BAD_REQUEST);
    }


}
