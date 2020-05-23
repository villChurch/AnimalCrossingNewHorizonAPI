package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Model.Fish;
import com.williamspires.acnhapi.Repositories.FishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FishController {

    @Autowired
    FishRepository fishRepository;

    @GetMapping("/fish/{name}")
    public Fish getFishByName(@PathVariable String name) {
        return fishRepository.findFishByName(name);
    }

}
