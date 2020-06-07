package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Model.Outfits;
import com.williamspires.acnhapi.Repositories.OutfitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OutfitController {

    @Autowired
    OutfitRepository outfitRepository;

    @GetMapping("/outfits/{name}")
    public List<Outfits> getOutfitsByName(@PathVariable String name) {
        return outfitRepository.findOutfitsByName(name);
    }
}
