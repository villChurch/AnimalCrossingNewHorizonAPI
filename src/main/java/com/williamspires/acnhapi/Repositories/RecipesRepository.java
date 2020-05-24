package com.williamspires.acnhapi.Repositories;

import com.williamspires.acnhapi.Model.Recipes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipesRepository extends JpaRepository<Recipes, String> {

    Recipes findRecipesByName(String Name);

    @Query(value = "select * from recipes", nativeQuery = true)
    List<Recipes> getAllRecipes();
}
