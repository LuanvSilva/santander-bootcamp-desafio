package com.example.santander.santander.controller.exception;

import java.util.NoSuchElementException;

import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalexceptionHandler {
    
    private final Logger logger = LoggerFactory.getLogger(GlobalexceptionHandler.class); 

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.status(Response.SC_BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNotFoundException(NoSuchElementException e) {
        return ResponseEntity.status(Response.SC_NOT_FOUND).body( "Resources ID not found " + e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleUnexpectedException(Throwable e) {
        
        logger.error("Unexpected server error", e);
        return ResponseEntity.status(Response.SC_INTERNAL_SERVER_ERROR).body("Unexpected server error, see the logs. " + e.getMessage());
    }

}
