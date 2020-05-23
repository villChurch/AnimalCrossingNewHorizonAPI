package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Model.Villager;
import com.williamspires.acnhapi.Repositories.VillagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VillagerController {

    @Autowired
    VillagerRepository villagerRepository;

    @GetMapping("/villager/{name}")
    public Villager byName(@PathVariable String name) {
        return villagerRepository.findVillagerByName(name);
    }
}
