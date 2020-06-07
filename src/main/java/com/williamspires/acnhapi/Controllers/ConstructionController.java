package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Exceptions.ConstructionNotFoundException;
import com.williamspires.acnhapi.Model.Construction;
import com.williamspires.acnhapi.Repositories.ConstructionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConstructionController {

    private final ConstructionRepository constructionRepository;
    ConstructionController(ConstructionRepository constructionRepository){
        this.constructionRepository = constructionRepository;
    }

    @GetMapping("/construction/{name}")
    public Construction getConstructionByName(@PathVariable String name) {
        Construction construction = constructionRepository.findConstructionByName(name);
        if(null == construction){
            throw new ConstructionNotFoundException(name);
        }
        return construction;
    }
}
