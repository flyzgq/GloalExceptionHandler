package com.hackerrank.restcontrolleradvice.exception;

import com.hackerrank.restcontrolleradvice.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class FizzBuzzExceptionHandler  {
    //extends ResponseEntityExceptionHandler
  //TODO:: implement handler methods for FizzException, BuzzException and FizzBuzzException

    @ExceptionHandler(FizzException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public GlobalError fizzExceptionHandler(FizzException fizzException){
        return new GlobalError(fizzException.getMessage(), fizzException.getErrorReason());

    }

    @ExceptionHandler(BuzzException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public GlobalError buzzExceptionHandler(BuzzException buzzException){
        return new GlobalError(buzzException.getMessage(), buzzException.getErrorReason());
    }

    @ExceptionHandler(FizzBuzzException.class)
    @ResponseStatus(HttpStatus.INSUFFICIENT_STORAGE)
    public GlobalError fizzExceptionHandler(FizzBuzzException fizzBuzzException){
        return new GlobalError(fizzBuzzException.getMessage(), fizzBuzzException.getErrorReason());
    }
}
