package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Exceptions.OutfitNotFoundException;
import com.williamspires.acnhapi.Model.Outfits;
import com.williamspires.acnhapi.Repositories.OutfitRepository;
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

@Tag(name = "Outfits", description = "Information on outfits")
@RestController
public class OutfitController {

    private final OutfitRepository outfitRepository;
    OutfitController(OutfitRepository outfitRepository){
        this.outfitRepository = outfitRepository;
    }

    @Operation(summary = "Get outfit by name", description = "Returns outfit information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Outfits.class)))),
            @ApiResponse(responseCode = "404", description = "Outfit not found")
    })
    @GetMapping(value = "/outfits/{name}", produces = { "application/json" })
    public List<Outfits> getOutfitsByName(@Parameter(description = "Outfit name") @PathVariable String name) {
        List<Outfits> outfits = outfitRepository.findOutfitsByName(name);
        if(null == outfits || outfits.size() < 1){
            throw new OutfitNotFoundException(name);
        }
        return outfits;
    }
}
