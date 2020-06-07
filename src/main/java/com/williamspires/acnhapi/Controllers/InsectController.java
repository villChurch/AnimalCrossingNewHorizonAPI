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

    @GetMapping("/insect/leaving/January/NH")
    public List<Insect> getInsectsLeavingAfterJanuaryNH() {
        return insectRepository.insectsLeavingAfterJanuaryNH();
    }

    @GetMapping("/insect/leaving/January/SH")
    public List<Insect> getInsectsLeavingAfterJanuarySH() {
        return insectRepository.insectsLeavingAfterJanuarySH();
    }

    @GetMapping("/insect/leaving/February/NH")
    public List<Insect> getInsectsLeavingAfterFebruaryNH() {
        return insectRepository.insectsLeavingAfterFebruaryNH();
    }

    @GetMapping("/insect/leaving/February/SH")
    public List<Insect> getInsectsLeavingAfterFebruarySH() {
        return insectRepository.insectsLeavingAfterFebruarySH();
    }

    @GetMapping("/insect/leaving/March/NH")
    public List<Insect> getInsectsLeavingAfterMarchNH() {
        return insectRepository.insectsLeavingAfterMarchNH();
    }

    @GetMapping("/insect/leaving/March/SH")
    public List<Insect> getInsectsLeavingAfterMarchSH() {
        return insectRepository.insectsLeavingAfterMarchSH();
    }

    @GetMapping("/insect/leaving/April/NH")
    public List<Insect> getInsectsLeavingAfterAprilNH() {
        return insectRepository.insectsLeavingAfterAprilNH();
    }

    @GetMapping("/insect/leaving/April/SH")
    public List<Insect> getInsectsLeavingAfterAprilSH() {
        return insectRepository.insectsLeavingAfterAprilSH();
    }

    @GetMapping("/insect/leaving/May/NH")
    public List<Insect> getInsectsLeavingAfterMayNH() {
        return insectRepository.insectsLeavingAfterMayNH();
    }

    @GetMapping("/insect/leaving/May/SH")
    public List<Insect> getInsectsLeavingAfterMaySH() {
        return insectRepository.insectsLeavingAfterMaySH();
    }

    @GetMapping("/insect/leaving/June/NH")
    public List<Insect> getInsectsLeavingAfterJuneNH() {
        return insectRepository.insectsLeavingAfterJuneNH();
    }

    @GetMapping("/insect/leaving/June/SH")
    public List<Insect> getInsectsLeavingAfterJuneSH() {
        return insectRepository.insectsLeavingAfterJuneSH();
    }

    @GetMapping("/insect/leaving/July/NH")
    public List<Insect> getInsectsLeavingAfterJulyNH() {
        return insectRepository.insectsLeavingAfterJulyNH();
    }

    @GetMapping("/insect/leaving/July/SH")
    public List<Insect> getInsectsLeavingAfterJulySH() {
        return insectRepository.insectsLeavingAfterJulySH();
    }

    @GetMapping("/insect/leaving/August/NH")
    public List<Insect> getInsectsLeavingAfterAugustNH() {
        return insectRepository.insectsLeavingAfterAugustNH();
    }

    @GetMapping("/insect/leaving/August/SH")
    public List<Insect> getInsectsLeavingAfterAugustSH() {
        return insectRepository.insectsLeavingAfterAugustSH();
    }

    @GetMapping("/insect/leaving/September/NH")
    public List<Insect> getInsectsLeavingAfterSeptemberNH() {
        return insectRepository.insectsLeavingAfterSeptemberNH();
    }

    @GetMapping("/insect/leaving/September/SH")
    public List<Insect> getInsectsLeavingAfterSeptemberSH() {
        return insectRepository.insectsLeavingAfterSeptemberSH();
    }

    @GetMapping("/insect/leaving/October/NH")
    public List<Insect> getInsectsLeavingAfterOctoberNH() {
        return insectRepository.insectsLeavingAfterOctoberNH();
    }

    @GetMapping("/insect/leaving/October/SH")
    public List<Insect> getInsectsLeavingAfterOctoberSH() {
        return insectRepository.insectsLeavingAfterOctoberSH();
    }

    @GetMapping("/insect/leaving/November/NH")
    public List<Insect> getInsectsLeavingAfterNovemberNH() {
        return insectRepository.insectsLeavingAfterNovemberNH();
    }

    @GetMapping("/insect/leaving/November/SH")
    public List<Insect> getInsectsLeavingAfterNovemberSH() {
        return insectRepository.insectsLeavingAfterNovemberSH();
    }

    @GetMapping("/insect/leaving/December/NH")
    public List<Insect> getInsectsLeavingAfterDecemberNH() {
        return insectRepository.insectsLeavingAfterDecemberNH();
    }

    @GetMapping("/insect/leaving/December/SH")
    public List<Insect> getInsectsLeavingAfterDecemberSH() {
        return insectRepository.insectsLeavingAfterDecemberSH();
    }

    @GetMapping("/insect/arriving/January/NH")
    public List<Insect> getInsectsArrivingInJanuaryNH() {
        return insectRepository.insectsArrivingInJanuaryNH();
    }

    @GetMapping("/insect/arriving/January/SH")
    public List<Insect> getInsectsArrivingInJanuarySH() {
        return insectRepository.insectsArrivingInJanuarySH();
    }

    @GetMapping("/insect/arriving/February/NH")
    public List<Insect> getInsectsArrivingInFebruaryNH() {
        return insectRepository.insectsArrivingInFebruaryNH();
    }

    @GetMapping("/insect/arriving/February/SH")
    public List<Insect> getInsectsArrivingInFebruarySH() {
        return insectRepository.insectsArrivingInFebruarySH();
    }

    @GetMapping("/insect/arriving/March/NH")
    public List<Insect> getInsectsArrivingInMarchNH() {
        return insectRepository.insectsArrivingInMarchNH();
    }

    @GetMapping("/insect/arriving/March/SH")
    public List<Insect> getInsectsArrivingInMarchSH() {
        return insectRepository.insectsArrivingInMarchSH();
    }

    @GetMapping("/insect/arriving/April/NH")
    public List<Insect> getInsectsArrivingInAprilNH() {
        return insectRepository.insectsArrivingInAprilNH();
    }

    @GetMapping("/insect/arriving/April/SH")
    public List<Insect> getInsectsArrivingInAprilSH() {
        return insectRepository.insectsArrivingInAprilSH();
    }

    @GetMapping("/insect/arriving/May/NH")
    public List<Insect> getInsectsArrivingInMayNH() {
        return insectRepository.insectsArrivingInMayNH();
    }

    @GetMapping("/insect/arriving/May/SH")
    public List<Insect> getInsectsArrivingInMaySH() {
        return insectRepository.insectsArrivingInMaySH();
    }

    @GetMapping("/insect/arriving/June/NH")
    public List<Insect> getInsectsArrivingInJuneNH() {
        return insectRepository.insectsArrivingInJuneNH();
    }

    @GetMapping("/insect/arriving/June/SH")
    public List<Insect> getInsectsArrivingInJuneSH() {
        return insectRepository.insectsArrivingInJuneSH();
    }

    @GetMapping("/insect/arriving/July/NH")
    public List<Insect> getInsectsArrivingInJulyNH() {
        return insectRepository.insectsArrivingInJulyNH();
    }

    @GetMapping("/insect/arriving/July/SH")
    public List<Insect> getInsectsArrivingInJulySH() {
        return insectRepository.insectsArrivingInJulySH();
    }

    @GetMapping("/insect/arriving/August/NH")
    public List<Insect> getInsectsArrivingInAugustNH() {
        return insectRepository.insectsArrivingInAugustNH();
    }

    @GetMapping("/insect/arriving/August/SH")
    public List<Insect> getInsectsArrivingInAugustSH() {
        return insectRepository.insectsArrivingInAugustSH();
    }

    @GetMapping("/insect/arriving/September/NH")
    public List<Insect> getInsectsArrivingInSeptemberNH() {
        return insectRepository.insectsArrivingInSeptemberNH();
    }

    @GetMapping("/insect/arriving/September/SH")
    public List<Insect> getInsectsArrivingInSeptemberSH() {
        return insectRepository.insectsArrivingInSeptemberSH();
    }

    @GetMapping("/insect/arriving/October/NH")
    public List<Insect> getInsectsArrivingInOctoberNH() {
        return insectRepository.insectsArrivingInOctoberNH();
    }

    @GetMapping("/insect/arriving/October/SH")
    public List<Insect> getInsectsArrivingInOctoberSH() {
        return insectRepository.insectsArrivingInOctoberSH();
    }

    @GetMapping("/insect/arriving/November/NH")
    public List<Insect> getInsectsArrivingInNovemberNH() {
        return insectRepository.insectsArrivingInNovemberNH();
    }

    @GetMapping("/insect/arriving/November/SH")
    public List<Insect> getInsectsArrivingInNovemberSH() {
        return insectRepository.insectsArrivingInNovemberSH();
    }

    @GetMapping("/insect/arriving/December/NH")
    public List<Insect> getInsectsArrivingInDecemberNH() {
        return insectRepository.insectsArrivingInDecemberNH();
    }

    @GetMapping("/insect/arriving/December/SH")
    public List<Insect> getInsectsArrivingInDecemberSH() {
        return insectRepository.insectsArrivingInDecemberSH();
    }
}
