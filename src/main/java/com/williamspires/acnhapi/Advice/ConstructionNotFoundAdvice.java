package com.williamspires.acnhapi.Advice;

import com.williamspires.acnhapi.Exceptions.ConstructionNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class ConstructionNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ConstructionNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String constructionNotFoundException(ConstructionNotFoundException ex){
        log.error(ex.getMessage());
        return ex.getMessage();
    }
}
