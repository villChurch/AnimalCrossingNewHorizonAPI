package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Exceptions.ConstructionNotFoundException;
import com.williamspires.acnhapi.Model.ApiEvent;
import com.williamspires.acnhapi.Model.Construction;
import com.williamspires.acnhapi.Repositories.ApiEventRepository;
import com.williamspires.acnhapi.Repositories.ConstructionRepository;
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
@Tag(name = "Construction Items", description = "Information on Construction items, such as bridges etc")
@RestController
public class ConstructionController {

    private final ConstructionRepository constructionRepository;
    private final ApiEventRepository apiEventRepository;
    ConstructionController(ConstructionRepository constructionRepository, ApiEventRepository apiEventRepository){
        this.constructionRepository = constructionRepository;
        this.apiEventRepository = apiEventRepository;
    }

    @Operation(summary = "Find construction counter item by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Construction.class)))),
            @ApiResponse(responseCode = "404", description = "Construction item not found")
    })
    @GetMapping("/construction/{name}")
    public Construction getConstructionByName(@Parameter(description = "Name of construction item")
                                                  @PathVariable String name) {
        ApiEvent event = new ApiEvent();
        event.setPath("/construction/" + name);
        Construction construction = constructionRepository.findConstructionByName(name);
        if(null == construction){
            List<Construction> constructionItems = constructionRepository.getAllConstruction();
            Map<String, Integer> likeness = new HashMap<>();
            constructionItems.forEach(constructionItem -> likeness.put(constructionItem.getName(),
                    LevenshteinDistance.percentage(name.toLowerCase(), constructionItem.getName().toLowerCase())));
            String key =
                    Collections.max(likeness.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
            log.warn("Construction item was not found called {} but one was found called {} with a {}% match to search term",
                    name, key, likeness.get(key));
            if (likeness.get(key) >= 75) {
                event.setPath("/consturction/" + key);
                log.info("Likeness was above or equal to 75% at {}% so returning construction item called {}", likeness.get(key), key);
                return constructionRepository.findConstructionByName(key);
            } else {
                throw new ConstructionNotFoundException(name);
            }
        }
        apiEventRepository.insertApiEvent(event);
        return construction;
    }
}
