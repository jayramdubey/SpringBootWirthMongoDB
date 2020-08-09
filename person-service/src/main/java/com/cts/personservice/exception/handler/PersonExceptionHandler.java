package com.cts.personservice.exception.handler;

import com.cts.personservice.exception.DataConflictException;
import com.cts.personservice.exception.PreConditionedFailed;
import com.cts.personservice.exception.RecordNotFoundException;
import com.cts.personservice.exception.UnProcessableEntityException;
import com.cts.personservice.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class PersonExceptionHandler {

    //TODO: Create Error code constants

    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleRecordNotFoundException(RecordNotFoundException ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse("INCORRECT_REQUEST", Arrays.asList(ex.getLocalizedMessage()));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PreConditionedFailed.class)
    public final ResponseEntity<ErrorResponse> handlePreConditionFailedException(PreConditionedFailed ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse("PRECONDITION_FAILED", Arrays.asList(ex.getLocalizedMessage()));
        return new ResponseEntity<>(error, HttpStatus.PRECONDITION_FAILED);
    }

    @ExceptionHandler(UnProcessableEntityException.class)
    public final ResponseEntity<ErrorResponse> handleUnProcessableEntityException(UnProcessableEntityException ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse("UNPROCESSABLE_ENTITY", Arrays.asList(ex.getLocalizedMessage()));
        return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(DataConflictException.class)
    public final ResponseEntity<ErrorResponse> handleDataExistsExceptionException(DataConflictException ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse("DATA_CONFLICT", Arrays.asList(ex.getLocalizedMessage()));
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<ErrorResponse> handleException(MethodArgumentNotValidException ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse("BAD_REQUEST", fieldErrors(ex));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorResponse> handleException(Exception ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse("UNHANDLED_EXCEPTION", Arrays.asList(ex.getLocalizedMessage()));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private List<String> fieldErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult()
                .getFieldErrors().stream()
                .map(fieldError -> {
                    return new StringBuilder()
                            .append(fieldError.getField())
                            .append(" ")
                            .append(fieldError.getDefaultMessage())
                            .toString();
                })
                .collect(Collectors.toList());
    }
}