package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Exceptions.FurnitureNotFoundException;
import com.williamspires.acnhapi.Model.Furniture;
import com.williamspires.acnhapi.Repositories.FurnitureRepository;
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

@Tag(name = "Furniture", description = "Furniture information")
@RestController
public class FurnitureController {

    private final FurnitureRepository furnitureRepository;
    FurnitureController(FurnitureRepository furnitureRepository){
        this.furnitureRepository = furnitureRepository;
    }

    @Operation(summary = "Get furniture by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Furniture.class)))),
            @ApiResponse(responseCode = "404", description = "Furniture not found")
    })
    @GetMapping(value = "/furniture/{name}", produces = { "application/json" })
    public Furniture getFurnitureByName(@Parameter(description = "Furniture name") @PathVariable String name) {
        Furniture furniture = furnitureRepository.getFurnitureByName(name);
        if(null == furniture){
            throw new FurnitureNotFoundException(name);
        }
        return furniture;
    }
}
