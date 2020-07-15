package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Exceptions.SeaCreatureNotFoundException;
import com.williamspires.acnhapi.Model.ApiEvent;
import com.williamspires.acnhapi.Model.SeaCreatures;
import com.williamspires.acnhapi.Repositories.ApiEventRepository;
import com.williamspires.acnhapi.Repositories.SeaCreatureRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SeaCreatureController {

    private final SeaCreatureRepository seacreatureRepository;
    private final ApiEventRepository apiEventRepository;
    SeaCreatureController(SeaCreatureRepository seacreatureRepository, ApiEventRepository apiEventRepository){
        this.seacreatureRepository = seacreatureRepository;
        this.apiEventRepository = apiEventRepository;
    }

    @GetMapping("/seacreature/{name}")
    public SeaCreatures getSeaCreaturesByName(@PathVariable String name) {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/" + name);
        apiEventRepository.insertApiEvent(event);
        SeaCreatures seacreature = seacreatureRepository.findSeaCreatureByName(name);
        if(null == seacreature){
            throw new SeaCreatureNotFoundException(name);
        }
        return seacreature;
    }

    @GetMapping("/seacreature/available/January")
    public List<SeaCreatures> getSeaCreaturesByMonth() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/available/January");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesAvailableInJanuary();
    }

    @GetMapping("/seacreature/available/February")
    public List<SeaCreatures> getSeaCreaturesInFeb() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/available/February");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesAvailableInFebruary();
    }

    @GetMapping("/seacreature/available/March")
    public List<SeaCreatures> getSeaCreaturesInMarch() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/available/March");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesAvailableInMarch();
    }

    @GetMapping("/seacreature/available/April")
    public List<SeaCreatures> getSeaCreaturesInApril() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/available/April");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesAvailableInApril();
    }

    @GetMapping("/seacreature/available/May")
    public List<SeaCreatures> getSeaCreaturesInMay() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/available/May");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesAvailableInMay();
    }

    @GetMapping("/seacreature/available/June")
    public List<SeaCreatures> getSeaCreaturesInJune() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/available/June");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesAvailableInJune();
    }

    @GetMapping("/seacreature/available/July")
    public List<SeaCreatures> getSeaCreaturesInJuly() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/available/July");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesAvailableInJuly();
    }

    @GetMapping("/seacreature/available/August")
    public List<SeaCreatures> getSeaCreaturesInAugust() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/available/August");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesAvailableInAugust();
    }

    @GetMapping("/seacreature/available/September")
    public List<SeaCreatures> getSeaCreaturesInSeptember() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/available/September");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesAvailableInSeptember();
    }

    @GetMapping("/seacreature/available/October")
    public List<SeaCreatures> getSeaCreaturesInOctober() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/available/October");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesAvailableInOctober();
    }

    @GetMapping("/seacreature/available/November")
    public List<SeaCreatures> getSeaCreaturesInNovember() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/available/November");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesAvailableInNovember();
    }

    @GetMapping("/seacreature/available/December")
    public List<SeaCreatures> getSeaCreaturesInDecember() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/available/December");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesAvailableInDecember();
    }

    @GetMapping("/seacreature/available/January/NH")
    public List<SeaCreatures> getSeaCreaturessInJanuaryNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/available/January/NH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesAvailableInJanuaryNH();
    }

    @GetMapping("/seacreature/available/January/SH")
    public List<SeaCreatures> getSeaCreaturessInJanuarySH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/available/January/SH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesAvailableInJanuarySH();
    }

    @GetMapping("/seacreature/available/February/NH")
    public List<SeaCreatures> getSeaCreaturessInFebruaryNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/available/February/NH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesAvailableInFebruaryNH();
    }

    @GetMapping("/seacreature/available/February/SH")
    public List<SeaCreatures> getSeaCreaturessInFebruarySH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/available/February/SH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesAvailableInFebruarySH();
    }

    @GetMapping("/seacreature/available/March/NH")
    public List<SeaCreatures> getSeaCreaturessInMarchNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/available/March/NH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesAvailableInMarchNH();
    }

    @GetMapping("/seacreature/available/March/SH")
    public List<SeaCreatures> getSeaCreaturessInMarchSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/available/March/SH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesAvailableInMarchSH();
    }

    @GetMapping("/seacreature/available/April/NH")
    public List<SeaCreatures> getSeaCreaturessInAprilNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/available/April/NH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesAvailableInAprilNH();
    }

    @GetMapping("/seacreature/available/April/SH")
    public List<SeaCreatures> getSeaCreaturessInAprilSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/available/April/SH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesAvailableInAprilSH();
    }

    @GetMapping("/seacreature/available/May/NH")
    public List<SeaCreatures> getSeaCreaturessInMayNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/available/May/NH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesAvailableInMayNH();
    }

    @GetMapping("/seacreature/available/May/SH")
    public List<SeaCreatures> getSeaCreaturessInMaySH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/available/May/SH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesAvailableInMaySH();
    }

    @GetMapping("/seacreature/available/June/NH")
    public List<SeaCreatures> getSeaCreaturessInJuneNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/available/June/NH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesAvailableInJuneNH();
    }

    @GetMapping("/seacreature/available/June/SH")
    public List<SeaCreatures> getSeaCreaturessInJuneSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/available/June/SH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesAvailableInJuneSH();
    }

    @GetMapping("/seacreature/available/July/NH")
    public List<SeaCreatures> getSeaCreaturessInJulyNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/available/July/NH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesAvailableInJulyNH();
    }

    @GetMapping("/seacreature/available/July/SH")
    public List<SeaCreatures> getSeaCreaturessInJulySH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/available/July/SH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesAvailableInJulySH();
    }

    @GetMapping("/seacreature/available/August/NH")
    public List<SeaCreatures> getSeaCreaturessInAugustNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/available/August/NH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesAvailableInAugustNH();
    }

    @GetMapping("/seacreature/available/August/SH")
    public List<SeaCreatures> getSeaCreaturessInAugustSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/available/August/SH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesAvailableInAugustSH();
    }

    @GetMapping("/seacreature/available/September/NH")
    public List<SeaCreatures> getSeaCreaturessInSeptemberNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/available/September/NH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesAvailableInSeptemberNH();
    }

    @GetMapping("/seacreature/available/September/SH")
    public List<SeaCreatures> getSeaCreaturessInSeptemberSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/available/September/SH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesAvailableInSeptemberSH();
    }

    @GetMapping("/seacreature/available/October/NH")
    public List<SeaCreatures> getSeaCreaturessInOctoberNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/available/October/NH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesAvailabeInOctoberNH();
    }

    @GetMapping("/seacreature/available/October/SH")
    public List<SeaCreatures> getSeaCreaturessInOctoberSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/available/October/SH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesAvailableInOctoberSH();
    }

    @GetMapping("/seacreature/available/November/NH")
    public List<SeaCreatures> getSeaCreaturessInNovemberNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/available/November/NH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesAvailableInNovemberNH();
    }

    @GetMapping("/seacreature/available/November/SH")
    public List<SeaCreatures> getSeaCreaturessInNovemberSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/available/November/SH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesAvailableInNovemberSH();
    }

    @GetMapping("/seacreature/available/December/NH")
    public List<SeaCreatures> getSeaCreaturessInDecemberNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/available/December/NH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesAvailableInDecemberNH();
    }

    @GetMapping("/seacreature/available/December/SH")
    public List<SeaCreatures> getSeaCreaturessInDecemberSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/available/December/SH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesAvailableInDecemberSH();
    }

    @GetMapping("/seacreature/leaving/January/NH")
    public List<SeaCreatures> getSeaCreaturessLeavingAfterJanuaryNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/leaving/January/NH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesLeavingAfterJanuaryNH();
    }

    @GetMapping("/seacreature/leaving/January/SH")
    public List<SeaCreatures> getSeaCreaturessLeavingAfterJanuarySH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/leaving/January/SH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesLeavingAfterJanuarySH();
    }

    @GetMapping("/seacreature/leaving/February/NH")
    public List<SeaCreatures> getSeaCreaturessLeavingAfterFebruaryNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/leaving/February/NH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesLeavingAfterFebruaryNH();
    }

    @GetMapping("/seacreature/leaving/February/SH")
    public List<SeaCreatures> getSeaCreaturessLeavingAfterFebruarySH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/leaving/February/SH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesLeavingAfterFebruarySH();
    }

    @GetMapping("/seacreature/leaving/March/NH")
    public List<SeaCreatures> getSeaCreaturessLeavingAfterMarchNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/leaving/March/NH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesLeavingAfterMarchNH();
    }

    @GetMapping("/seacreature/leaving/March/SH")
    public List<SeaCreatures> getSeaCreaturessLeavingAfterMarchSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/leaving/March/SH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesLeavingAfterMarchSH();
    }

    @GetMapping("/seacreature/leaving/April/NH")
    public List<SeaCreatures> getSeaCreaturessLeavingAfterAprilNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/leaving/April/NH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesLeavingAfterAprilNH();
    }

    @GetMapping("/seacreature/leaving/April/SH")
    public List<SeaCreatures> getSeaCreaturessLeavingAfterAprilSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/leaving/April/SH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesLeavingAfterAprilSH();
    }

    @GetMapping("/seacreature/leaving/May/NH")
    public List<SeaCreatures> getSeaCreaturessLeavingAfterMayNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/leaving/May/NH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesLeavingAfterMayNH();
    }

    @GetMapping("/seacreature/leaving/May/SH")
    public List<SeaCreatures> getSeaCreaturessLeavingAfterMaySH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/leaving/May/SH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesLeavingAfterMaySH();
    }

    @GetMapping("/seacreature/leaving/June/NH")
    public List<SeaCreatures> getSeaCreaturessLeavingAfterJuneNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/leaving/June/NH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesLeavingAfterJuneNH();
    }

    @GetMapping("/seacreature/leaving/June/SH")
    public List<SeaCreatures> getSeaCreaturessLeavingAfterJuneSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/leaving/June/SH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesLeavingAfterJuneSH();
    }

    @GetMapping("/seacreature/leaving/July/NH")
    public List<SeaCreatures> getSeaCreaturessLeavingAfterJulyNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/leaving/July/NH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesLeavingAfterJulyNH();
    }

    @GetMapping("/seacreature/leaving/July/SH")
    public List<SeaCreatures> getSeaCreaturessLeavingAfterJulySH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/leaving/July/SH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesLeavingAfterJulySH();
    }

    @GetMapping("/seacreature/leaving/August/NH")
    public List<SeaCreatures> getSeaCreaturessLeavingAfterAugustNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/leaving/August/NH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesLeavingAfterAugustNH();
    }

    @GetMapping("/seacreature/leaving/August/SH")
    public List<SeaCreatures> getSeaCreaturessLeavingAfterAugustSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/leaving/August/SH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesLeavingAfterAugustSH();
    }

    @GetMapping("/seacreature/leaving/September/NH")
    public List<SeaCreatures> getSeaCreaturessLeavingAfterSeptemberNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/leaving/September/NH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesLeavingAfterSeptemberNH();
    }

    @GetMapping("/seacreature/leaving/September/SH")
    public List<SeaCreatures> getSeaCreaturessLeavingAfterSeptemberSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/leaving/September/SH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesLeavingAfterSeptemberSH();
    }

    @GetMapping("/seacreature/leaving/October/NH")
    public List<SeaCreatures> getSeaCreaturessLeavingAfterOctoberNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/leaving/October/NH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesLeavingAfterOctoberNH();
    }

    @GetMapping("/seacreature/leaving/October/SH")
    public List<SeaCreatures> getSeaCreaturessLeavingAfterOctoberSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/leaving/October/SH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesLeavingAfterOctoberSH();
    }

    @GetMapping("/seacreature/leaving/November/NH")
    public List<SeaCreatures> getSeaCreaturessLeavingAfterNovemberNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/leaving/November/NH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesLeavingAfterNovemberNH();
    }

    @GetMapping("/seacreature/leaving/November/SH")
    public List<SeaCreatures> getSeaCreaturessLeavingAfterNovemberSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/leaving/November/SH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesLeavingAfterNovemberSH();
    }

    @GetMapping("/seacreature/leaving/December/NH")
    public List<SeaCreatures> getSeaCreaturessLeavingAfterDecemberNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/leaving/December/NH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesLeavingAfterDecemberNH();
    }

    @GetMapping("/seacreature/leaving/December/SH")
    public List<SeaCreatures> getSeaCreaturessLeavingAfterDecemberSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/leaving/December/SH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesLeavingAfterDecemberSH();
    }

    @GetMapping("/seacreature/arriving/January/NH")
    public List<SeaCreatures> getSeaCreaturessArrivingInJanuaryNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/arriving/January/NH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesArrivingInJanuaryNH();
    }

    @GetMapping("/seacreature/arriving/January/SH")
    public List<SeaCreatures> getSeaCreaturessArrivingInJanuarySH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/arriving/January/SH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesArrivingInJanuarySH();
    }

    @GetMapping("/seacreature/arriving/February/NH")
    public List<SeaCreatures> getSeaCreaturessArrivingInFebruaryNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/arriving/February/NH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesArrivingInFebruaryNH();
    }

    @GetMapping("/seacreature/arriving/February/SH")
    public List<SeaCreatures> getSeaCreaturessArrivingInFebruarySH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/arriving/February/SH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesArrivingInFebruarySH();
    }

    @GetMapping("/seacreature/arriving/March/NH")
    public List<SeaCreatures> getSeaCreaturessArrivingInMarchNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/arriving/March/NH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesArrivingInMarchNH();
    }

    @GetMapping("/seacreature/arriving/March/SH")
    public List<SeaCreatures> getSeaCreaturessArrivingInMarchSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/arriving/March/SH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesArrivingInMarchSH();
    }

    @GetMapping("/seacreature/arriving/April/NH")
    public List<SeaCreatures> getSeaCreaturessArrivingInAprilNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/arriving/April/NH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesArrivingInAprilNH();
    }

    @GetMapping("/seacreature/arriving/April/SH")
    public List<SeaCreatures> getSeaCreaturessArrivingInAprilSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/arriving/April/SH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesArrivingInAprilSH();
    }

    @GetMapping("/seacreature/arriving/May/NH")
    public List<SeaCreatures> getSeaCreaturessArrivingInMayNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/arriving/May/NH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesArrivingInMayNH();
    }

    @GetMapping("/seacreature/arriving/May/SH")
    public List<SeaCreatures> getSeaCreaturessArrivingInMaySH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/arriving/May/SH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesArrivingInMaySH();
    }

    @GetMapping("/seacreature/arriving/June/NH")
    public List<SeaCreatures> getSeaCreaturessArrivingInJuneNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/arriving/June/NH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesArrivingInJuneNH();
    }

    @GetMapping("/seacreature/arriving/June/SH")
    public List<SeaCreatures> getSeaCreaturessArrivingInJuneSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/arriving/June/SH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesArrivingInJuneSH();
    }

    @GetMapping("/seacreature/arriving/July/NH")
    public List<SeaCreatures> getSeaCreaturessArrivingInJulyNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/arriving/July/NH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesArrivingInJulyNH();
    }

    @GetMapping("/seacreature/arriving/July/SH")
    public List<SeaCreatures> getSeaCreaturessArrivingInJulySH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/arriving/July/SH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesArrivingInJulySH();
    }

    @GetMapping("/seacreature/arriving/August/NH")
    public List<SeaCreatures> getSeaCreaturessArrivingInAugustNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/arriving/August/NH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesArrivingInAugustNH();
    }

    @GetMapping("/seacreature/arriving/August/SH")
    public List<SeaCreatures> getSeaCreaturessArrivingInAugustSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/arriving/August/SH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesArrivingInAugustSH();
    }

    @GetMapping("/seacreature/arriving/September/NH")
    public List<SeaCreatures> getSeaCreaturessArrivingInSeptemberNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/arriving/September/NH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesArrivingInSeptemberNH();
    }

    @GetMapping("/seacreature/arriving/September/SH")
    public List<SeaCreatures> getSeaCreaturessArrivingInSeptemberSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/arriving/September/SH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesArrivingInSeptemberSH();
    }

    @GetMapping("/seacreature/arriving/October/NH")
    public List<SeaCreatures> getSeaCreaturessArrivingInOctoberNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/arriving/October/NH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesArrivingInOctoberNH();
    }

    @GetMapping("/seacreature/arriving/October/SH")
    public List<SeaCreatures> getSeaCreaturessArrivingInOctoberSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/arriving/October/SH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesArrivingInOctoberSH();
    }

    @GetMapping("/seacreature/arriving/November/NH")
    public List<SeaCreatures> getSeaCreaturessArrivingInNovemberNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/arriving/November/NH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesArrivingInNovemberNH();
    }

    @GetMapping("/seacreature/arriving/November/SH")
    public List<SeaCreatures> getSeaCreaturessArrivingInNovemberSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/arriving/November/SH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesArrivingInNovemberSH();
    }

    @GetMapping("/seacreature/arriving/December/NH")
    public List<SeaCreatures> getSeaCreaturessArrivingInDecemberNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/arriving/December/NH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesArrivingInDecemberNH();
    }

    @GetMapping("/seacreature/arriving/December/SH")
    public List<SeaCreatures> getSeaCreaturessArrivingInDecemberSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/seacreature/arriving/December/SH");
        apiEventRepository.insertApiEvent(event);
        return seacreatureRepository.seacreaturesArrivingInDecemberSH();
    }
}
