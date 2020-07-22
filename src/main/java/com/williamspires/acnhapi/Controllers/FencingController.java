package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Exceptions.FencingNotFoundException;
import com.williamspires.acnhapi.Model.ApiEvent;
import com.williamspires.acnhapi.Model.Fencing;
import com.williamspires.acnhapi.Repositories.ApiEventRepository;
import com.williamspires.acnhapi.Repositories.FencingRepository;
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
@Tag(name = "Fences", description = "Information on fences")
@RestController
public class FencingController {

    private final FencingRepository fencingRepository;
    private final ApiEventRepository apiEventRepository;
    FencingController(FencingRepository fencingRepository, ApiEventRepository apiEventRepository){
        this.fencingRepository = fencingRepository;
        this.apiEventRepository = apiEventRepository;
    }

    @Operation(summary = "Find fencing by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Fencing.class)))),
            @ApiResponse(responseCode = "404", description = "Fencing item not found")
    })
    @GetMapping("/fencing/{name}")
    public Fencing getFenceByName(@Parameter(description = "Name of fencing") @PathVariable String name) {
        ApiEvent event = new ApiEvent();
        event.setPath("/fencing/" + name);
        Fencing fencing = fencingRepository.findFencingByName(name);
        if(null == fencing){
            List<Fencing> fences = fencingRepository.getAllFencing();
            Map<String, Integer> likeness = new HashMap<>();
            fences.forEach(fence -> likeness.put(fence.getName(),
                    LevenshteinDistance.percentage(name.toLowerCase(), fence.getName().toLowerCase())));
            String key =
                    Collections.max(likeness.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
            log.warn("Fence was not found called {} but one was found called {} with a {}% match to search term",
                    name, key, likeness.get(key));
            if (likeness.get(key) >= 75) {
                event.setPath("/fencing/" + key);
                log.info("Likeness was above or equal to 75% at {}% so returning fence called {}", likeness.get(key), key);
                return fencingRepository.findFencingByName(key);
            } else {
                throw new FencingNotFoundException(name);
            }
        }
        apiEventRepository.insertApiEvent(event);
        return  fencing;
    }
}
