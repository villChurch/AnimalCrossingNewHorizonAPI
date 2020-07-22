package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Exceptions.ReactionNotFoundException;
import com.williamspires.acnhapi.Exceptions.ReactionSourceNotFoundException;
import com.williamspires.acnhapi.Model.ApiEvent;
import com.williamspires.acnhapi.Model.Reactions;
import com.williamspires.acnhapi.Repositories.ApiEventRepository;
import com.williamspires.acnhapi.Repositories.ReactionRepository;
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
@Tag(name = "Reactions", description = "Information on reactions")
@RestController
public class ReactionController {

    private final ReactionRepository reactionRepository;
    private final ApiEventRepository apiEventRepository;
    ReactionController(ReactionRepository reactionRepository, ApiEventRepository apiEventRepository){
        this.reactionRepository = reactionRepository;
        this.apiEventRepository = apiEventRepository;
    }

    @Operation(summary = "Get reaction information by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Reactions.class)))),
            @ApiResponse(responseCode = "404", description = "Reaction not found")
    })
    @GetMapping(value = "/reaction/{name}", produces = { "application/json" })
    public Reactions getReactionByName(@Parameter(description = "Reaction name") @PathVariable String name) {
        ApiEvent event = new ApiEvent();
        event.setPath("/reaction/" + name);
        Reactions reaction = reactionRepository.findReactionsByName(name);
        if(null == reaction){
            List<Reactions> reactions = reactionRepository.findAll();
            Map<String, Integer> likeness = new HashMap<>();
            reactions.forEach(react -> likeness.put(react.getName(),
                    LevenshteinDistance.percentage(name.toLowerCase(), react.getName().toLowerCase())));
            String key =
                    Collections.max(likeness.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
            log.warn("Reaction was not found called {} but one was found called {} with a {}% match to search term",
                    name, key, likeness.get(key));
            if (likeness.get(key) >= 75) {
                event.setPath("/reaction/" + key);
                log.info("Likeness was above or equal to 75% at {}% so returning reaction called {}", likeness.get(key), key);
                return reactionRepository.findReactionsByName(key);
            } else {
                throw new ReactionNotFoundException(name);
            }
        }
        apiEventRepository.insertApiEvent(event);
        return reaction;
    }

    @Operation(summary = "Get reactions by villager personality")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Reactions.class)))),
            @ApiResponse(responseCode = "404", description = "No reactions found for this personality")
    })
    @GetMapping(value = "/reaction/source/{source}", produces = { "application/json" })
    public List<Reactions> getReactionsBySource(@Parameter(description = "Villager personality") @PathVariable String source) {
        ApiEvent event = new ApiEvent();
        event.setPath("/reaction/source/" + source);
        apiEventRepository.insertApiEvent(event);
        List<Reactions> reactions = reactionRepository.findReactionsBySource(source);
        if(null == reactions || reactions.size() < 1){
            throw new ReactionSourceNotFoundException(source);
        }
        return reactions;
    }
}
