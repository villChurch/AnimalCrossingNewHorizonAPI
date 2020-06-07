package com.williamspires.acnhapi.Advice;

import com.williamspires.acnhapi.Exceptions.ReactionNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class ReactionNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ReactionNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String reactionNotFoundException(ReactionNotFoundException ex){
        log.error(ex.getMessage());
        return ex.getMessage();
    }
}
