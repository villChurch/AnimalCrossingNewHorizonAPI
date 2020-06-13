package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Exceptions.RecipeNotFoundException;
import com.williamspires.acnhapi.Model.Recipes;
import com.williamspires.acnhapi.Repositories.RecipesRepository;
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

@Tag(name = "DIYs", description = "Information about DIYs")
@RestController
public class RecipeController {

    private final RecipesRepository recipesRepository;
    RecipeController(RecipesRepository recipesRepository){
        this.recipesRepository = recipesRepository;
    }

    @Operation(summary = "Get DIY information by name", description = "Returns DIY information by name of DIY")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Recipes.class)))),
            @ApiResponse(responseCode = "404", description = "DIY not found")
    })
    @GetMapping(value = "/diy/{name}", produces = { "application/json" })
    public Recipes getByName(@Parameter(description = "DIY name") @PathVariable String name) {
        Recipes recipe = recipesRepository.findRecipesByName(name);
        if(null == recipe){
            throw new RecipeNotFoundException(name);
        }
        return recipe;
    }

}
