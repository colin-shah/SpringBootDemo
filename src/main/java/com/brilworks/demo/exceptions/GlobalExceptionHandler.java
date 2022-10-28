package com.brilworks.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityExistsException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public ErrorStatus handleEntityExistsException(EntityExistsException e) {
        return new ErrorStatus(HttpStatus.CONFLICT.value(), e.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorStatus handleEntityNotFoundException(EntityNotFoundException e) {
        return new ErrorStatus(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }
}
