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

    @GetMapping("/insect/available/January/NH")
    public List<Insect> getInsectsInJanuaryNH() {
        return insectRepository.insectsAvailableInJanuaryNH();
    }

    @GetMapping("/insect/available/January/SH")
    public List<Insect> getInsectsInJanuarySH() {
        return insectRepository.insectsAvailableInJanuarySH();
    }

    @GetMapping("/insect/available/February/NH")
    public List<Insect> getInsectsInFebruaryNH() {
        return insectRepository.insectsAvailableInFebruaryNH();
    }

    @GetMapping("/insect/available/February/SH")
    public List<Insect> getInsectsInFebruarySH() {
        return insectRepository.insectsAvailableInFebruarySH();
    }

    @GetMapping("/insect/available/March/NH")
    public List<Insect> getInsectsInMarchNH() {
        return insectRepository.insectsAvailableInMarchNH();
    }

    @GetMapping("/insect/available/March/SH")
    public List<Insect> getInsectsInMarchSH() {
        return insectRepository.insectsAvailableInMarchSH();
    }

    @GetMapping("/insect/available/April/NH")
    public List<Insect> getInsectsInAprilNH() {
        return insectRepository.insectsAvailableInAprilNH();
    }

    @GetMapping("/insect/available/April/SH")
    public List<Insect> getInsectsInAprilSH() {
        return insectRepository.insectsAvailableInAprilSH();
    }

    @GetMapping("/insect/available/May/NH")
    public List<Insect> getInsectsInMayNH() {
        return insectRepository.insectsAvailableInMayNH();
    }

    @GetMapping("/insect/available/May/SH")
    public List<Insect> getInsectsInMaySH() {
        return insectRepository.insectsAvailableInMaySH();
    }

    @GetMapping("/insect/available/June/NH")
    public List<Insect> getInsectsInJuneNH() {
        return insectRepository.insectsAvailableInJuneNH();
    }

    @GetMapping("/insect/available/June/SH")
    public List<Insect> getInsectsInJuneSH() {
        return insectRepository.insectsAvailableInJuneSH();
    }

    @GetMapping("/insect/available/July/NH")
    public List<Insect> getInsectsInJulyNH() {
        return insectRepository.insectsAvailableInJulyNH();
    }

    @GetMapping("/insect/available/July/SH")
    public List<Insect> getInsectsInJulySH() {
        return insectRepository.insectsAvailableInJulySH();
    }

    @GetMapping("/insect/available/August/NH")
    public List<Insect> getInsectsInAugustNH() {
        return insectRepository.insectsAvailableInAugustNH();
    }

    @GetMapping("/insect/available/August/SH")
    public List<Insect> getInsectsInAugustSH() {
        return insectRepository.insectsAvailableInAugustSH();
    }

    @GetMapping("/insect/available/September/NH")
    public List<Insect> getInsectsInSeptemberNH() {
        return insectRepository.insectsAvailableInSeptemberNH();
    }

    @GetMapping("/insect/available/September/SH")
    public List<Insect> getInsectsInSeptemberSH() {
        return insectRepository.insectsAvailableInSeptemberSH();
    }

    @GetMapping("/insect/available/October/NH")
    public List<Insect> getInsectsInOctoberNH() {
        return insectRepository.insectsAvailabeInOctoberNH();
    }

    @GetMapping("/insect/available/October/SH")
    public List<Insect> getInsectsInOctoberSH() {
        return insectRepository.insectsAvailableInOctoberSH();
    }

    @GetMapping("/insect/available/November/NH")
    public List<Insect> getInsectsInNovemberNH() {
        return insectRepository.insectsAvailableInNovemberNH();
    }

    @GetMapping("/insect/available/November/SH")
    public List<Insect> getInsectsInNovemberSH() {
        return insectRepository.insectsAvailableInNovemberSH();
    }

    @GetMapping("/insect/available/December/NH")
    public List<Insect> getInsectsInDecemberNH() {
        return insectRepository.insectsAvailableInDecemberNH();
    }

    @GetMapping("/insect/available/December/SH")
    public List<Insect> getInsectsInDecemberSH() {
        return insectRepository.insectsAvailableInDecemberSH();
    }
}
