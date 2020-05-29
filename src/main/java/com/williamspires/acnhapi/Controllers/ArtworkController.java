package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Model.Artwork;
import com.williamspires.acnhapi.Repositories.ArtworkRepository;
import com.williamspires.acnhapi.Utils.RandomCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArtworkController {

    @Autowired
    ArtworkRepository artworkRepository;

    @GetMapping("/artwork/real/{name}")
    public Artwork getRealArtwork(@PathVariable String name){
        return  artworkRepository.getArtworkByNameAndReal(name, true);
    }

    @GetMapping("/artwork/fake/{name}")
    public Artwork getFakeArtwork(@PathVariable String name){
        return  artworkRepository.getArtworkByNameAndReal(name, false);
    }

    @GetMapping("/artwork/all/real")
    public List<Artwork> getAllRealArtwork() {
        return  artworkRepository.getAllRealArtwork();
    }

    @GetMapping("/artwork/all/fake")
    public List<Artwork> getAllFakeArtwork() {
        return artworkRepository.getAllFakeArtwork();
    }

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
