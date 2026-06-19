package com.jumpstart.food_ordering_system.exception;

import com.jumpstart.food_ordering_system.Response.Response;

import org.springframework.http.HttpStatus;
//import org.springframework.web.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
 * This class sends the error response
 */
@RestControllerAdvice
public class CategoryNotFoundAdvice
{
    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<Response<Void>> handle(CategoryNotFoundException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Response.error(404,ex.getMessage()));
    }
}
