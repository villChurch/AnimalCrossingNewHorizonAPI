package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Exceptions.ShrubNotFoundException;
import com.williamspires.acnhapi.Model.ShSeasonal;
import com.williamspires.acnhapi.Repositories.ShSeasonalRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShSeasonalController {

    private final ShSeasonalRepository shSeasonalRepository;
    ShSeasonalController(ShSeasonalRepository shSeasonalRepository){
        this.shSeasonalRepository = shSeasonalRepository;
    }

    @GetMapping("/blossoms/sh/{shrub}")
    public List<ShSeasonal> getShrubBlossomSeasons(@PathVariable String shrub) {
        List<ShSeasonal> shrubs = shSeasonalRepository.findByBlossoms(shrub);
        if(null == shrubs || shrubs.size() < 1){
            throw new ShrubNotFoundException(shrub);
        }
        return shrubs;
    }
}
