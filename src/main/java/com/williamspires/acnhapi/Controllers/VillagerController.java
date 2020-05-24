package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Model.Raymond;
import com.williamspires.acnhapi.Model.Villager;
import com.williamspires.acnhapi.Repositories.RaymondRepository;
import com.williamspires.acnhapi.Repositories.VillagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VillagerController {

    @Autowired
    VillagerRepository villagerRepository;
    @Autowired
    RaymondRepository raymondRepository;

    @GetMapping("/villager/{name}")
    public Villager byName(@PathVariable String name) {
        return villagerRepository.findVillagerByName(name);
    }

    @GetMapping("/villager/Raymond/likes")
    public List<Raymond> villagerLikes() {
        return raymondRepository.findAll();
    }

    @GetMapping("/villager/personality/{personality}")
    public List<Villager> byPersonality(@PathVariable String personality) {
        return villagerRepository.findVillagerByPersonality(personality);
    }

    @GetMapping("/villager/species/{species}")
    public List<Villager> bySpecies(@PathVariable String species) {
        return villagerRepository.findVillagersBySpecies(species);
    }

    @GetMapping("/villager/song/{song}")
    public List<Villager> byFavoriteSong(@PathVariable String song) {
        return villagerRepository.findVillagersByFavoriteSong(song);
    }
}
