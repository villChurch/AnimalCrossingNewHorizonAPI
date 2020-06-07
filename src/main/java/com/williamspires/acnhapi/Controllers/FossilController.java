package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Exceptions.FossilNotFoundException;
import com.williamspires.acnhapi.Model.Fossil;
import com.williamspires.acnhapi.Repositories.FossilRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FossilController {

    private final FossilRepository fossilRepository;
    FossilController(FossilRepository fossilRepository){
        this.fossilRepository = fossilRepository;
    }

    @GetMapping("/fossils/{name}")
    public Fossil getFossilByName(@PathVariable String name) {
        Fossil fossil = fossilRepository.findFossilByName(name);
        if(null == fossil){
            throw new FossilNotFoundException(name);
        }
        return fossil;
    }
}
