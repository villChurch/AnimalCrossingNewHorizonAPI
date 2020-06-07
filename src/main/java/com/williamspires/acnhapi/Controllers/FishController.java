package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Exceptions.FishNotFoundException;
import com.williamspires.acnhapi.Model.Fish;
import com.williamspires.acnhapi.Repositories.FishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FishController {

    private final FishRepository fishRepository;
    FishController(FishRepository fishRepository){
        this.fishRepository = fishRepository;
    }

    @GetMapping("/fish/{name}")
    public Fish getFishByName(@PathVariable String name) {
        Fish fish = fishRepository.findFishByName(name);
        if(null == fish){
            throw new FishNotFoundException(name);
        }
        return fish;
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

    @GetMapping("/fish/available/January/NH")
    public List<Fish> getFishsInJanuaryNH() {
        return fishRepository.fishAvailableInJanuaryNH();
    }

    @GetMapping("/fish/available/January/SH")
    public List<Fish> getFishesInJanuarySH() {
        return fishRepository.fishAvailableInJanuarySH();
    }

    @GetMapping("/fish/available/February/NH")
    public List<Fish> getFishesInFebruaryNH() {
        return fishRepository.fishAvailableInFebruaryNH();
    }

    @GetMapping("/fish/available/February/SH")
    public List<Fish> getFishesInFebruarySH() {
        return fishRepository.fishAvailableInFebruarySH();
    }

    @GetMapping("/fish/available/March/NH")
    public List<Fish> getFishesInMarchNH() {
        return fishRepository.fishAvailableInMarchNH();
    }

    @GetMapping("/fish/available/March/SH")
    public List<Fish> getFishesInMarchSH() {
        return fishRepository.fishAvailableInMarchSH();
    }

    @GetMapping("/fish/available/April/NH")
    public List<Fish> getFishesInAprilNH() {
        return fishRepository.fishAvailableInAprilNH();
    }

    @GetMapping("/fish/available/April/SH")
    public List<Fish> getFishesInAprilSH() {
        return fishRepository.fishAvailableInAprilSH();
    }

    @GetMapping("/fish/available/May/NH")
    public List<Fish> getFishesInMayNH() {
        return fishRepository.fishAvailableInMayNH();
    }

    @GetMapping("/fish/available/May/SH")
    public List<Fish> getFishesInMaySH() {
        return fishRepository.fishAvailableInMaySH();
    }

    @GetMapping("/fish/available/June/NH")
    public List<Fish> getFishesInJuneNH() {
        return fishRepository.fishAvailableInJuneNH();
    }

    @GetMapping("/fish/available/June/SH")
    public List<Fish> getFishesInJuneSH() {
        return fishRepository.fishAvailableInJuneSH();
    }

    @GetMapping("/fish/available/July/NH")
    public List<Fish> getFishesInJulyNH() {
        return fishRepository.fishAvailableInJulyNH();
    }

    @GetMapping("/fish/available/July/SH")
    public List<Fish> getFishesInJulySH() {
        return fishRepository.fishAvailableInJulySH();
    }

    @GetMapping("/fish/available/August/NH")
    public List<Fish> getFishesInAugustNH() {
        return fishRepository.fishAvailableInAugustNH();
    }

    @GetMapping("/fish/available/August/SH")
    public List<Fish> getFishesInAugustSH() {
        return fishRepository.fishAvailableInAugustSH();
    }

    @GetMapping("/fish/available/September/NH")
    public List<Fish> getFishesInSeptemberNH() {
        return fishRepository.fishAvailableInSeptemberNH();
    }

    @GetMapping("/fish/available/September/SH")
    public List<Fish> getFishesInSeptemberSH() {
        return fishRepository.fishAvailableInSeptemberSH();
    }

    @GetMapping("/fish/available/October/NH")
    public List<Fish> getFishesInOctoberNH() {
        return fishRepository.fishAvailabeInOctoberNH();
    }

    @GetMapping("/fish/available/October/SH")
    public List<Fish> getFishesInOctoberSH() {
        return fishRepository.fishAvailableInOctoberSH();
    }

    @GetMapping("/fish/available/November/NH")
    public List<Fish> getFishesInNovemberNH() {
        return fishRepository.fishAvailableInNovemberNH();
    }

    @GetMapping("/fish/available/November/SH")
    public List<Fish> getFishesInNovemberSH() {
        return fishRepository.fishAvailableInNovemberSH();
    }

    @GetMapping("/fish/available/December/NH")
    public List<Fish> getFishesInDecemberNH() {
        return fishRepository.fishAvailableInDecemberNH();
    }

    @GetMapping("/fish/available/December/SH")
    public List<Fish> getFishesInDecemberSH() {
        return fishRepository.fishAvailableInDecemberSH();
    }

    @GetMapping("/fish/leaving/January/NH")
    public List<Fish> getFishesLeavingAfterJanuaryNH() {
        return fishRepository.fishLeavingAfterJanuaryNH();
    }

    @GetMapping("/fish/leaving/January/SH")
    public List<Fish> getFishesLeavingAfterJanuarySH() {
        return fishRepository.fishLeavingAfterJanuarySH();
    }

    @GetMapping("/fish/leaving/February/NH")
    public List<Fish> getFishesLeavingAfterFebruaryNH() {
        return fishRepository.fishLeavingAfterFebruaryNH();
    }

    @GetMapping("/fish/leaving/February/SH")
    public List<Fish> getFishesLeavingAfterFebruarySH() {
        return fishRepository.fishLeavingAfterFebruarySH();
    }

    @GetMapping("/fish/leaving/March/NH")
    public List<Fish> getFishesLeavingAfterMarchNH() {
        return fishRepository.fishLeavingAfterMarchNH();
    }

    @GetMapping("/fish/leaving/March/SH")
    public List<Fish> getFishesLeavingAfterMarchSH() {
        return fishRepository.fishLeavingAfterMarchSH();
    }

    @GetMapping("/fish/leaving/April/NH")
    public List<Fish> getFishesLeavingAfterAprilNH() {
        return fishRepository.fishLeavingAfterAprilNH();
    }

    @GetMapping("/fish/leaving/April/SH")
    public List<Fish> getFishesLeavingAfterAprilSH() {
        return fishRepository.fishLeavingAfterAprilSH();
    }

    @GetMapping("/fish/leaving/May/NH")
    public List<Fish> getFishesLeavingAfterMayNH() {
        return fishRepository.fishLeavingAfterMayNH();
    }

    @GetMapping("/fish/leaving/May/SH")
    public List<Fish> getFishesLeavingAfterMaySH() {
        return fishRepository.fishLeavingAfterMaySH();
    }

    @GetMapping("/fish/leaving/June/NH")
    public List<Fish> getFishesLeavingAfterJuneNH() {
        return fishRepository.fishLeavingAfterJuneNH();
    }

    @GetMapping("/fish/leaving/June/SH")
    public List<Fish> getFishesLeavingAfterJuneSH() {
        return fishRepository.fishLeavingAfterJuneSH();
    }

    @GetMapping("/fish/leaving/July/NH")
    public List<Fish> getFishesLeavingAfterJulyNH() {
        return fishRepository.fishLeavingAfterJulyNH();
    }

    @GetMapping("/fish/leaving/July/SH")
    public List<Fish> getFishesLeavingAfterJulySH() {
        return fishRepository.fishLeavingAfterJulySH();
    }

    @GetMapping("/fish/leaving/August/NH")
    public List<Fish> getFishesLeavingAfterAugustNH() {
        return fishRepository.fishLeavingAfterAugustNH();
    }

    @GetMapping("/fish/leaving/August/SH")
    public List<Fish> getFishesLeavingAfterAugustSH() {
        return fishRepository.fishLeavingAfterAugustSH();
    }

    @GetMapping("/fish/leaving/September/NH")
    public List<Fish> getFishesLeavingAfterSeptemberNH() {
        return fishRepository.fishLeavingAfterSeptemberNH();
    }

    @GetMapping("/fish/leaving/September/SH")
    public List<Fish> getFishesLeavingAfterSeptemberSH() {
        return fishRepository.fishLeavingAfterSeptemberSH();
    }

    @GetMapping("/fish/leaving/October/NH")
    public List<Fish> getFishesLeavingAfterOctoberNH() {
        return fishRepository.fishLeavingAfterOctoberNH();
    }

    @GetMapping("/fish/leaving/October/SH")
    public List<Fish> getFishesLeavingAfterOctoberSH() {
        return fishRepository.fishLeavingAfterOctoberSH();
    }

    @GetMapping("/fish/leaving/November/NH")
    public List<Fish> getFishesLeavingAfterNovemberNH() {
        return fishRepository.fishLeavingAfterNovemberNH();
    }

    @GetMapping("/fish/leaving/November/SH")
    public List<Fish> getFishesLeavingAfterNovemberSH() {
        return fishRepository.fishLeavingAfterNovemberSH();
    }

    @GetMapping("/fish/leaving/December/NH")
    public List<Fish> getFishesLeavingAfterDecemberNH() {
        return fishRepository.fishLeavingAfterDecemberNH();
    }

    @GetMapping("/fish/leaving/December/SH")
    public List<Fish> getFishesLeavingAfterDecemberSH() {
        return fishRepository.fishLeavingAfterDecemberSH();
    }
    @GetMapping("/fish/arriving/January/NH")
    public List<Fish> getFishArrivingInJanuaryNH() {
        return fishRepository.fishArrivingInJanuaryNH();
    }

    @GetMapping("/fish/arriving/January/SH")
    public List<Fish> getFishArrivingInJanuarySH() {
        return fishRepository.fishArrivingInJanuarySH();
    }

    @GetMapping("/fish/arriving/February/NH")
    public List<Fish> getFishArrivingInFebruaryNH() {
        return fishRepository.fishArrivingInFebruaryNH();
    }

    @GetMapping("/fish/arriving/February/SH")
    public List<Fish> getFishArrivingInFebruarySH() {
        return fishRepository.fishArrivingInFebruarySH();
    }

    @GetMapping("/fish/arriving/March/NH")
    public List<Fish> getFishArrivingInMarchNH() {
        return fishRepository.fishArrivingInMarchNH();
    }

    @GetMapping("/fish/arriving/March/SH")
    public List<Fish> getFishArrivingInMarchSH() {
        return fishRepository.fishArrivingInMarchSH();
    }

    @GetMapping("/fish/arriving/April/NH")
    public List<Fish> getFishArrivingInAprilNH() {
        return fishRepository.fishArrivingInAprilNH();
    }

    @GetMapping("/fish/arriving/April/SH")
    public List<Fish> getFishArrivingInAprilSH() {
        return fishRepository.fishArrivingInAprilSH();
    }

    @GetMapping("/fish/arriving/May/NH")
    public List<Fish> getFishArrivingInMayNH() {
        return fishRepository.fishArrivingInMayNH();
    }

    @GetMapping("/fish/arriving/May/SH")
    public List<Fish> getFishArrivingInMaySH() {
        return fishRepository.fishArrivingInMaySH();
    }

    @GetMapping("/fish/arriving/June/NH")
    public List<Fish> getFishArrivingInJuneNH() {
        return fishRepository.fishArrivingInJuneNH();
    }

    @GetMapping("/fish/arriving/June/SH")
    public List<Fish> getFishArrivingInJuneSH() {
        return fishRepository.fishArrivingInJuneSH();
    }

    @GetMapping("/fish/arriving/July/NH")
    public List<Fish> getFishArrivingInJulyNH() {
        return fishRepository.fishArrivingInJulyNH();
    }

    @GetMapping("/fish/arriving/July/SH")
    public List<Fish> getFishArrivingInJulySH() {
        return fishRepository.fishArrivingInJulySH();
    }

    @GetMapping("/fish/arriving/August/NH")
    public List<Fish> getFishArrivingInAugustNH() {
        return fishRepository.fishArrivingInAugustNH();
    }

    @GetMapping("/fish/arriving/August/SH")
    public List<Fish> getFishArrivingInAugustSH() {
        return fishRepository.fishArrivingInAugustSH();
    }

    @GetMapping("/fish/arriving/September/NH")
    public List<Fish> getFishArrivingInSeptemberNH() {
        return fishRepository.fishArrivingInSeptemberNH();
    }

    @GetMapping("/fish/arriving/September/SH")
    public List<Fish> getFishArrivingInSeptemberSH() {
        return fishRepository.fishArrivingInSeptemberSH();
    }

    @GetMapping("/fish/arriving/October/NH")
    public List<Fish> getFishArrivingInOctoberNH() {
        return fishRepository.fishArrivingInOctoberNH();
    }

    @GetMapping("/fish/arriving/October/SH")
    public List<Fish> getFishArrivingInOctoberSH() {
        return fishRepository.fishArrivingInOctoberSH();
    }

    @GetMapping("/fish/arriving/November/NH")
    public List<Fish> getFishArrivingInNovemberNH() {
        return fishRepository.fishArrivingInNovemberNH();
    }

    @GetMapping("/fish/arriving/November/SH")
    public List<Fish> getFishArrivingInNovemberSH() {
        return fishRepository.fishArrivingInNovemberSH();
    }

    @GetMapping("/fish/arriving/December/NH")
    public List<Fish> getFishArrivingInDecemberNH() {
        return fishRepository.fishArrivingInDecemberNH();
    }

    @GetMapping("/fish/arriving/December/SH")
    public List<Fish> getFishArrivingInDecemberSH() {
        return fishRepository.fishArrivingInDecemberSH();
    }
}
