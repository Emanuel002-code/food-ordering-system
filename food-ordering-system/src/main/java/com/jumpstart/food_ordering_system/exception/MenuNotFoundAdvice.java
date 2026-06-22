package com.jumpstart.food_ordering_system.exception;


import com.jumpstart.food_ordering_system.Response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MenuNotFoundAdvice {

    @ExceptionHandler(MenuNotFoundException.class)
    public ResponseEntity<Response<Void>> handle(MenuNotFoundException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Response.error(404,ex.getMessage()));
    }
}
