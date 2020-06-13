package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Exceptions.PersonalityNotFoundException;
import com.williamspires.acnhapi.Exceptions.SongNotFoundException;
import com.williamspires.acnhapi.Exceptions.SpeciesNotFoundException;
import com.williamspires.acnhapi.Exceptions.VillagerNotFoundException;
import com.williamspires.acnhapi.Model.Villager;
import com.williamspires.acnhapi.Model.VillagerPercentage;
import com.williamspires.acnhapi.Model.VillagerPercentageNmt;
import com.williamspires.acnhapi.Repositories.VillagerRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

@Tag(name = "Villagers", description = "Information about villagers")
@RestController
public class VillagerController {

    private final DecimalFormat percentageRounding = new DecimalFormat("#.##");

    private final VillagerRepository villagerRepository;
    VillagerController(VillagerRepository villagerRepository){
        this.villagerRepository = villagerRepository;
    }

    @Operation(summary = "Get villager by name", description = "Information about chosen villager")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Villager.class)))),
            @ApiResponse(responseCode = "404", description = "Villager not found")
    })
    @GetMapping(value = "/villager/{name}", produces = { "application/json" })
    public Villager byName(@Parameter(description = "Villager name") @PathVariable String name) {
        Villager searchFor = villagerRepository.findVillagerByName(name);
        if (null == searchFor) {
            throw new VillagerNotFoundException(name);
        }
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
