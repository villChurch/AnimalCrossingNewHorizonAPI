package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Model.ShSeasonal;
import com.williamspires.acnhapi.Repositories.ShSeasonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShSeasonalController {

    @Autowired
    ShSeasonalRepository shSeasonalRepository;

    @GetMapping("/blossoms/sh/{shrub}")
    public List<ShSeasonal> getShrubBlossomSeasons(@PathVariable String shrub) {
        return shSeasonalRepository.findByBlossoms(shrub);
    }
}
