package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Exceptions.ArtworkNotFoundException;
import com.williamspires.acnhapi.Model.Artwork;
import com.williamspires.acnhapi.Repositories.ArtworkRepository;
import com.williamspires.acnhapi.Utils.RandomCollection;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Artwork and Statues", description = "Information on Artwork and Statues from Redd")
@RestController
public class ArtworkController {

    private final ArtworkRepository artworkRepository;
    ArtworkController(ArtworkRepository artworkRepository){
        this.artworkRepository = artworkRepository;
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
        Artwork artwork = artworkRepository.getArtworkByNameAndReal(name, true);
        if(null == artwork){
            throw new ArtworkNotFoundException(name);
        }
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
        Artwork artwork = artworkRepository.getArtworkByNameAndReal(name, false);
        if(null == artwork){
            throw new ArtworkNotFoundException(name);
        }
        return  artwork;
    }

    @Operation(summary = "Return all Real Artwork or Statues")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Artwork.class))))
    })
    @GetMapping("/artwork/all/real")
    public List<Artwork> getAllRealArtwork() {
        return  artworkRepository.getAllRealArtwork();
    }

    @Operation(summary = "Return all Fake Artwork or Statues")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Artwork.class))))
    })
    @GetMapping("/artwork/all/fake")
    public List<Artwork> getAllFakeArtwork() {
        return artworkRepository.getAllFakeArtwork();
    }

    @Operation(summary = "Returns a random piece of artwork. 60% chance of fake, 40% chance of real")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Artwork.class))))
    })
    @GetMapping("/artwork/random")
    public Artwork getRandomArtwork() {
        List<Artwork> realArtwork = artworkRepository.getAllRealArtwork();
        List<Artwork> fakeArtwork = artworkRepository.getAllFakeArtwork();
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
            int randomNumber = (int) (Math.random() * realArtwork.size() + 1);
            return realArtwork.get(randomNumber);
        } else {
            int randomNumber = (int) (Math.random() * fakeArtwork.size() + 1);
            return fakeArtwork.get(randomNumber);
        }
    }

}
