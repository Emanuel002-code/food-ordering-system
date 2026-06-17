package com.jumpstart.food_ordering_system.exception;

import  com.jumpstart.food_ordering_system.exception.ErrorResponse;

import org.springframework.http.HttpStatus;
//import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CategoryNotFoundAdvice
{
    @ExceptionHandler(CategoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handle(CategoryNotFoundException ex) {

        return new ErrorResponse(ex.getMessage());
    }
}
