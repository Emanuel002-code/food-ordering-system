package com.jumpstart.food_ordering_system.exception;

import com.jumpstart.food_ordering_system.Response.Response;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

/*
 * This class sends the error response
 */
@RestControllerAdvice
public class GlobalExceptionAdvice
{
    // 404 - Category not found
    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<Response<Void>> handleCategoryNotFound(CategoryNotFoundException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Response.error(404,ex.getMessage()));
    }
    // 404 - Menu not found
    @ExceptionHandler(MenuNotFoundException.class)
    public ResponseEntity<Response<Void>> handleMenuNotFound(MenuNotFoundException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Response.error(404,ex.getMessage()));
    }
    // 409 - Database integrity errors
    @ExceptionHandler(CategoryHasMenusException.class)
    public ResponseEntity<Response<Void>> handleCategoryHasMenus(CategoryHasMenusException ex) {

        return  ResponseEntity.status(HttpStatus.CONFLICT).body(Response.error(409, ex.getMessage()));
    }
    // 400 - Bean Validation
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response<Void>> handleValidation(MethodArgumentNotValidException ex) {

        String message = Objects.requireNonNull(ex.getBindingResult()
                        .getFieldError())
                        .getDefaultMessage();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Response.error(400, message));
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Response<Void>> handleConstraintViolation(ConstraintViolationException ex) {

        String message = ex.getConstraintViolations()
                .stream()
                .findFirst()
                .map(ConstraintViolation::getMessage)
                .orElse("Validation error");

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Response.error(400, message));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<Void>> handleException(Exception ex) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Response.error(500, "An unexpected error occurred."));
    }



}
