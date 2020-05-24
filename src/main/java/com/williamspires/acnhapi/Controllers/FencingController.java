package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Model.Fencing;
import com.williamspires.acnhapi.Repositories.FencingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FencingController {

    @Autowired
    FencingRepository fencingRepository;

    @GetMapping("/fencing/{name}")
    public Fencing getFenceByName(@PathVariable String name) {
        return  fencingRepository.findFencingByName(name);
    }
}
