package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Model.acnhevents;
import com.williamspires.acnhapi.Repositories.AcnhEventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AcnhEventsController {

    @Autowired
    AcnhEventsRepository acnhEventsRepository;

    @GetMapping("/events/{name}")
    public List<acnhevents> getEventByName(@PathVariable String name) {
        return acnhEventsRepository.findEventsByEvent(name);
    }

}
