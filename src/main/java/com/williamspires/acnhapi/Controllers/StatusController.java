package com.williamspires.acnhapi.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @RequestMapping(method = { RequestMethod.GET, RequestMethod.HEAD}, value = "/status")
    @ResponseStatus(HttpStatus.OK)
    public String getStatus() {
        return "Ok";
    }
}
