package org.example.calendardevlop.Exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MyCustomException.class)
    public ResponseEntity<ErrorResponse> handleMyCustomException(MyCustomException e, HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(e.getCode(),e.getMessage(),request.getRequestURI());

        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }
}
