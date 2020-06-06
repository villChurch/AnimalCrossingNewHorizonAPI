package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Model.NhSeasonal;
import com.williamspires.acnhapi.Repositories.NhSeasonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NhSeasonalController {

    @Autowired
    NhSeasonalRepository nhSeasonalRepository;

    @GetMapping("/blossoms/nh/{shrub}")
    public List<NhSeasonal> getSeasonsShrubBloomsIn(@PathVariable String shrub) {
        return nhSeasonalRepository.findByBlossoms(shrub);
    }
}
