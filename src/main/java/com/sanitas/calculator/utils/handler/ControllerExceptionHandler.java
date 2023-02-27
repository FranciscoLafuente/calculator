package com.sanitas.calculator.utils.handler;

import com.sanitas.calculator.utils.domain.ErrorResponse;
import com.sanitas.calculator.utils.exceptions.OperationException;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.ZonedDateTime;

@RestControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> requestHandlingException(final Exception ex, final WebRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(buldErrorResponse(ex, ex.getMessage(), request, HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> requestHandlingConstraintViolationException(final ConstraintViolationException ex,
                                                                              final WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(buldErrorResponse(ex, ex.getMessage(), request, HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(OperationException.class)
    public ResponseEntity<ErrorResponse> requestHandlingOperationException(final OperationException ex,
                                                                              final WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(buldErrorResponse(ex, ex.getMessage(), request, HttpStatus.BAD_REQUEST));
    }

    private ErrorResponse buldErrorResponse(Exception ex, String message, WebRequest request, HttpStatus status) {
        ErrorResponse errorResponse = new ErrorResponse(message, status.name());
        errorResponse.setStatus((status.value()));
        errorResponse.setException(ex.getClass().getSimpleName());
        errorResponse.setPath(((ServletWebRequest) request).getRequest().getRequestURI());
        errorResponse.setTimestamp(ZonedDateTime.now().toString());

        return errorResponse;
    }

}
