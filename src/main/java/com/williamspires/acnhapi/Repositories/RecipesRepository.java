package com.williamspires.acnhapi.Repositories;

import com.williamspires.acnhapi.Model.Recipes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipesRepository extends JpaRepository<Recipes, String> {

    Recipes findRecipesByName(String Name);
}
