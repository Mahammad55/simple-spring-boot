package com.example.simplespringboot.exception;

public class CustomerIsAlreadyExistingException extends RuntimeException{
    public CustomerIsAlreadyExistingException() {
    }

    public CustomerIsAlreadyExistingException(String message) {
        super(message);
    }
}
