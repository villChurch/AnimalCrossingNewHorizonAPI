package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Model.FishPuns;
import com.williamspires.acnhapi.Repositories.FishPunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FishPunController {

    private final FishPunRepository fishPunRepository;
    FishPunController(FishPunRepository fishPunRepository){
        this.fishPunRepository = fishPunRepository;
    }

    @GetMapping("/puns/fish")
    public FishPuns getRandomFishPun() {
        List<FishPuns> allPuns = fishPunRepository.getAllFishPuns();
        int randomNumber = (int) (Math.random() * (allPuns.size() + 1));
        allPuns.get(randomNumber).setText(allPuns.get(randomNumber).getText().replaceAll("\\u000e", " "));
        return allPuns.get(randomNumber);
    }
}
