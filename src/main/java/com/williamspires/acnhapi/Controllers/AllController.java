package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Model.*;
import com.williamspires.acnhapi.Repositories.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "All", description = "Returns all information stored for a model")
@RestController
public class AllController {

    public AllController(VillagerRepository villagerRepository, FishRepository fishRepository,
                         ConstructionRepository constructionRepository, FencingRepository fencingRepository,
                         FurnitureRepository furnitureRepository, InsectRepository insectRepository,
                         RecipesRepository recipesRepository, ToolRepository toolRepository,
                         FossilRepository fossilRepository, ArtworkRepository artworkRepository,
                         AcnhEventsRepository acnhEventsRepository, OutfitRepository outfitRepository,
                         NhSeasonalRepository nhSeasonalRepository, ShSeasonalRepository shSeasonalRepository,
                         ApiEventRepository apiEventRepository)
    {
        this.villagerRepository = villagerRepository;
        this.fishRepository = fishRepository;
        this.constructionRepository = constructionRepository;
        this.fencingRepository = fencingRepository;
        this.furnitureRepository = furnitureRepository;
        this.insectRepository = insectRepository;
        this.recipesRepository = recipesRepository;
        this.toolRepository = toolRepository;
        this.fossilRepository = fossilRepository;
        this.artworkRepository = artworkRepository;
        this.acnhEventsRepository = acnhEventsRepository;
        this.outfitRepository = outfitRepository;
        this.nhSeasonalRepository = nhSeasonalRepository;
        this.shSeasonalRepository = shSeasonalRepository;
        this.apiEventRepository = apiEventRepository;
    }

    VillagerRepository villagerRepository;
    FishRepository fishRepository;
    ConstructionRepository constructionRepository;
    FencingRepository fencingRepository;
    FurnitureRepository furnitureRepository;
    InsectRepository insectRepository;
    RecipesRepository recipesRepository;
    ToolRepository toolRepository;
    FossilRepository fossilRepository;
    ArtworkRepository artworkRepository;
    AcnhEventsRepository acnhEventsRepository;
    OutfitRepository outfitRepository;
    NhSeasonalRepository nhSeasonalRepository;
    ShSeasonalRepository shSeasonalRepository;
    private final ApiEventRepository apiEventRepository;

    @Operation(summary = "Returns all villagers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Villager.class))))
    })
    @GetMapping("/all/villager")
    public List<Villager> getAllVillagers() {
        ApiEvent event = new ApiEvent();
        event.setPath("/all/villager");
        apiEventRepository.insertApiEvent(event);
        return villagerRepository.getAllVillagers();
    }

    @Operation(summary = "Returns all fish")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Fish.class))))
    })
    @GetMapping("/all/fish")
    public List<Fish> getAllFish() {
        ApiEvent event = new ApiEvent();
        event.setPath("/all/fish");
        apiEventRepository.insertApiEvent(event);
        return fishRepository.getAllFish();
    }

    @Operation(summary = "Returns all Construction Items")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Construction.class))))
    })
    @GetMapping("/all/construction")
    public List<Construction> getAllConstructionItems() {
        ApiEvent event = new ApiEvent();
        event.setPath("/all/construction");
        apiEventRepository.insertApiEvent(event);
        return constructionRepository.getAllConstruction();
    }

    @Operation(summary = "Returns all fences")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Fencing.class))))
    })
    @GetMapping("/all/fencing")
    public List<Fencing> getAllFencingItems() {
        ApiEvent event = new ApiEvent();
        event.setPath("/all/fencing");
        apiEventRepository.insertApiEvent(event);
        return fencingRepository.getAllFencing();
    }

    @Operation(summary = "Returns all furniture")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Furniture.class))))
    })
    @GetMapping("/all/furniture")
    public List<Furniture> getAllFurniture() {
        ApiEvent event = new ApiEvent();
        event.setPath("/all/furniture");
        apiEventRepository.insertApiEvent(event);
        return furnitureRepository.getAllFurniture();
    }

    @Operation(summary = "Returns all insects")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Insect.class))))
    })
    @GetMapping("/all/insects")
    public List<Insect> getAllInsects() {
        ApiEvent event = new ApiEvent();
        event.setPath("/all/insects");
        apiEventRepository.insertApiEvent(event);
        return insectRepository.getAllInsects();
    }

    @Operation(summary = "Returns all recipes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Recipes.class))))
    })
    @GetMapping("/all/recipes")
    public List<Recipes> getAllRecipes() {
        ApiEvent event = new ApiEvent();
        event.setPath("/all/recipes");
        apiEventRepository.insertApiEvent(event);
        return recipesRepository.getAllRecipes();
    }

    @Operation(summary = "Returns all tools")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Tools.class))))
    })
    @GetMapping("/all/tools")
    public List<Tools> getAllTools() {
        ApiEvent event = new ApiEvent();
        event.setPath("/all/tools");
        apiEventRepository.insertApiEvent(event);
        return toolRepository.getAllTools();
    }

    @Operation(summary = "Returns all fossils")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Fossil.class))))
    })
    @GetMapping("/all/fossils")
    public List<Fossil> getAllFossils() {
        ApiEvent event = new ApiEvent();
        event.setPath("/all/fossils");
        apiEventRepository.insertApiEvent(event);
        return fossilRepository.getAllFossils();
    }

    @Operation(summary = "Returns all artwork")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Artwork.class))))
    })
    @GetMapping("/all/artwork")
    public List<Artwork> getAllArtwork() {
        ApiEvent event = new ApiEvent();
        event.setPath("/all/artwork");
        apiEventRepository.insertApiEvent(event);
        return  artworkRepository.getAllArtwork();
    }

    @Operation(summary = "Returns all events")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = acnhevents.class))))
    })
    @GetMapping("/all/events")
    public List<acnhevents> getAllEvents() {
        ApiEvent event = new ApiEvent();
        event.setPath("/all/events");
        apiEventRepository.insertApiEvent(event);
        return acnhEventsRepository.getAllEvents();
    }

    @Operation(summary = "Returns all outfits")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Outfits.class))))
    })
    @GetMapping("/all/outfits")
    public List<Outfits> getAllOutfits() {
        ApiEvent event = new ApiEvent();
        event.setPath("/all/events");
        apiEventRepository.insertApiEvent(event);
        return outfitRepository.getAllOutfits();
    }

    @Operation(summary = "Returns all blossoms for Northern Hemisphere")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = NhSeasonal.class))))
    })
    @GetMapping("/all/blossoms/nh")
    public List<NhSeasonal> getAllNhBlossoms() {
        ApiEvent event = new ApiEvent();
        event.setPath("/all/blossoms/nh");
        apiEventRepository.insertApiEvent(event);
        return nhSeasonalRepository.getAllNhBlossoms();
    }

    @Operation(summary = "Returns all blossoms for Southern Hemisphere")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = ShSeasonal.class))))
    })
    @GetMapping("/all/blossoms/sh")
    public List<ShSeasonal> getAllShBlossoms() {
        ApiEvent event = new ApiEvent();
        event.setPath("/all/blossoms/sh");
        apiEventRepository.insertApiEvent(event);
        return shSeasonalRepository.getAllShBlossoms();
    }
}