package com.example.simplespringboot.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
@Slf4j
public class ExceptionHandledClass {

    @ExceptionHandler(CustomerByIdNotFoundException.class)
    public ResponseEntity<String> customerNotFoundExceptionHanded(CustomerByIdNotFoundException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), NOT_FOUND);
    }

    @ExceptionHandler(CustomerIsAlreadyExistingException.class)
    public ResponseEntity<String> customerIsAlreadyExistingExceptionHanded(CustomerIsAlreadyExistingException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(),CONFLICT);
    }
}
