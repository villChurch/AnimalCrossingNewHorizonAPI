package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Exceptions.ShrubNotFoundException;
import com.williamspires.acnhapi.Model.NhSeasonal;
import com.williamspires.acnhapi.Repositories.NhSeasonalRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NhSeasonalController {

    private final NhSeasonalRepository nhSeasonalRepository;
    NhSeasonalController(NhSeasonalRepository nhSeasonalRepository){
        this.nhSeasonalRepository = nhSeasonalRepository;
    }

    @GetMapping("/blossoms/nh/{shrub}")
    public List<NhSeasonal> getSeasonsShrubBloomsIn(@PathVariable String shrub) {
        List<NhSeasonal> shrubs = nhSeasonalRepository.findByBlossoms(shrub);
        if(null == shrubs || shrubs.size() < 1){
            throw new ShrubNotFoundException(shrub);
        }
        return shrubs;
    }
}
