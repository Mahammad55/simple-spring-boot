package com.example.simplespringboot.exception;

public class CustomerIsAlreadyException extends RuntimeException{
    public CustomerIsAlreadyException() {
    }

    public CustomerIsAlreadyException(String message) {
        super(message);
    }
}
