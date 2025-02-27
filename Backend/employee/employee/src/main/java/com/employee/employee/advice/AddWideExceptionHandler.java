package com.employee.employee.advice;


import com.employee.employee.exception.BadRequestException;
import com.employee.employee.exception.CustomerNotFoundException;
import com.employee.employee.util.StandResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AddWideExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<StandResponse> handleBadRequestException(BadRequestException e){
        return new ResponseEntity<>(new StandResponse(404,"Error",e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<StandResponse> handleNotFoundException(CustomerNotFoundException e){
        return new ResponseEntity<>(new StandResponse(404,"Error",e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
