package com.cfs.BookMyShow.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex , WebRequest request)
{
    ErrorResponse errordetails = new ErrorResponse(new Date(),
            HttpStatus.NOT_FOUND.value(),
            "Not found",ex.getMessage(),
            request.getDescription(false));

    return new ResponseEntity<>(errordetails , HttpStatus.NOT_FOUND);
}
    @ExceptionHandler(SeatUnavailableException.class)
    public ResponseEntity<?> SeatUnavailableException(SeatUnavailableException ex , WebRequest request)
    {
        ErrorResponse errordetails = new ErrorResponse(new Date(), HttpStatus.BAD_REQUEST.value(),"Not found",ex.getMessage(),request.getDescription(false));

        return new ResponseEntity<>(errordetails , HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler(Exception ex , WebRequest request)
    {
        ErrorResponse errordetails = new ErrorResponse(new Date(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                " server Not found",
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(errordetails , HttpStatus.BAD_REQUEST);
    }

}
