package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Model.RedItem;
import com.williamspires.acnhapi.Repositories.RedItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedController {

    @Autowired
    RedItemRepository redItemRepository;

    @GetMapping("/red/{name}")
    public RedItem getRedItemByName(@PathVariable String name) {
        return redItemRepository.findItemByName(name);
    }
}
