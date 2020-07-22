package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Exceptions.FossilNotFoundException;
import com.williamspires.acnhapi.Model.ApiEvent;
import com.williamspires.acnhapi.Model.Fossil;
import com.williamspires.acnhapi.Repositories.ApiEventRepository;
import com.williamspires.acnhapi.Repositories.FossilRepository;
import com.williamspires.acnhapi.Utils.LevenshteinDistance;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Slf4j
@Tag(name = "Fossils", description = "Fossil information")
@RestController
public class FossilController {

    private final FossilRepository fossilRepository;
    private final ApiEventRepository apiEventRepository;
    FossilController(FossilRepository fossilRepository, ApiEventRepository apiEventRepository){
        this.fossilRepository = fossilRepository;
        this.apiEventRepository = apiEventRepository;
    }

    @Operation(summary = "Returns fossil information by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Fossil.class)))),
            @ApiResponse(responseCode = "404", description = "Fossil not found")
    })
    @GetMapping(value = "/fossils/{name}", produces = { "application/json" })
    public Fossil getFossilByName(@Parameter(description = "Fossil name") @PathVariable String name) {
        ApiEvent event = new ApiEvent();
        event.setPath("/fossils/" + name);
        Fossil fossil = fossilRepository.findFossilByName(name);
        if(null == fossil){
            List<Fossil> fossils = fossilRepository.getAllFossils();
            Map<String, Integer> likeness = new HashMap<>();
            fossils.forEach(fossilItem -> likeness.put(fossilItem.getName(),
                    LevenshteinDistance.percentage(name.toLowerCase(), fossilItem.getName().toLowerCase())));
            String key =
                    Collections.max(likeness.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
            log.warn("Fossil was not found called {} but one was found called {} with a {}% match to search term",
                    name, key, likeness.get(key));
            if (likeness.get(key) >= 75) {
                event.setPath("/fossils/" + name);
                log.info("Likeness was above or equal to 75% at {}% so returning fossil called {}", likeness.get(key), key);
                return fossilRepository.findFossilByName(key);
            } else {
                throw new FossilNotFoundException(name);
            }
        }
        apiEventRepository.insertApiEvent(event);
        return fossil;
    }
}
