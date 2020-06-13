package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Model.InsectPuns;
import com.williamspires.acnhapi.Repositories.InsectPunRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Insect Puns", description = "Returns insect puns")
@RestController
public class InsectPunController {

    private final InsectPunRepository insectPunRepository;
    InsectPunController(InsectPunRepository insectPunRepository){
        this.insectPunRepository = insectPunRepository;
    }

    @Operation(summary = "Returns a random insect pun")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = InsectPuns.class))))
    })
    @GetMapping(value = "/puns/insect", produces = { "application/json" })
    public InsectPuns getRandomInsectPun() {
        List<InsectPuns> allPuns = insectPunRepository.getAllInsectPuns();
        int randomNumber = (int) (Math.random() * (allPuns.size() + 1));
        System.out.println(randomNumber);
        allPuns.get(randomNumber).setText(allPuns.get(randomNumber).getText().replaceAll("\\u000e", " "));
        return allPuns.get(randomNumber);
    }
}
