package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Exceptions.ShrubNotFoundException;
import com.williamspires.acnhapi.Model.ShSeasonal;
import com.williamspires.acnhapi.Repositories.ShSeasonalRepository;
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

@Tag(name = "Southern Hemisphere blossoms", description = "Information on Southern Hemisphere blossoms")
@RestController
public class ShSeasonalController {

    private final ShSeasonalRepository shSeasonalRepository;
    ShSeasonalController(ShSeasonalRepository shSeasonalRepository){
        this.shSeasonalRepository = shSeasonalRepository;
    }

    @Operation(summary = "Get shrub blossoms by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = ShSeasonal.class)))),
            @ApiResponse(responseCode = "404", description = "Shrub not found")
    })
    @GetMapping(value = "/blossoms/sh/{shrub}", produces = { "application/json" })
    public List<ShSeasonal> getShrubBlossomSeasons(@Parameter(description = "Shrub name")
                                                       @PathVariable String shrub) {
        List<ShSeasonal> shrubs = shSeasonalRepository.findByBlossoms(shrub);
        if(null == shrubs || shrubs.size() < 1){
            throw new ShrubNotFoundException(shrub);
        }
        return shrubs;
    }
}
