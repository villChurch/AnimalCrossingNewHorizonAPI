package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Exceptions.RedItemNotFoundException;
import com.williamspires.acnhapi.Model.RedItem;
import com.williamspires.acnhapi.Repositories.RedItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedController {

    private final RedItemRepository redItemRepository;
    RedController(RedItemRepository redItemRepository){
        this.redItemRepository = redItemRepository;
    }

    @GetMapping("/red/{name}")
    public RedItem getRedItemByName(@PathVariable String name) {
        RedItem redItem = redItemRepository.findItemByName(name);
        if(null == redItem){
            throw new RedItemNotFoundException(name);
        }
        return redItem;
    }
}
