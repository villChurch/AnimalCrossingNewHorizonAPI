package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Model.Furniture;
import com.williamspires.acnhapi.Repositories.FurnitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FurnitureController {

    @Autowired
    FurnitureRepository furnitureRepository;

    @GetMapping("/furniture/{name}")
    public Furniture getFurnitureByName(@PathVariable String name) {
        return furnitureRepository.getFurnitureByName(name);
    }
}
