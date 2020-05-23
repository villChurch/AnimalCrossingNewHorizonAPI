package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Model.Recipes;
import com.williamspires.acnhapi.Repositories.RecipesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {

    @Autowired
    RecipesRepository recipesRepository;

    @GetMapping("/diy/{name}")
    public Recipes getByName(@PathVariable String name) {
        return recipesRepository.findRecipesByName(name);
    }

}
