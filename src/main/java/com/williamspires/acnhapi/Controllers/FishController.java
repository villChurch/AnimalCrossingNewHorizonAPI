package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Exceptions.FishNotFoundException;
import com.williamspires.acnhapi.Model.ApiEvent;
import com.williamspires.acnhapi.Model.Fish;
import com.williamspires.acnhapi.Repositories.ApiEventRepository;
import com.williamspires.acnhapi.Repositories.FishRepository;
import com.williamspires.acnhapi.Utils.LevenshteinDistance;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Slf4j
@Tag(name = "Fish", description = "Information about fish")
@RestController
public class FishController {

    private final FishRepository fishRepository;
    private final ApiEventRepository apiEventRepository;
    FishController(FishRepository fishRepository, ApiEventRepository apiEventRepository){
        this.fishRepository = fishRepository;
        this.apiEventRepository = apiEventRepository;
    }

    @Operation(summary = "Get fish by name", description = "Returns information about a particular fish")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Fish.class)))),
            @ApiResponse(responseCode = "404", description = "Fish not found")
    })
    @GetMapping("/fish/{name}")
    public Fish getFishByName(@Parameter(description = "Fish name") @PathVariable String name) {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/" + name);
        Fish fish = fishRepository.findFishByName(name);
        if(null == fish){
            List<Fish> fishes = fishRepository.getAllFish();
            Map<String, Integer> likeness = new HashMap<>();
            fishes.forEach(fishy -> likeness.put(fishy.getName(),
                    LevenshteinDistance.percentage(name.toLowerCase(), fishy.getName().toLowerCase())));
            String key =
                    Collections.max(likeness.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
            log.warn("Fish was not found called {} but one was found called {} with a {}% match to search term",
                    name, key, likeness.get(key));
            if (likeness.get(key) >= 75) {
                event.setPath("/fish/" + key);
                log.info("Likeness was above or equal to 75% at {}% so returning fish called {}", likeness.get(key), key);
                return fishRepository.findFishByName(key);
            } else {
                throw new FishNotFoundException(name);
            }
        }
        apiEventRepository.insertApiEvent(event);
        return fish;
    }

    @Operation(summary = "Get fish available in January", description = "Returns a list of fish available in January")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Fish.class))))
    })
    @GetMapping("/fish/available/January")
    public List<Fish> getFishByMonth() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/available/January");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishAvailableInJanuary();
    }

    @Operation(summary = "Get fish available in February",
            description = "Returns a list of fish available in February")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful opeartion",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Fish.class))))
    })
    @GetMapping("/fish/available/February")
    public List<Fish> getFishInFeb() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/available/February");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishAvailableInFeb();
    }

    @Operation(summary = "Get fish available in March", description = "Returns a list of fish available in March")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Fish.class))))
    })
    @GetMapping("/fish/available/March")
    public List<Fish> getFishInMarch() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/available/March");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishAvailableInMarch();
    }

    @Operation(summary = "Get fish available in April", description = "Returns a list of fish available in April")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful opearation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Fish.class))))
    })
    @GetMapping("/fish/available/April")
    public List<Fish> getFishInApril() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/available/April");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishAvailableInApril();
    }

    @Operation(summary = "Get fish available in May", description = "Returns a list of fish available in May")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Fish.class))))
    })
    @GetMapping("/fish/available/May")
    public List<Fish> getFishInMay() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/available/May");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishAvailableInMay();
    }

    @Operation(summary = "Get fish available in June", description = "Returns a list of fish available in June")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Fish.class))))
    })
    @GetMapping("/fish/available/June")
    public List<Fish> getFishInJune() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/available/June");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishAvailableInJune();
    }

    @Operation(summary = "Get fish available in July", description = "Returns a list of fish in July")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Fish.class))))
    })
    @GetMapping("/fish/available/July")
    public List<Fish> getFishInJuly() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/available/July");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishAvailableInJuly();
    }

    @Operation(summary = "Get fish available in August", description = "Returns a list of fish in August")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Fish.class))))
    })
    @GetMapping("/fish/available/August")
    public List<Fish> getFishInAugust() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/available/August");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishAvailableInAugust();
    }

    @Operation(summary = "Get fish available in September", description = "Returns a list of fish in September")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Fish.class))))
    })
    @GetMapping("/fish/available/September")
    public List<Fish> getFishInSeptember() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/available/September");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishAvailableInSeptember();
    }

    @Operation(summary = "Get fish available in October", description = "Returns a list of fish in October")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Fish.class))))
    })
    @GetMapping("/fish/available/October")
    public List<Fish> getFishInOctober() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/available/October");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishAvailableInOctober();
    }

    @Operation(summary = "Get fish available in November", description = "Returns a list of fish in November")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Fish.class))))
    })
    @GetMapping("/fish/available/November")
    public List<Fish> getFishInNovember() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/available/November");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishAvailableInNovember();
    }

    @Operation(summary = "Get fish available in December", description = "Returns a list of fish in December")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Fish.class))))
    })
    @GetMapping("/fish/available/December")
    public List<Fish> getFishInDecember() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/available/December");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishAvailableInDecember();
    }

    @GetMapping("/fish/available/January/NH")
    public List<Fish> getFishsInJanuaryNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/available/January/NH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishAvailableInJanuaryNH();
    }

    @GetMapping("/fish/available/January/SH")
    public List<Fish> getFishesInJanuarySH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/available/January/SH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishAvailableInJanuarySH();
    }

    @GetMapping("/fish/available/February/NH")
    public List<Fish> getFishesInFebruaryNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/available/February/NH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishAvailableInFebruaryNH();
    }

    @GetMapping("/fish/available/February/SH")
    public List<Fish> getFishesInFebruarySH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/available/February/SH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishAvailableInFebruarySH();
    }

    @GetMapping("/fish/available/March/NH")
    public List<Fish> getFishesInMarchNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/available/March/NH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishAvailableInMarchNH();
    }

    @GetMapping("/fish/available/March/SH")
    public List<Fish> getFishesInMarchSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/available/March/SH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishAvailableInMarchSH();
    }

    @GetMapping("/fish/available/April/NH")
    public List<Fish> getFishesInAprilNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/available/April/NH");
        return fishRepository.fishAvailableInAprilNH();
    }

    @GetMapping("/fish/available/April/SH")
    public List<Fish> getFishesInAprilSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/available/April/SH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishAvailableInAprilSH();
    }

    @GetMapping("/fish/available/May/NH")
    public List<Fish> getFishesInMayNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/available/May/NH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishAvailableInMayNH();
    }

    @GetMapping("/fish/available/May/SH")
    public List<Fish> getFishesInMaySH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/available/May/SH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishAvailableInMaySH();
    }

    @GetMapping("/fish/available/June/NH")
    public List<Fish> getFishesInJuneNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/available/June/NH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishAvailableInJuneNH();
    }

    @GetMapping("/fish/available/June/SH")
    public List<Fish> getFishesInJuneSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/available/June/SH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishAvailableInJuneSH();
    }

    @GetMapping("/fish/available/July/NH")
    public List<Fish> getFishesInJulyNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/available/July/NH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishAvailableInJulyNH();
    }

    @GetMapping("/fish/available/July/SH")
    public List<Fish> getFishesInJulySH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/available/July/SH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishAvailableInJulySH();
    }

    @GetMapping("/fish/available/August/NH")
    public List<Fish> getFishesInAugustNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/available/August/NH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishAvailableInAugustNH();
    }

    @GetMapping("/fish/available/August/SH")
    public List<Fish> getFishesInAugustSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/available/August/SH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishAvailableInAugustSH();
    }

    @GetMapping("/fish/available/September/NH")
    public List<Fish> getFishesInSeptemberNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/available/September/NH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishAvailableInSeptemberNH();
    }

    @GetMapping("/fish/available/September/SH")
    public List<Fish> getFishesInSeptemberSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/available/September/SH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishAvailableInSeptemberSH();
    }

    @GetMapping("/fish/available/October/NH")
    public List<Fish> getFishesInOctoberNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/available/October/NH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishAvailabeInOctoberNH();
    }

    @GetMapping("/fish/available/October/SH")
    public List<Fish> getFishesInOctoberSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/available/October/SH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishAvailableInOctoberSH();
    }

    @GetMapping("/fish/available/November/NH")
    public List<Fish> getFishesInNovemberNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/available/November/NH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishAvailableInNovemberNH();
    }

    @GetMapping("/fish/available/November/SH")
    public List<Fish> getFishesInNovemberSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/available/November/SH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishAvailableInNovemberSH();
    }

    @GetMapping("/fish/available/December/NH")
    public List<Fish> getFishesInDecemberNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/available/December/NH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishAvailableInDecemberNH();
    }

    @GetMapping("/fish/available/December/SH")
    public List<Fish> getFishesInDecemberSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/available/December/SH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishAvailableInDecemberSH();
    }

    @GetMapping("/fish/leaving/January/NH")
    public List<Fish> getFishesLeavingAfterJanuaryNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/leaving/January/NH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishLeavingAfterJanuaryNH();
    }

    @GetMapping("/fish/leaving/January/SH")
    public List<Fish> getFishesLeavingAfterJanuarySH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/leaving/January/SH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishLeavingAfterJanuarySH();
    }

    @GetMapping("/fish/leaving/February/NH")
    public List<Fish> getFishesLeavingAfterFebruaryNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/leaving/February/NH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishLeavingAfterFebruaryNH();
    }

    @GetMapping("/fish/leaving/February/SH")
    public List<Fish> getFishesLeavingAfterFebruarySH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/leaving/February/SH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishLeavingAfterFebruarySH();
    }

    @GetMapping("/fish/leaving/March/NH")
    public List<Fish> getFishesLeavingAfterMarchNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/leaving/March/NH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishLeavingAfterMarchNH();
    }

    @GetMapping("/fish/leaving/March/SH")
    public List<Fish> getFishesLeavingAfterMarchSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/leaving/March/SH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishLeavingAfterMarchSH();
    }

    @GetMapping("/fish/leaving/April/NH")
    public List<Fish> getFishesLeavingAfterAprilNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/leaving/April/NH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishLeavingAfterAprilNH();
    }

    @GetMapping("/fish/leaving/April/SH")
    public List<Fish> getFishesLeavingAfterAprilSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/leaving/April/SH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishLeavingAfterAprilSH();
    }

    @GetMapping("/fish/leaving/May/NH")
    public List<Fish> getFishesLeavingAfterMayNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/leaving/May/NH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishLeavingAfterMayNH();
    }

    @GetMapping("/fish/leaving/May/SH")
    public List<Fish> getFishesLeavingAfterMaySH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/leaving/May/SH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishLeavingAfterMaySH();
    }

    @GetMapping("/fish/leaving/June/NH")
    public List<Fish> getFishesLeavingAfterJuneNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/leaving/June/NH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishLeavingAfterJuneNH();
    }

    @GetMapping("/fish/leaving/June/SH")
    public List<Fish> getFishesLeavingAfterJuneSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/leaving/June/SH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishLeavingAfterJuneSH();
    }

    @GetMapping("/fish/leaving/July/NH")
    public List<Fish> getFishesLeavingAfterJulyNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/leaving/July/NH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishLeavingAfterJulyNH();
    }

    @GetMapping("/fish/leaving/July/SH")
    public List<Fish> getFishesLeavingAfterJulySH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/leaving/July/SH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishLeavingAfterJulySH();
    }

    @GetMapping("/fish/leaving/August/NH")
    public List<Fish> getFishesLeavingAfterAugustNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/leaving/August/NH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishLeavingAfterAugustNH();
    }

    @GetMapping("/fish/leaving/August/SH")
    public List<Fish> getFishesLeavingAfterAugustSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/leaving/August/SH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishLeavingAfterAugustSH();
    }

    @GetMapping("/fish/leaving/September/NH")
    public List<Fish> getFishesLeavingAfterSeptemberNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/leaving/September/NH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishLeavingAfterSeptemberNH();
    }

    @GetMapping("/fish/leaving/September/SH")
    public List<Fish> getFishesLeavingAfterSeptemberSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/leaving/September/SH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishLeavingAfterSeptemberSH();
    }

    @GetMapping("/fish/leaving/October/NH")
    public List<Fish> getFishesLeavingAfterOctoberNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/leaving/October/NH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishLeavingAfterOctoberNH();
    }

    @GetMapping("/fish/leaving/October/SH")
    public List<Fish> getFishesLeavingAfterOctoberSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/leaving/October/SH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishLeavingAfterOctoberSH();
    }

    @GetMapping("/fish/leaving/November/NH")
    public List<Fish> getFishesLeavingAfterNovemberNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/leaving/November/NH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishLeavingAfterNovemberNH();
    }

    @GetMapping("/fish/leaving/November/SH")
    public List<Fish> getFishesLeavingAfterNovemberSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/leaving/November/SH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishLeavingAfterNovemberSH();
    }

    @GetMapping("/fish/leaving/December/NH")
    public List<Fish> getFishesLeavingAfterDecemberNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/leaving/December/NH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishLeavingAfterDecemberNH();
    }

    @GetMapping("/fish/leaving/December/SH")
    public List<Fish> getFishesLeavingAfterDecemberSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/leaving/December/SH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishLeavingAfterDecemberSH();
    }
    @GetMapping("/fish/arriving/January/NH")
    public List<Fish> getFishArrivingInJanuaryNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/arriving/January/NH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishArrivingInJanuaryNH();
    }

    @GetMapping("/fish/arriving/January/SH")
    public List<Fish> getFishArrivingInJanuarySH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/arriving/January/SH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishArrivingInJanuarySH();
    }

    @GetMapping("/fish/arriving/February/NH")
    public List<Fish> getFishArrivingInFebruaryNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/arriving/February/NH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishArrivingInFebruaryNH();
    }

    @GetMapping("/fish/arriving/February/SH")
    public List<Fish> getFishArrivingInFebruarySH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/arriving/February/SH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishArrivingInFebruarySH();
    }

    @GetMapping("/fish/arriving/March/NH")
    public List<Fish> getFishArrivingInMarchNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/arriving/March/NH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishArrivingInMarchNH();
    }

    @GetMapping("/fish/arriving/March/SH")
    public List<Fish> getFishArrivingInMarchSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/arriving/March/SH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishArrivingInMarchSH();
    }

    @GetMapping("/fish/arriving/April/NH")
    public List<Fish> getFishArrivingInAprilNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/arriving/April/NH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishArrivingInAprilNH();
    }

    @GetMapping("/fish/arriving/April/SH")
    public List<Fish> getFishArrivingInAprilSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/arriving/April/SH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishArrivingInAprilSH();
    }

    @GetMapping("/fish/arriving/May/NH")
    public List<Fish> getFishArrivingInMayNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/arriving/May/NH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishArrivingInMayNH();
    }

    @GetMapping("/fish/arriving/May/SH")
    public List<Fish> getFishArrivingInMaySH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/arriving/May/SH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishArrivingInMaySH();
    }

    @GetMapping("/fish/arriving/June/NH")
    public List<Fish> getFishArrivingInJuneNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/arriving/June/NH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishArrivingInJuneNH();
    }

    @GetMapping("/fish/arriving/June/SH")
    public List<Fish> getFishArrivingInJuneSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/arriving/June/SH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishArrivingInJuneSH();
    }

    @GetMapping("/fish/arriving/July/NH")
    public List<Fish> getFishArrivingInJulyNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/arriving/July/NH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishArrivingInJulyNH();
    }

    @GetMapping("/fish/arriving/July/SH")
    public List<Fish> getFishArrivingInJulySH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/arriving/July/SH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishArrivingInJulySH();
    }

    @GetMapping("/fish/arriving/August/NH")
    public List<Fish> getFishArrivingInAugustNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/arriving/August/NH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishArrivingInAugustNH();
    }

    @GetMapping("/fish/arriving/August/SH")
    public List<Fish> getFishArrivingInAugustSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/arriving/August/SH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishArrivingInAugustSH();
    }

    @GetMapping("/fish/arriving/September/NH")
    public List<Fish> getFishArrivingInSeptemberNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/arriving/September/NH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishArrivingInSeptemberNH();
    }

    @GetMapping("/fish/arriving/September/SH")
    public List<Fish> getFishArrivingInSeptemberSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/arriving/September/SH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishArrivingInSeptemberSH();
    }

    @GetMapping("/fish/arriving/October/NH")
    public List<Fish> getFishArrivingInOctoberNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/arriving/October/NH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishArrivingInOctoberNH();
    }

    @GetMapping("/fish/arriving/October/SH")
    public List<Fish> getFishArrivingInOctoberSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/arriving/October/SH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishArrivingInOctoberSH();
    }

    @GetMapping("/fish/arriving/November/NH")
    public List<Fish> getFishArrivingInNovemberNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/arriving/November/NH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishArrivingInNovemberNH();
    }

    @GetMapping("/fish/arriving/November/SH")
    public List<Fish> getFishArrivingInNovemberSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/arriving/November/SH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishArrivingInNovemberSH();
    }

    @GetMapping("/fish/arriving/December/NH")
    public List<Fish> getFishArrivingInDecemberNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/arriving/December/NH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishArrivingInDecemberNH();
    }

    @GetMapping("/fish/arriving/December/SH")
    public List<Fish> getFishArrivingInDecemberSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/fish/arriving/December/SH");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.fishArrivingInDecemberSH();
    }
}
