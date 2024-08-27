package com.kcc.springtest.global.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponse> handleRuntimeException(HttpServletRequest request, RuntimeException e) {
        log.error("handleRuntimeException", e);
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                request.getRequestURL().toString(),
                Map.of("error", "INTERNAL_SERVER_ERROR"),
                HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now().toString());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponse);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleNotFoundException(HttpServletRequest request, NotFoundException e) {
        log.error("handleNotFoundException", e);
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                request.getRequestURL().toString(),
                Map.of("error", e.getMessage()),
                e.getCode(), LocalDateTime.now().toString());
        return ResponseEntity.status(e.getCode()).body(exceptionResponse);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionResponse> handleBadRequestException(HttpServletRequest request, BadRequestException e) {
        log.error("handleBadRequestException", e);
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                request.getRequestURL().toString(),
                Map.of("error", e.getMessage()),
                e.getCode(), LocalDateTime.now().toString());
        return ResponseEntity.status(e.getCode()).body(exceptionResponse);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> messages = new HashMap<>();
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            messages.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ExceptionResponse response = null;
        response = new ExceptionResponse("", messages, HttpStatus.BAD_REQUEST, LocalDateTime.now().toString());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
