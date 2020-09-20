package com.williamspires.acnhapi.Advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.DateTimeException;

@ControllerAdvice
public class DateTimeExceptionAdvice {
    @ResponseBody
    @ExceptionHandler(DateTimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String dateTimeException(DateTimeException dte) {
        return dte.getMessage();
    }
}
