package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Exceptions.ConstructionNotFoundException;
import com.williamspires.acnhapi.Model.Construction;
import com.williamspires.acnhapi.Repositories.ConstructionRepository;
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

@Tag(name = "Construction Items", description = "Information on Construction items, such as bridges etc")
@RestController
public class ConstructionController {

    private final ConstructionRepository constructionRepository;
    ConstructionController(ConstructionRepository constructionRepository){
        this.constructionRepository = constructionRepository;
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
        Construction construction = constructionRepository.findConstructionByName(name);
        if(null == construction){
            throw new ConstructionNotFoundException(name);
        }
        return construction;
    }
}
