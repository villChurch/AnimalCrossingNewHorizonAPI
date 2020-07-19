package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Exceptions.PersonalityNotFoundException;
import com.williamspires.acnhapi.Exceptions.SongNotFoundException;
import com.williamspires.acnhapi.Exceptions.SpeciesNotFoundException;
import com.williamspires.acnhapi.Exceptions.VillagerNotFoundException;
import com.williamspires.acnhapi.Model.ApiEvent;
import com.williamspires.acnhapi.Model.Villager;
import com.williamspires.acnhapi.Model.VillagerPercentage;
import com.williamspires.acnhapi.Model.VillagerPercentageNmt;
import com.williamspires.acnhapi.Repositories.ApiEventRepository;
import com.williamspires.acnhapi.Repositories.VillagerRepository;
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
import org.springframework.web.bind.annotation.*;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

@Slf4j
@Tag(name = "Villagers", description = "Information about villagers")
@RestController
public class VillagerController {

    private final DecimalFormat percentageRounding = new DecimalFormat("#.##");

    private final VillagerRepository villagerRepository;
    private final ApiEventRepository apiEventRepository;
    VillagerController(VillagerRepository villagerRepository, ApiEventRepository apiEventRepository){
        this.villagerRepository = villagerRepository;
        this.apiEventRepository = apiEventRepository;
    }

    @Operation(summary = "Get villager by name", description = "Information about chosen villager")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Villager.class)))),
            @ApiResponse(responseCode = "404", description = "Villager not found")
    })
    @GetMapping(value = "/villager/{name}", produces = { "application/json" })
    public Villager byName(@Parameter(description = "Villager name") @PathVariable String name) {
        ApiEvent event = new ApiEvent();
        event.setPath("/villager/" + name);
        Villager searchFor = villagerRepository.findVillagerByName(name);
        if (null == searchFor) {
            List<Villager> villagers = villagerRepository.getAllVillagers();
            Map<String, Integer> likeness = new HashMap<>();
            villagers.forEach(villager -> likeness.put(villager.getName(),
                    LevenshteinDistance.percentage(name.toLowerCase(), villager.getName().toLowerCase())));
            String key =
                    Collections.max(likeness.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
            log.warn("Villager was not found called {} but one was found called {} with a {}% match to search term",
                    name, key, likeness.get(key));
            if (likeness.get(key) >= 75) {
                event.setPath("/villager/" + key);
                log.info("Likeness was above or equal to 75% at {}% so returning villager called {}", likeness.get(key), key);
                return villagerRepository.findVillagerByName(key);
            } else {
                throw new VillagerNotFoundException(name);
            }
        }
        apiEventRepository.insertApiEvent(event);
        return searchFor;
    }

    @Operation(summary = "Get villagers by personality", description = "List of villagers by personality")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Villager.class)))),
            @ApiResponse(responseCode = "404", description = "No villagers with this personality")
    })
    @GetMapping(value = "/villager/personality/{personality}", produces = { "application/json" })
    public List<Villager> byPersonality(@Parameter(description = "Villager personality")
                                            @PathVariable String personality) {
        ApiEvent event = new ApiEvent();
        event.setPath("/villager/personality/" + personality);
        apiEventRepository.insertApiEvent(event);
        List<Villager> villagers = villagerRepository.findVillagerByPersonality(personality);
        if(null == villagers || villagers.size() < 1){
            throw new PersonalityNotFoundException(personality);
        }
        return villagers;
    }

    @Operation(summary = "Get villagers by species", description = "List of villagers by species")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Villager.class)))),
            @ApiResponse(responseCode = "404", description = "No villagers with this species")
    })
    @GetMapping(value = "/villager/species/{species}", produces = { "application/json" })
    public List<Villager> bySpecies(@Parameter(description = "Villager species") @PathVariable String species) {
        ApiEvent event = new ApiEvent();
        event.setPath("/villager/species/" + species);
        apiEventRepository.insertApiEvent(event);
        List<Villager> villagers = villagerRepository.findVillagersBySpecies(species);
        if(null == villagers || villagers.size() < 1){
            throw new SpeciesNotFoundException(species);
        }
        return villagers;
    }

    @Operation(summary = "Get villagers by favourite song", description = "List of villagers by favourite song")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Villager.class)))),
            @ApiResponse(responseCode = "404", description = "No villagers with this favourite song")
    })
    @GetMapping(value = "/villager/song/{song}", produces = { "application/json" })
    public List<Villager> byFavoriteSong(@Parameter(description = "Favourite song") @PathVariable String song) {
        ApiEvent event = new ApiEvent();
        event.setPath("/villager/song/" + song);
        apiEventRepository.insertApiEvent(event);
        List<Villager> villagers = villagerRepository.findVillagersByFavoriteSong(song);
        if(null == villagers || villagers.size() < 1){
            throw new SongNotFoundException(song);
        }
        return villagers;
    }

    @Operation(summary = "Get the odds of finding a specific villager",
            description = "Returns the odds of finding a specific villager")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Could not find villager")
    })
    @PostMapping(value = "/villager/odds", consumes = { "application/json" },
            produces = { "application/text" })
    public String chanceToFindVillager(@RequestBody VillagerPercentage villagerPercentage) {
        ApiEvent event = new ApiEvent();
        event.setPath("/villager/odds");
        apiEventRepository.insertApiEvent(event);
        Villager wanted = villagerRepository.findVillagerByName(villagerPercentage.getWants());
        if(null == wanted) {
            throw new VillagerNotFoundException(villagerPercentage.getWants());
        }
        Double percentage = percentageToFindVillager(wanted, villagerPercentage.getHave());
        percentageRounding.setRoundingMode(RoundingMode.HALF_UP);
        return "You have a " + percentageRounding.format(percentage) +"% change of getting " + wanted.getName();
    }

    @Operation(summary = "Get the odds of finding a specific villager with a set number of NMTs",
    description = "Returns the odds of finding a specific villager using a set number of NMTs")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Could not find villager")
    })
    @PostMapping(value = "/villager/odds/nmt", consumes = { "application/json" },
            produces = { "application/text" })
    public String chanceToFindVillagerWithNmts(@RequestBody VillagerPercentageNmt villagerPercentageNmt) {
        ApiEvent event = new ApiEvent();
        event.setPath("/villager/odds/nmt");
        apiEventRepository.insertApiEvent(event);
        Villager wanted = villagerRepository.findVillagerByName(villagerPercentageNmt.getWants());
        if(null == wanted) {
            throw new VillagerNotFoundException(villagerPercentageNmt.getWants());
        }
        percentageRounding.setRoundingMode(RoundingMode.HALF_UP);
        Double percentage = percentageToFindVillager(wanted, villagerPercentageNmt.getHave());
        double nmtPercentage = (1 - Math.pow((1 - (percentage/100)), villagerPercentageNmt.getNmts())) * 100;

        return "With " + villagerPercentageNmt.getNmts() + " nmts you have a "
                + percentageRounding.format(nmtPercentage) + " % chance of finding " + wanted.getName() + ".";
    }

    private Double percentageToFindVillager(Villager wanted, List<String> have) {
        int wantedSpeciesAmount = villagerRepository.findVillagersBySpecies(wanted.getSpecies()).size();
        int ownedSpecies = (int) have.stream()
                .map(villagerRepository::findVillagerByName)
                .filter(current -> current.getSpecies().equals(wanted.getSpecies()))
                .count();
        return (((double)1/35) * ((double)1/(wantedSpeciesAmount - ownedSpecies))) * 100;
    }
}
