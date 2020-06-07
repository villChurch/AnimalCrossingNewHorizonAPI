package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Exceptions.EventNotFoundException;
import com.williamspires.acnhapi.Model.acnhevents;
import com.williamspires.acnhapi.Repositories.AcnhEventsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AcnhEventsController {

    private final AcnhEventsRepository acnhEventsRepository;

    AcnhEventsController(AcnhEventsRepository acnhEventsRepository){
        this.acnhEventsRepository = acnhEventsRepository;
    }

    @GetMapping("/events/{name}")
    public List<acnhevents> getEventByName(@PathVariable String name) {
        List<acnhevents> events = acnhEventsRepository.findEventsByEvent(name);
        if(null == events || events.size() < 1){
            throw new EventNotFoundException(name);
        }
        return events;
    }

}
