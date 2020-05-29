package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Model.InsectPuns;
import com.williamspires.acnhapi.Repositories.InsectPunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InsectPunController {

    @Autowired
    InsectPunRepository insectPunRepository;

    @GetMapping("/puns/insect")
    public InsectPuns getRandomInsectPun() {
        List<InsectPuns> allPuns = insectPunRepository.getAllInsectPuns();
        int randomNumber = (int) (Math.random() * (allPuns.size() + 1));
        System.out.println(randomNumber);
        allPuns.get(randomNumber).setText(allPuns.get(randomNumber).getText().replaceAll("\\u000e", " "));
        return allPuns.get(randomNumber);
    }
}
