package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Exceptions.FurnitureNotFoundException;
import com.williamspires.acnhapi.Model.Furniture;
import com.williamspires.acnhapi.Repositories.FurnitureRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FurnitureController {

    private final FurnitureRepository furnitureRepository;
    FurnitureController(FurnitureRepository furnitureRepository){
        this.furnitureRepository = furnitureRepository;
    }

    @GetMapping("/furniture/{name}")
    public Furniture getFurnitureByName(@PathVariable String name) {
        Furniture furniture = furnitureRepository.getFurnitureByName(name);
        if(null == furniture){
            throw new FurnitureNotFoundException(name);
        }
        return furniture;
    }
}
