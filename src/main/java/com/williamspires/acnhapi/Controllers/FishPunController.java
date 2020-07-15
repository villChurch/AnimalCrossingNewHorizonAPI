package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Model.ApiEvent;
import com.williamspires.acnhapi.Model.FishPuns;
import com.williamspires.acnhapi.Repositories.ApiEventRepository;
import com.williamspires.acnhapi.Repositories.FishPunRepository;
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

@Tag(name = "Fish puns", description = "Returns Fish puns")
@RestController
public class FishPunController {

    private final FishPunRepository fishPunRepository;
    private final ApiEventRepository apiEventRepository;
    FishPunController(FishPunRepository fishPunRepository, ApiEventRepository apiEventRepository){
        this.fishPunRepository = fishPunRepository;
        this.apiEventRepository = apiEventRepository;
    }

    @Operation(summary = "Returns a random fish pun")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = FishPuns.class))))
    })
    @GetMapping(value = "/puns/fish", produces = { "application/json" })
    public FishPuns getRandomFishPun() {
        List<FishPuns> allPuns = fishPunRepository.getAllFishPuns();
        int randomNumber = ThreadLocalRandom.current().nextInt(0, (allPuns.size()));
        allPuns.get(randomNumber).setText(allPuns.get(randomNumber).getText().replaceAll("\\u000e", " "));
        ApiEvent event = new ApiEvent();
        event.setPath("/puns/fish");
        apiEventRepository.insertApiEvent(event);
        return allPuns.get(randomNumber);
    }
}
