package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Exceptions.PersonalityNotFoundException;
import com.williamspires.acnhapi.Exceptions.SongNotFoundException;
import com.williamspires.acnhapi.Exceptions.SpeciesNotFoundException;
import com.williamspires.acnhapi.Exceptions.VillagerNotFoundException;
import com.williamspires.acnhapi.Model.Raymond;
import com.williamspires.acnhapi.Model.Villager;
import com.williamspires.acnhapi.Model.VillagerPercentage;
import com.williamspires.acnhapi.Model.VillagerPercentageNmt;
import com.williamspires.acnhapi.Repositories.RaymondRepository;
import com.williamspires.acnhapi.Repositories.VillagerRepository;
import org.springframework.web.bind.annotation.*;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

@RestController
public class VillagerController {

    private final DecimalFormat percentageRounding = new DecimalFormat("#.##");

    private final VillagerRepository villagerRepository;
    private final RaymondRepository raymondRepository;
    VillagerController(RaymondRepository raymondRepository, VillagerRepository villagerRepository){
        this.raymondRepository = raymondRepository;
        this.villagerRepository = villagerRepository;
    }

    @GetMapping("/villager/{name}")
    public Villager byName(@PathVariable String name) {
        Villager searchFor = villagerRepository.findVillagerByName(name);
        if (null == searchFor) {
            throw new VillagerNotFoundException(name);
        }
        return searchFor;
    }

    @GetMapping("/villager/Raymond/likes")
    public List<Raymond> villagerLikes() {
        return raymondRepository.findAll();
    }

    @GetMapping("/villager/personality/{personality}")
    public List<Villager> byPersonality(@PathVariable String personality) {
        List<Villager> villagers = villagerRepository.findVillagerByPersonality(personality);
        if(null == villagers || villagers.size() < 1){
            throw new PersonalityNotFoundException(personality);
        }
        return villagers;
    }

    @GetMapping("/villager/species/{species}")
    public List<Villager> bySpecies(@PathVariable String species) {
        List<Villager> villagers = villagerRepository.findVillagersBySpecies(species);
        if(null == villagers || villagers.size() < 1){
            throw new SpeciesNotFoundException(species);
        }
        return villagers;
    }

    @GetMapping("/villager/song/{song}")
    public List<Villager> byFavoriteSong(@PathVariable String song) {
        List<Villager> villagers = villagerRepository.findVillagersByFavoriteSong(song);
        if(null == villagers || villagers.size() < 1){
            throw new SongNotFoundException(song);
        }
        return villagers;
    }

    @PostMapping("/villager/odds")
    public String chanceToFindVillager(@RequestBody VillagerPercentage villagerPercentage) {
        Villager wanted = villagerRepository.findVillagerByName(villagerPercentage.getWants());
        if(null == wanted) {
            throw new VillagerNotFoundException(villagerPercentage.getWants());
        }
        Double percentage = percentageToFindVillager(wanted, villagerPercentage.getHave());
        percentageRounding.setRoundingMode(RoundingMode.HALF_UP);
        return "You have a " + percentageRounding.format(percentage) +"% change of getting " + wanted.getName();
    }

    @PostMapping("/villager/odds/nmt")
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
