package com.glory.restful.webservices.restfulwebservices.exception;

import com.glory.restful.webservices.restfulwebservices.user.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomResponseEntityExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
        ErrorEntity errorEntity = new ErrorEntity(LocalDateTime.now(),
                                                  ex.getMessage(),
                                                  request.getDescription(false));
        return new ResponseEntity(errorEntity, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> userNotFoundException(UserNotFoundException ex, WebRequest request) {
        ErrorEntity errorEntity = new ErrorEntity(LocalDateTime.now(),
                                                  ex.getMessage(),
                                                  request.getDescription(false));
        return new ResponseEntity(errorEntity, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {

        ErrorEntity errorEntity = new ErrorEntity(LocalDateTime.now(),
                                                  "Validation failed",
                                                  ex.getBindingResult().toString());
        return new ResponseEntity(errorEntity, HttpStatus.BAD_REQUEST);
    }
}
