package com.jumpstart.food_ordering_system.exception;

/*
  Handle and manage exceptions and errors
 */

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(String message) {
        super(message);
    }
}