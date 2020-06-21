package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Model.ApiEvent;
import com.williamspires.acnhapi.Model.InsectPuns;
import com.williamspires.acnhapi.Repositories.ApiEventRepository;
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
import java.util.concurrent.ThreadLocalRandom;

@Tag(name = "Insect Puns", description = "Returns insect puns")
@RestController
public class InsectPunController {

    private final InsectPunRepository insectPunRepository;
    private final ApiEventRepository apiEventRepository;
    InsectPunController(InsectPunRepository insectPunRepository, ApiEventRepository apiEventRepository){
        this.insectPunRepository = insectPunRepository;
        this.apiEventRepository = apiEventRepository;
    }

    @Operation(summary = "Returns a random insect pun")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = InsectPuns.class))))
    })
    @GetMapping(value = "/puns/insect", produces = { "application/json" })
    public InsectPuns getRandomInsectPun() {
        ApiEvent event = new ApiEvent();
        event.setPath("/puns/insect");
        apiEventRepository.insertApiEvent(event);
        List<InsectPuns> allPuns = insectPunRepository.getAllInsectPuns();
        int random = ThreadLocalRandom.current().nextInt(0, (allPuns.size()));
        allPuns.get(random).setText(allPuns.get(random).getText().replaceAll("\\u000e", " "));
        return allPuns.get(random);
    }
}
