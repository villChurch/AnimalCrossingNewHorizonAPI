package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Exceptions.RecipeNotFoundException;
import com.williamspires.acnhapi.Model.Recipes;
import com.williamspires.acnhapi.Repositories.RecipesRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {

    private final RecipesRepository recipesRepository;
    RecipeController(RecipesRepository recipesRepository){
        this.recipesRepository = recipesRepository;
    }

    @GetMapping("/diy/{name}")
    public Recipes getByName(@PathVariable String name) {
        Recipes recipe = recipesRepository.findRecipesByName(name);
        if(null == recipe){
            throw new RecipeNotFoundException(name);
        }
        return recipe;
    }

}
