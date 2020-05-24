package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Model.Construction;
import com.williamspires.acnhapi.Repositories.ConstructionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConstructionController {

    @Autowired
    ConstructionRepository constructionRepository;

    @GetMapping("/construction/{name}")
    public Construction getConstructionByName(@PathVariable String name) {
        return constructionRepository.findConstructionByName(name);
    }
}
