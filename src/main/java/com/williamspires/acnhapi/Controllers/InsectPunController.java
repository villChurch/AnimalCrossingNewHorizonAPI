package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Model.InsectPuns;
import com.williamspires.acnhapi.Repositories.InsectPunRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InsectPunController {

    private final InsectPunRepository insectPunRepository;
    InsectPunController(InsectPunRepository insectPunRepository){
        this.insectPunRepository = insectPunRepository;
    }

    @GetMapping("/puns/insect")
    public InsectPuns getRandomInsectPun() {
        List<InsectPuns> allPuns = insectPunRepository.getAllInsectPuns();
        int randomNumber = (int) (Math.random() * (allPuns.size() + 1));
        System.out.println(randomNumber);
        allPuns.get(randomNumber).setText(allPuns.get(randomNumber).getText().replaceAll("\\u000e", " "));
        return allPuns.get(randomNumber);
    }
}
