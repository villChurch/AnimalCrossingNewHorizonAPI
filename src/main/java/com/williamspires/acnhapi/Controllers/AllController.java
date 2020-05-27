package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Model.*;
import com.williamspires.acnhapi.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AllController {

    @Autowired
    VillagerRepository villagerRepository;
    @Autowired
    FishRepository fishRepository;
    @Autowired
    ConstructionRepository constructionRepository;
    @Autowired
    FencingRepository fencingRepository;
    @Autowired
    FurnitureRepository furnitureRepository;
    @Autowired
    InsectRepository insectRepository;
    @Autowired
    RecipesRepository recipesRepository;
    @Autowired
    RedItemRepository redItemRepository;
    @Autowired
    ToolRepository toolRepository;
    @Autowired
    FossilRepository fossilRepository;

    @GetMapping("/all/villager")
    public List<Villager> getAllVillagers() {
        return villagerRepository.getAllVillagers();
    }

    @GetMapping("/all/fish")
    public List<Fish> getAllFish() {
        return fishRepository.getAllFish();
    }

    @GetMapping("/all/construction")
    public List<Construction> getAllConstructionItems() {
        return constructionRepository.getAllConstruction();
    }

    @GetMapping("/all/fencing")
    public List<Fencing> getAllFencingItems() {
        return fencingRepository.getAllFencing();
    }

    @GetMapping("/all/furniture")
    public List<Furniture> getAllFurniture() {
        return furnitureRepository.getAllFurniture();
    }

    @GetMapping("/all/insects")
    public List<Insect> getAllInsects() {
        return insectRepository.getAllInsects();
    }

    @GetMapping("/all/recipes")
    public List<Recipes> getAllRecipes() {
        return recipesRepository.getAllRecipes();
    }

    @GetMapping("/all/reditems")
    public List<RedItem> getAllRedItems() {
        return redItemRepository.getAllRedItems();
    }

    @GetMapping("/all/tools")
    public List<Tools> getAllTools() {
        return toolRepository.getAllTools();
    }

    @GetMapping("/all/fossils")
    public List<Fossil> getAllFossils() {
        return fossilRepository.getAllFossils();
    }
}
