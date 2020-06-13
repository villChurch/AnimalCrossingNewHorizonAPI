package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Exceptions.FossilNotFoundException;
import com.williamspires.acnhapi.Model.Fossil;
import com.williamspires.acnhapi.Repositories.FossilRepository;
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

@Tag(name = "Fossils", description = "Fossil information")
@RestController
public class FossilController {

    private final FossilRepository fossilRepository;
    FossilController(FossilRepository fossilRepository){
        this.fossilRepository = fossilRepository;
    }

    @Operation(summary = "Returns fossil information by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Fossil.class)))),
            @ApiResponse(responseCode = "404", description = "Fossil not found")
    })
    @GetMapping(value = "/fossils/{name}", produces = { "application/json" })
    public Fossil getFossilByName(@Parameter(description = "Fossil name") @PathVariable String name) {
        Fossil fossil = fossilRepository.findFossilByName(name);
        if(null == fossil){
            throw new FossilNotFoundException(name);
        }
        return fossil;
    }
}
