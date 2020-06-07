package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Exceptions.OutfitNotFoundException;
import com.williamspires.acnhapi.Model.Outfits;
import com.williamspires.acnhapi.Repositories.OutfitRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OutfitController {

    private final OutfitRepository outfitRepository;
    OutfitController(OutfitRepository outfitRepository){
        this.outfitRepository = outfitRepository;
    }

    @GetMapping("/outfits/{name}")
    public List<Outfits> getOutfitsByName(@PathVariable String name) {
        List<Outfits> outfits = outfitRepository.findOutfitsByName(name);
        if(null == outfits || outfits.size() < 1){
            throw new OutfitNotFoundException(name);
        }
        return outfits;
    }
}
