package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Model.Fish;
import com.williamspires.acnhapi.Repositories.FishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FishController {

    @Autowired
    FishRepository fishRepository;

    @GetMapping("/fish/{name}")
    public Fish getFishByName(@PathVariable String name) {
        return fishRepository.findFishByName(name);
    }

    @GetMapping("/fish/available/January")
    public List<Fish> getFishByMonth() {
        return fishRepository.fishAvailableInJanuary();
    }

    @GetMapping("/fish/available/February")
    public List<Fish> getFishInFeb() {
        return fishRepository.fishAvailableInFeb();
    }

    @GetMapping("/fish/available/March")
    public List<Fish> getFishInMarch() {
        return fishRepository.fishAvailableInMarch();
    }

    @GetMapping("/fish/available/April")
    public List<Fish> getFishInApril() {
        return fishRepository.fishAvailableInApril();
    }

    @GetMapping("/fish/available/May")
    public List<Fish> getFishInMay() {
        return fishRepository.fishAvailableInMay();
    }

    @GetMapping("/fish/available/June")
    public List<Fish> getFishInJune() {
        return fishRepository.fishAvailableInJune();
    }

    @GetMapping("/fish/available/July")
    public List<Fish> getFishInJuly() {
        return fishRepository.fishAvailableInJuly();
    }

    @GetMapping("/fish/available/August")
    public List<Fish> getFishInAugust() {
        return fishRepository.fishAvailableInAugust();
    }

    @GetMapping("/fish/available/September")
    public List<Fish> getFishInSeptember() {
        return fishRepository.fishAvailableInSeptember();
    }

    @GetMapping("/fish/available/October")
    public List<Fish> getFishInOctober() {
        return fishRepository.fishAvailableInOctober();
    }

    @GetMapping("/fish/available/November")
    public List<Fish> getFishInNovember() {
        return fishRepository.fishAvailableInNovember();
    }

    @GetMapping("/fish/available/December")
    public List<Fish> getFishInDecember() {
        return fishRepository.fishAvailableInDecember();
    }
}
