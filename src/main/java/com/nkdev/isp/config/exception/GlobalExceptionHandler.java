package com.nkdev.isp.config.exception;

import com.nkdev.isp.commons.base.IspApiResponse;
import com.nkdev.isp.util.ResponseUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ValidationException;
import org.springframework.data.elasticsearch.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    /*
    ** Custom Error Message Code **
    HTTP responses
    * 1400 - Bad Request
    * 1401 - Unauthorized
    * 1403 - Invalid format
    * 1403 - Already exists
    * 1403 - Forbidden
    * 1404 - Not found
    * 1406 - Not Acceptable
    * 1429 - Too Many Requests
    * 1500 - Server error
    * 1502 - Bad Gateway
    * 1503 - Service Unavailable
    * 1504 - Gateway Timeout
    * 1403 - Limit Exceeded
    Powered by
    */

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<IspApiResponse<Void>> handleValidationException(HttpServletRequest request, ValidationException ex) {
        IspApiResponse<Void> response = ResponseUtil.error(List.of(ex.getMessage()), "Validation failed", 1403, request.getRequestURI()); // Validation error
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<IspApiResponse<Void>> handleResourceNotFoundException(HttpServletRequest request, ResourceNotFoundException ex) {
        IspApiResponse<Void> response = ResponseUtil.error(ex.getMessage(), "Resource not found", 1404, request.getRequestURI()); // Resource not found error
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<IspApiResponse<Void>> handleException(HttpServletRequest request, Exception ex) {
        List<String> errors = Arrays.asList(ex.getMessage());
        IspApiResponse<Void> response = ResponseUtil.error(errors, "An error occurred", 1500, request.getRequestURI()); // General error
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}