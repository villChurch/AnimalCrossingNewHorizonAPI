package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Exceptions.InsectNotFoundException;
import com.williamspires.acnhapi.Model.ApiEvent;
import com.williamspires.acnhapi.Model.Insect;
import com.williamspires.acnhapi.Repositories.ApiEventRepository;
import com.williamspires.acnhapi.Repositories.InsectRepository;
import com.williamspires.acnhapi.Utils.LevenshteinDistance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Slf4j
@RestController
public class InsectController {

    private final InsectRepository insectRepository;
    private final ApiEventRepository apiEventRepository;
    InsectController(InsectRepository insectRepository, ApiEventRepository apiEventRepository){
        this.insectRepository = insectRepository;
        this.apiEventRepository = apiEventRepository;
    }

    @GetMapping("/insect/{name}")
    public Insect getInsectByName(@PathVariable String name) {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/" + name);
        Insect insect = insectRepository.findInsectByName(name);
        if(null == insect){
            List<Insect> insects = insectRepository.getAllInsects();
            Map<String, Integer> likeness = new HashMap<>();
            insects.forEach(insect1 -> likeness.put(insect1.getName(),
                    LevenshteinDistance.percentage(name.toLowerCase(), insect1.getName().toLowerCase())));
            String key =
                    Collections.max(likeness.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
            log.warn("Villager was not found called {} but one was found called {} with a {}% match to search term",
                    name, key, likeness.get(key));
            if (likeness.get(key) >= 75) {
                event.setPath("/insect/" + key);
                log.info("Likeness was above or equal to 75% at {}% so returning insect named {}", likeness.get(key), key);
                return  insectRepository.findInsectByName(key);
            } else {
                throw new InsectNotFoundException(name);
            }
        }
        apiEventRepository.insertApiEvent(event);
        return insect;
    }

    @GetMapping("/insect/available/January")
    public List<Insect> getInsectByMonth() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/available/January");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsAvailableInJanuary();
    }

    @GetMapping("/insect/available/February")
    public List<Insect> getInsectInFeb() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/available/February");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsAvailableInFebruary();
    }

    @GetMapping("/insect/available/March")
    public List<Insect> getInsectInMarch() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/available/March");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsAvailableInMarch();
    }

    @GetMapping("/insect/available/April")
    public List<Insect> getInsectInApril() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/available/April");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsAvailableInApril();
    }

    @GetMapping("/insect/available/May")
    public List<Insect> getInsectInMay() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/available/May");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsAvailableInMay();
    }

    @GetMapping("/insect/available/June")
    public List<Insect> getInsectInJune() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/available/June");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsAvailableInJune();
    }

    @GetMapping("/insect/available/July")
    public List<Insect> getInsectInJuly() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/available/July");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsAvailableInJuly();
    }

    @GetMapping("/insect/available/August")
    public List<Insect> getInsectInAugust() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/available/August");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsAvailableInAugust();
    }

    @GetMapping("/insect/available/September")
    public List<Insect> getInsectInSeptember() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/available/September");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsAvailableInSeptember();
    }

    @GetMapping("/insect/available/October")
    public List<Insect> getInsectInOctober() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/available/October");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsAvailableInOctober();
    }

    @GetMapping("/insect/available/November")
    public List<Insect> getInsectInNovember() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/available/November");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsAvailableInNovember();
    }

    @GetMapping("/insect/available/December")
    public List<Insect> getInsectInDecember() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/available/December");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsAvailableInDecember();
    }

    @GetMapping("/insect/available/January/NH")
    public List<Insect> getInsectsInJanuaryNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/available/January/NH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsAvailableInJanuaryNH();
    }

    @GetMapping("/insect/available/January/SH")
    public List<Insect> getInsectsInJanuarySH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/available/January/SH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsAvailableInJanuarySH();
    }

    @GetMapping("/insect/available/February/NH")
    public List<Insect> getInsectsInFebruaryNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/available/February/NH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsAvailableInFebruaryNH();
    }

    @GetMapping("/insect/available/February/SH")
    public List<Insect> getInsectsInFebruarySH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/available/February/SH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsAvailableInFebruarySH();
    }

    @GetMapping("/insect/available/March/NH")
    public List<Insect> getInsectsInMarchNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/available/March/NH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsAvailableInMarchNH();
    }

    @GetMapping("/insect/available/March/SH")
    public List<Insect> getInsectsInMarchSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/available/March/SH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsAvailableInMarchSH();
    }

    @GetMapping("/insect/available/April/NH")
    public List<Insect> getInsectsInAprilNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/available/April/NH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsAvailableInAprilNH();
    }

    @GetMapping("/insect/available/April/SH")
    public List<Insect> getInsectsInAprilSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/available/April/SH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsAvailableInAprilSH();
    }

    @GetMapping("/insect/available/May/NH")
    public List<Insect> getInsectsInMayNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/available/May/NH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsAvailableInMayNH();
    }

    @GetMapping("/insect/available/May/SH")
    public List<Insect> getInsectsInMaySH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/available/May/SH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsAvailableInMaySH();
    }

    @GetMapping("/insect/available/June/NH")
    public List<Insect> getInsectsInJuneNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/available/June/NH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsAvailableInJuneNH();
    }

    @GetMapping("/insect/available/June/SH")
    public List<Insect> getInsectsInJuneSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/available/June/SH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsAvailableInJuneSH();
    }

    @GetMapping("/insect/available/July/NH")
    public List<Insect> getInsectsInJulyNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/available/July/NH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsAvailableInJulyNH();
    }

    @GetMapping("/insect/available/July/SH")
    public List<Insect> getInsectsInJulySH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/available/July/SH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsAvailableInJulySH();
    }

    @GetMapping("/insect/available/August/NH")
    public List<Insect> getInsectsInAugustNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/available/August/NH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsAvailableInAugustNH();
    }

    @GetMapping("/insect/available/August/SH")
    public List<Insect> getInsectsInAugustSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/available/August/SH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsAvailableInAugustSH();
    }

    @GetMapping("/insect/available/September/NH")
    public List<Insect> getInsectsInSeptemberNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/available/September/NH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsAvailableInSeptemberNH();
    }

    @GetMapping("/insect/available/September/SH")
    public List<Insect> getInsectsInSeptemberSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/available/September/SH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsAvailableInSeptemberSH();
    }

    @GetMapping("/insect/available/October/NH")
    public List<Insect> getInsectsInOctoberNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/available/October/NH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsAvailabeInOctoberNH();
    }

    @GetMapping("/insect/available/October/SH")
    public List<Insect> getInsectsInOctoberSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/available/October/SH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsAvailableInOctoberSH();
    }

    @GetMapping("/insect/available/November/NH")
    public List<Insect> getInsectsInNovemberNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/available/November/NH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsAvailableInNovemberNH();
    }

    @GetMapping("/insect/available/November/SH")
    public List<Insect> getInsectsInNovemberSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/available/November/SH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsAvailableInNovemberSH();
    }

    @GetMapping("/insect/available/December/NH")
    public List<Insect> getInsectsInDecemberNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/available/December/NH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsAvailableInDecemberNH();
    }

    @GetMapping("/insect/available/December/SH")
    public List<Insect> getInsectsInDecemberSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/available/December/SH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsAvailableInDecemberSH();
    }

    @GetMapping("/insect/leaving/January/NH")
    public List<Insect> getInsectsLeavingAfterJanuaryNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/leaving/January/NH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsLeavingAfterJanuaryNH();
    }

    @GetMapping("/insect/leaving/January/SH")
    public List<Insect> getInsectsLeavingAfterJanuarySH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/leaving/January/SH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsLeavingAfterJanuarySH();
    }

    @GetMapping("/insect/leaving/February/NH")
    public List<Insect> getInsectsLeavingAfterFebruaryNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/leaving/February/NH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsLeavingAfterFebruaryNH();
    }

    @GetMapping("/insect/leaving/February/SH")
    public List<Insect> getInsectsLeavingAfterFebruarySH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/leaving/February/SH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsLeavingAfterFebruarySH();
    }

    @GetMapping("/insect/leaving/March/NH")
    public List<Insect> getInsectsLeavingAfterMarchNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/leaving/March/NH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsLeavingAfterMarchNH();
    }

    @GetMapping("/insect/leaving/March/SH")
    public List<Insect> getInsectsLeavingAfterMarchSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/leaving/March/SH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsLeavingAfterMarchSH();
    }

    @GetMapping("/insect/leaving/April/NH")
    public List<Insect> getInsectsLeavingAfterAprilNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/leaving/April/NH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsLeavingAfterAprilNH();
    }

    @GetMapping("/insect/leaving/April/SH")
    public List<Insect> getInsectsLeavingAfterAprilSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/leaving/April/SH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsLeavingAfterAprilSH();
    }

    @GetMapping("/insect/leaving/May/NH")
    public List<Insect> getInsectsLeavingAfterMayNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/leaving/May/NH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsLeavingAfterMayNH();
    }

    @GetMapping("/insect/leaving/May/SH")
    public List<Insect> getInsectsLeavingAfterMaySH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/leaving/May/SH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsLeavingAfterMaySH();
    }

    @GetMapping("/insect/leaving/June/NH")
    public List<Insect> getInsectsLeavingAfterJuneNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/leaving/June/NH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsLeavingAfterJuneNH();
    }

    @GetMapping("/insect/leaving/June/SH")
    public List<Insect> getInsectsLeavingAfterJuneSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/leaving/June/SH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsLeavingAfterJuneSH();
    }

    @GetMapping("/insect/leaving/July/NH")
    public List<Insect> getInsectsLeavingAfterJulyNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/leaving/July/NH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsLeavingAfterJulyNH();
    }

    @GetMapping("/insect/leaving/July/SH")
    public List<Insect> getInsectsLeavingAfterJulySH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/leaving/July/SH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsLeavingAfterJulySH();
    }

    @GetMapping("/insect/leaving/August/NH")
    public List<Insect> getInsectsLeavingAfterAugustNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/leaving/August/NH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsLeavingAfterAugustNH();
    }

    @GetMapping("/insect/leaving/August/SH")
    public List<Insect> getInsectsLeavingAfterAugustSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/leaving/August/SH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsLeavingAfterAugustSH();
    }

    @GetMapping("/insect/leaving/September/NH")
    public List<Insect> getInsectsLeavingAfterSeptemberNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/leaving/September/NH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsLeavingAfterSeptemberNH();
    }

    @GetMapping("/insect/leaving/September/SH")
    public List<Insect> getInsectsLeavingAfterSeptemberSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/leaving/September/SH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsLeavingAfterSeptemberSH();
    }

    @GetMapping("/insect/leaving/October/NH")
    public List<Insect> getInsectsLeavingAfterOctoberNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/leaving/October/NH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsLeavingAfterOctoberNH();
    }

    @GetMapping("/insect/leaving/October/SH")
    public List<Insect> getInsectsLeavingAfterOctoberSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/leaving/October/SH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsLeavingAfterOctoberSH();
    }

    @GetMapping("/insect/leaving/November/NH")
    public List<Insect> getInsectsLeavingAfterNovemberNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/leaving/November/NH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsLeavingAfterNovemberNH();
    }

    @GetMapping("/insect/leaving/November/SH")
    public List<Insect> getInsectsLeavingAfterNovemberSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/leaving/November/SH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsLeavingAfterNovemberSH();
    }

    @GetMapping("/insect/leaving/December/NH")
    public List<Insect> getInsectsLeavingAfterDecemberNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/leaving/December/NH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsLeavingAfterDecemberNH();
    }

    @GetMapping("/insect/leaving/December/SH")
    public List<Insect> getInsectsLeavingAfterDecemberSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/leaving/December/SH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsLeavingAfterDecemberSH();
    }

    @GetMapping("/insect/arriving/January/NH")
    public List<Insect> getInsectsArrivingInJanuaryNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/arriving/January/NH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsArrivingInJanuaryNH();
    }

    @GetMapping("/insect/arriving/January/SH")
    public List<Insect> getInsectsArrivingInJanuarySH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/arriving/January/SH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsArrivingInJanuarySH();
    }

    @GetMapping("/insect/arriving/February/NH")
    public List<Insect> getInsectsArrivingInFebruaryNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/arriving/February/NH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsArrivingInFebruaryNH();
    }

    @GetMapping("/insect/arriving/February/SH")
    public List<Insect> getInsectsArrivingInFebruarySH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/arriving/February/SH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsArrivingInFebruarySH();
    }

    @GetMapping("/insect/arriving/March/NH")
    public List<Insect> getInsectsArrivingInMarchNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/arriving/March/NH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsArrivingInMarchNH();
    }

    @GetMapping("/insect/arriving/March/SH")
    public List<Insect> getInsectsArrivingInMarchSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/arriving/March/SH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsArrivingInMarchSH();
    }

    @GetMapping("/insect/arriving/April/NH")
    public List<Insect> getInsectsArrivingInAprilNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/arriving/April/NH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsArrivingInAprilNH();
    }

    @GetMapping("/insect/arriving/April/SH")
    public List<Insect> getInsectsArrivingInAprilSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/arriving/April/SH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsArrivingInAprilSH();
    }

    @GetMapping("/insect/arriving/May/NH")
    public List<Insect> getInsectsArrivingInMayNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/arriving/May/NH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsArrivingInMayNH();
    }

    @GetMapping("/insect/arriving/May/SH")
    public List<Insect> getInsectsArrivingInMaySH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/arriving/May/SH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsArrivingInMaySH();
    }

    @GetMapping("/insect/arriving/June/NH")
    public List<Insect> getInsectsArrivingInJuneNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/arriving/June/NH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsArrivingInJuneNH();
    }

    @GetMapping("/insect/arriving/June/SH")
    public List<Insect> getInsectsArrivingInJuneSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/arriving/June/SH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsArrivingInJuneSH();
    }

    @GetMapping("/insect/arriving/July/NH")
    public List<Insect> getInsectsArrivingInJulyNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/arriving/July/NH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsArrivingInJulyNH();
    }

    @GetMapping("/insect/arriving/July/SH")
    public List<Insect> getInsectsArrivingInJulySH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/arriving/July/SH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsArrivingInJulySH();
    }

    @GetMapping("/insect/arriving/August/NH")
    public List<Insect> getInsectsArrivingInAugustNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/arriving/August/NH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsArrivingInAugustNH();
    }

    @GetMapping("/insect/arriving/August/SH")
    public List<Insect> getInsectsArrivingInAugustSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/arriving/August/SH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsArrivingInAugustSH();
    }

    @GetMapping("/insect/arriving/September/NH")
    public List<Insect> getInsectsArrivingInSeptemberNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/arriving/September/NH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsArrivingInSeptemberNH();
    }

    @GetMapping("/insect/arriving/September/SH")
    public List<Insect> getInsectsArrivingInSeptemberSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/arriving/September/SH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsArrivingInSeptemberSH();
    }

    @GetMapping("/insect/arriving/October/NH")
    public List<Insect> getInsectsArrivingInOctoberNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/arriving/October/NH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsArrivingInOctoberNH();
    }

    @GetMapping("/insect/arriving/October/SH")
    public List<Insect> getInsectsArrivingInOctoberSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/arriving/October/SH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsArrivingInOctoberSH();
    }

    @GetMapping("/insect/arriving/November/NH")
    public List<Insect> getInsectsArrivingInNovemberNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/arriving/November/NH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsArrivingInNovemberNH();
    }

    @GetMapping("/insect/arriving/November/SH")
    public List<Insect> getInsectsArrivingInNovemberSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/arriving/November/SH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsArrivingInNovemberSH();
    }

    @GetMapping("/insect/arriving/December/NH")
    public List<Insect> getInsectsArrivingInDecemberNH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/arriving/December/NH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsArrivingInDecemberNH();
    }

    @GetMapping("/insect/arriving/December/SH")
    public List<Insect> getInsectsArrivingInDecemberSH() {
        ApiEvent event = new ApiEvent();
        event.setPath("/insect/arriving/December/SH");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.insectsArrivingInDecemberSH();
    }
}
