package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Exceptions.RecipeNotFoundException;
import com.williamspires.acnhapi.Model.ApiEvent;
import com.williamspires.acnhapi.Model.Recipes;
import com.williamspires.acnhapi.Repositories.ApiEventRepository;
import com.williamspires.acnhapi.Repositories.RecipesRepository;
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
@Tag(name = "DIYs", description = "Information about DIYs")
@RestController
public class RecipeController {

    private final RecipesRepository recipesRepository;
    private final ApiEventRepository apiEventRepository;
    RecipeController(RecipesRepository recipesRepository, ApiEventRepository apiEventRepository){
        this.recipesRepository = recipesRepository;
        this.apiEventRepository = apiEventRepository;
    }

    @Operation(summary = "Get DIY information by name", description = "Returns DIY information by name of DIY")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Recipes.class)))),
            @ApiResponse(responseCode = "404", description = "DIY not found")
    })
    @GetMapping(value = "/diy/{name}", produces = { "application/json" })
    public Recipes getByName(@Parameter(description = "DIY name") @PathVariable String name) {
        ApiEvent event = new ApiEvent();
        event.setPath("/diy/" + name);
        Recipes recipe = recipesRepository.findRecipesByName(name);
        if(null == recipe){
            List<Recipes> recipes = recipesRepository.getAllRecipes();
            Map<String, Integer> likeness = new HashMap<>();
            recipes.forEach(recipes1 -> likeness.put(recipes1.getName(),
                    LevenshteinDistance.percentage(name.toLowerCase(), recipes1.getName().toLowerCase())));
            String key =
                    Collections.max(likeness.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
            log.warn("Recipe was not found called {} but one was found called {} with a {}% match to search term",
                    name, key, likeness.get(key));
            if (likeness.get(key) >= 75) {
                event.setPath("/diy/" + key);
                log.info("Likeness was above or equal to 75% at {}% so returning recipe named {}", likeness.get(key), key);
                return recipesRepository.findRecipesByName(key);
            } else {
                throw new RecipeNotFoundException(name);
            }
        }
        apiEventRepository.insertApiEvent(event);
        return recipe;
    }

}
