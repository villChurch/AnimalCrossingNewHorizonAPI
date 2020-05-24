package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Model.Insect;
import com.williamspires.acnhapi.Repositories.InsectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InsectController {

    @Autowired
    InsectRepository insectRepository;

    @GetMapping("/insect/{name}")
    public Insect getInsectByName(@PathVariable String name) {
        return insectRepository.findInsectByName(name);
    }

    @GetMapping("/insect/available/January")
    public List<Insect> getInsectByMonth() {
        return insectRepository.insectsAvailableInJanuary();
    }

    @GetMapping("/insect/available/February")
    public List<Insect> getInsectInFeb() {
        return insectRepository.insectsAvailableInFebruary();
    }

    @GetMapping("/insect/available/March")
    public List<Insect> getInsectInMarch() {
        return insectRepository.insectsAvailableInMarch();
    }

    @GetMapping("/insect/available/April")
    public List<Insect> getInsectInApril() {
        return insectRepository.insectsAvailableInApril();
    }

    @GetMapping("/insect/available/May")
    public List<Insect> getInsectInMay() {
        return insectRepository.insectsAvailableInMay();
    }

    @GetMapping("/insect/available/June")
    public List<Insect> getInsectInJune() {
        return insectRepository.insectsAvailableInJune();
    }

    @GetMapping("/insect/available/July")
    public List<Insect> getInsectInJuly() {
        return insectRepository.insectsAvailableInJuly();
    }

    @GetMapping("/insect/available/August")
    public List<Insect> getInsectInAugust() {
        return insectRepository.insectsAvailableInAugust();
    }

    @GetMapping("/insect/available/September")
    public List<Insect> getInsectInSeptember() {
        return insectRepository.insectsAvailableInSeptember();
    }

    @GetMapping("/insect/available/October")
    public List<Insect> getInsectInOctober() {
        return insectRepository.insectsAvailableInOctober();
    }

    @GetMapping("/insect/available/November")
    public List<Insect> getInsectInNovember() {
        return insectRepository.insectsAvailableInNovember();
    }

    @GetMapping("/insect/available/December")
    public List<Insect> getInsectInDecember() {
        return insectRepository.insectsAvailableInDecember();
    }
}
