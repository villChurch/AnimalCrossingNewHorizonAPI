package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Exceptions.ShrubNotFoundException;
import com.williamspires.acnhapi.Model.NhSeasonal;
import com.williamspires.acnhapi.Repositories.NhSeasonalRepository;
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

@Tag(name = "Northern Hemisphere blossoms", description = "Information on Northern Hemisphere blossoms")
@RestController
public class NhSeasonalController {

    private final NhSeasonalRepository nhSeasonalRepository;
    NhSeasonalController(NhSeasonalRepository nhSeasonalRepository){
        this.nhSeasonalRepository = nhSeasonalRepository;
    }

    @Operation(summary = "Get shrub blossom by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = NhSeasonal.class)))),
            @ApiResponse(responseCode = "404", description = "Shrub not found")
    })
    @GetMapping(value = "/blossoms/nh/{shrub}", produces = { "application/json" })
    public List<NhSeasonal> getSeasonsShrubBloomsIn(@Parameter(description = "Shrub name")
                                                        @PathVariable String shrub) {
        List<NhSeasonal> shrubs = nhSeasonalRepository.findByBlossoms(shrub);
        if(null == shrubs || shrubs.size() < 1){
            throw new ShrubNotFoundException(shrub);
        }
        return shrubs;
    }
}
