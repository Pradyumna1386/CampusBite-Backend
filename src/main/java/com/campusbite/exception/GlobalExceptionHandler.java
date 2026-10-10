package com.campusbite.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> validation(MethodArgumentNotValidException ex){
        String message = ex.getBindingResult().getFieldErrors().stream().findFirst().map(e -> e.getField()+": "+e.getDefaultMessage()).orElse("Validation failed");
        return ResponseEntity.badRequest().body(Map.of("message", message));
    }
    @ExceptionHandler({ResourceNotFoundException.class, InvalidStatusException.class, IllegalArgumentException.class})
    public ResponseEntity<Map<String,String>> badRequest(RuntimeException ex){
        HttpStatus status = ex instanceof ResourceNotFoundException ? HttpStatus.NOT_FOUND : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(Map.of("message", ex.getMessage()));
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,String>> fallback(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("message", "Something went wrong on the server."));
    }
}
