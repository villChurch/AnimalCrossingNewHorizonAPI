package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Exceptions.ReactionNotFoundException;
import com.williamspires.acnhapi.Exceptions.ReactionSourceNotFoundException;
import com.williamspires.acnhapi.Model.Reactions;
import com.williamspires.acnhapi.Repositories.ReactionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReactionController {

    private final ReactionRepository reactionRepository;
    ReactionController(ReactionRepository reactionRepository){
        this.reactionRepository = reactionRepository;
    }

    @GetMapping("/reaction/{name}")
    public Reactions getReactionByName(@PathVariable String name) {
        Reactions reaction = reactionRepository.findReactionsByName(name);
        if(null == reaction){
            throw new ReactionNotFoundException(name);
        }
        return reaction;
    }

    @GetMapping("/reaction/source/{source}")
    public List<Reactions> getReactionsBySource(@PathVariable String source) {
        List<Reactions> reactions = reactionRepository.findReactionsBySource(source);
        if(null == reactions || reactions.size() < 1){
            throw new ReactionSourceNotFoundException(source);
        }
        return reactions;
    }
}
