package com.williamspires.acnhapi.Repositories;

import com.williamspires.acnhapi.Model.Recipes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipesRepository extends JpaRepository<Recipes, String> {

    Recipes findRecipesByName(String Name);
}
