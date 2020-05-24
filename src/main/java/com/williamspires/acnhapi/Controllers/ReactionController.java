package com.williamspires.acnhapi.Controllers;

import java.util.List;
import com.williamspires.acnhapi.Model.Reactions;
import com.williamspires.acnhapi.Repositories.ReactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReactionController {

    @Autowired
    ReactionRepository reactionRepository;

    @GetMapping("/reaction/{name}")
    public Reactions getReactionByName(@PathVariable String name) {
        return reactionRepository.findReactionsByName(name);
    }

    @GetMapping("/reaction/source/{source}")
    public List<Reactions> getReactinosBySource(@PathVariable String source) {
        return reactionRepository.findReactionsBySource(source);
    }
}
