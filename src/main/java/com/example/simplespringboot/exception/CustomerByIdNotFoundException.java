package com.example.simplespringboot.exception;

public class CustomerByIdNotFoundException extends RuntimeException{
    public CustomerByIdNotFoundException() {
    }

    public CustomerByIdNotFoundException(String message) {
        super(message);
    }
}
