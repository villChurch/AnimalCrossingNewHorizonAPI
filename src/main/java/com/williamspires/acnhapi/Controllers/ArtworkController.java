package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Exceptions.ArtworkNotFoundException;
import com.williamspires.acnhapi.Model.ApiEvent;
import com.williamspires.acnhapi.Model.Artwork;
import com.williamspires.acnhapi.Repositories.ApiEventRepository;
import com.williamspires.acnhapi.Repositories.ArtworkRepository;
import com.williamspires.acnhapi.Utils.LevenshteinDistance;
import com.williamspires.acnhapi.Utils.RandomCollection;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Tag(name = "Artwork and Statues", description = "Information on Artwork and Statues from Redd")
@RestController
public class ArtworkController {

    private final ArtworkRepository artworkRepository;
    private final ApiEventRepository apiEventRepository;
    ArtworkController(ArtworkRepository artworkRepository, ApiEventRepository apiEventRepository){
        this.artworkRepository = artworkRepository;
        this.apiEventRepository = apiEventRepository;
    }

    @Operation(summary = "Find real artwork or statue by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful opertaion",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Artwork.class)))),
            @ApiResponse(responseCode = "404", description = "Artwork or Statue not found")
    })
    @GetMapping("/artwork/real/{name}")
    public Artwork getRealArtwork(@Parameter(description = "Name of artwork or statue")
                                      @PathVariable String name){
        ApiEvent event = new ApiEvent();
        event.setPath("/artwork/real/" + name);
        Artwork artwork = artworkRepository.getArtworkByNameAndReal(name, true);
        if(null == artwork){
            List<Artwork> realArtwork = artworkRepository.getAllRealArtwork();
            Map<String, Integer> likeness = new HashMap<>();
            realArtwork.forEach(art -> likeness.put(art.getName(),
                    LevenshteinDistance.percentage(name.toLowerCase(), art.getName().toLowerCase())));
            String key =
                    Collections.max(likeness.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
            log.warn("Real artwork was not found called {} but one was found called {} with a {}% match to search term",
                    name, key, likeness.get(key));
            if (likeness.get(key) >= 75) {
                event.setPath("/artwork/real/" + key);
                log.info("Likeness was above or equal to 75% at {}% so returning real artwork called {}", likeness.get(key), key);
                return artworkRepository.getArtworkByNameAndReal(key, true);
            } else {
                throw new ArtworkNotFoundException(name);
            }
        }
        apiEventRepository.insertApiEvent(event);
        return  artwork;
    }

    @Operation(summary = "Find fake artwork or statue by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Artwork.class)))),
            @ApiResponse(responseCode = "404", description = "Artwork or Statue not found")
    })
    @GetMapping("/artwork/fake/{name}")
    public Artwork getFakeArtwork(@Parameter(description = "Name of artwork or statue")
                                      @PathVariable String name){
        ApiEvent event = new ApiEvent();
        event.setPath("/artwork/fake/" + name);
        Artwork artwork = artworkRepository.getArtworkByNameAndReal(name, false);
        if(null == artwork){
            List<Artwork> fakeArtwork = artworkRepository.getAllFakeArtwork();
            Map<String, Integer> likeness = new HashMap<>();
            fakeArtwork.forEach(fakeArt -> likeness.put(fakeArt.getName(),
                    LevenshteinDistance.percentage(name.toLowerCase(), fakeArt.getName().toLowerCase())));
            String key =
                    Collections.max(likeness.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
            log.warn("Fake art was not found called {} but one was found called {} with a {}% match to search term",
                    name, key, likeness.get(key));
            if (likeness.get(key) >= 75) {
                event.setPath("/artwork/fake/" + name);
                log.info("Likeness was above or equal to 75% at {}% so returning fake artwork called {}", likeness.get(key), key);
                return artworkRepository.getArtworkByNameAndReal(key, false);
            } else {
                throw new ArtworkNotFoundException(name);
            }
        }
        apiEventRepository.insertApiEvent(event);
        return  artwork;
    }

    @Operation(summary = "Return all Real Artwork or Statues")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Artwork.class))))
    })
    @GetMapping("/artwork/all/real")
    public List<Artwork> getAllRealArtwork() {
        ApiEvent event = new ApiEvent();
        event.setPath("/artwork/all/real");
        apiEventRepository.insertApiEvent(event);
        return  artworkRepository.getAllRealArtwork();
    }

    @Operation(summary = "Return all Fake Artwork or Statues")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Artwork.class))))
    })
    @GetMapping("/artwork/all/fake")
    public List<Artwork> getAllFakeArtwork() {
        ApiEvent event = new ApiEvent();
        event.setPath("/artwork/all/fake");
        apiEventRepository.insertApiEvent(event);
        return artworkRepository.getAllFakeArtwork();
    }

    @Operation(summary = "Returns a random piece of artwork. 60% chance of fake, 40% chance of real")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Artwork.class))))
    })
    @GetMapping("/artwork/random")
    public Artwork getRandomArtwork() {
        ApiEvent event = new ApiEvent();
        event.setPath("/artwork/random");
        apiEventRepository.insertApiEvent(event);
        /*
        - 10% - 1 fake, 3 real
        - 30% - 2 fake, 2 real
        - 50% - 3 fake, 1 real
        - 10% - 4 fake, 0 real
        */
        RandomCollection<Object> rc = new RandomCollection<>()
                .add(60, "fake").add(40, "real");
        String nextArtwork = rc.next().toString();
        if(nextArtwork.equalsIgnoreCase("real")) {
            List<Artwork> realArtwork = artworkRepository.getAllRealArtwork();
            int random = ThreadLocalRandom.current().nextInt(0, realArtwork.size());
            return realArtwork.get(random);
        } else {
            List<Artwork> fakeArtwork = artworkRepository.getAllFakeArtwork();
            int random = ThreadLocalRandom.current().nextInt(0, fakeArtwork.size());
            return fakeArtwork.get(random);
        }
    }

}
