package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Exceptions.FurnitureNotFoundException;
import com.williamspires.acnhapi.Model.ApiEvent;
import com.williamspires.acnhapi.Model.Furniture;
import com.williamspires.acnhapi.Repositories.ApiEventRepository;
import com.williamspires.acnhapi.Repositories.FurnitureRepository;
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
@Tag(name = "Furniture", description = "Furniture information")
@RestController
public class FurnitureController {

    private final FurnitureRepository furnitureRepository;
    private final ApiEventRepository apiEventRepository;
    FurnitureController(FurnitureRepository furnitureRepository, ApiEventRepository apiEventRepository){
        this.furnitureRepository = furnitureRepository;
        this.apiEventRepository = apiEventRepository;
    }

    @Operation(summary = "Get furniture by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Furniture.class)))),
            @ApiResponse(responseCode = "404", description = "Furniture not found")
    })
    @GetMapping(value = "/furniture/{name}", produces = { "application/json" })
    public Furniture getFurnitureByName(@Parameter(description = "Furniture name") @PathVariable String name) {
        ApiEvent event = new ApiEvent();
        event.setPath("/furniture/" + name);
        Furniture furniture = furnitureRepository.getFurnitureByName(name);
        if(null == furniture){
            List<Furniture> allFurniture = furnitureRepository.getAllFurniture();
            Map<String, Integer> likeness = new HashMap<>();
            allFurniture.forEach(furni -> likeness.put(furni.getName(),
                    LevenshteinDistance.percentage(name.toLowerCase(), furni.getName().toLowerCase())));
            String key =
                    Collections.max(likeness.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
            log.warn("Furniture was not found called {} but one was found called {} with a {}% match to search term",
                    name, key, likeness.get(key));
            if (likeness.get(key) >= 75) {
                event.setPath("/furniture/" + key);
                log.info("Likeness was above or equal to 75% at {}% so returning furniture called {}", likeness.get(key), key);
                return furnitureRepository.getFurnitureByName(key);
            } else {
                throw new FurnitureNotFoundException(name);
            }
        }
        apiEventRepository.insertApiEvent(event);
        return furniture;
    }
}
