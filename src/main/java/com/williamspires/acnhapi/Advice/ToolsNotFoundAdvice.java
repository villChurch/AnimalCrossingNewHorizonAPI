package com.williamspires.acnhapi.Advice;

import com.williamspires.acnhapi.Exceptions.ToolsNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@ControllerAdvice
public class ToolsNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ToolsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String toolsNotFoundException(ToolsNotFoundException ex){
        log.error(ex.getMessage());
        return ex.getMessage();
    }
}
