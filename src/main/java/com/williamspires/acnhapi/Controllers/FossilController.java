package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Model.Fossil;
import com.williamspires.acnhapi.Repositories.FossilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FossilController {

    @Autowired
    FossilRepository fossilRepository;

    @GetMapping("/fossils/{name}")
    public Fossil getFossilByName(@PathVariable String name) {
        return fossilRepository.findFossilByName(name);
    }
}
