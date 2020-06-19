package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Exceptions.EventNotFoundException;
import com.williamspires.acnhapi.Model.ApiEvent;
import com.williamspires.acnhapi.Model.acnhevents;
import com.williamspires.acnhapi.Repositories.AcnhEventsRepository;
import com.williamspires.acnhapi.Repositories.ApiEventRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Events", description = "Information on in game events")
public class AcnhEventsController {

    private final AcnhEventsRepository acnhEventsRepository;
    private final ApiEventRepository apiEventRepository;

    AcnhEventsController(AcnhEventsRepository acnhEventsRepository, ApiEventRepository apiEventRepository){
        this.acnhEventsRepository = acnhEventsRepository;
        this.apiEventRepository = apiEventRepository;
    }

    @Operation(summary = "Find in game events")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "successful operation",
    content = @Content(array = @ArraySchema(schema = @Schema(implementation = acnhevents.class)))),
    @ApiResponse(responseCode = "404", description = "Event not found")})
    @GetMapping(value = "/events/{name}", produces = { "application/json", "application/text" })
    public List<acnhevents> getEventByName(@Parameter(description = "Name of event to search for")
                                               @PathVariable String name) {
        ApiEvent event = new ApiEvent();
        event.setPath("/events/" + name);
        apiEventRepository.insertApiEvent(event);
        List<acnhevents> events = acnhEventsRepository.findEventsByEvent(name);
        if(null == events || events.size() < 1){
            throw new EventNotFoundException(name);
        }
        return events;
    }

}
