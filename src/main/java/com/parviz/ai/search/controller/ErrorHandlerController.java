package com.parviz.ai.search.controller;

import com.parviz.ai.search.dto.app.ErrorResponse;
import com.parviz.ai.search.exception.DocumentNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ErrorHandlerController {

    private ResponseEntity<ErrorResponse> toResponseEntity(HttpStatus statusCode, ErrorResponse errorResponse) {
        return ResponseEntity
                .status(statusCode)
                .body(errorResponse);
    }

    @ExceptionHandler(DocumentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleDocumentNotFoundException(DocumentNotFoundException ex) {
            log.error(ex.getMessage(), ex);
            return toResponseEntity(HttpStatus.NOT_FOUND ,ErrorResponse.builder()
                    .errorCode(ex.getErrorCode())
                    .message(ex.getMessage())
                    .build());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleError(RuntimeException ex) {
            return toResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR ,ErrorResponse.builder()
                    .errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .message(ex.getMessage())
                    .build());
    }
}
