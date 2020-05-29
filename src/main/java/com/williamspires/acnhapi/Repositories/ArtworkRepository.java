package com.williamspires.acnhapi.Repositories;

import com.williamspires.acnhapi.Model.Artwork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ArtworkRepository extends JpaRepository<Artwork, String> {

    Artwork getArtworkByNameAndReal(String name, Boolean real);

    @Query(value="select * from artwork", nativeQuery=true)
    List<Artwork> getAllArtwork();

    @Query(value="select * from artwork where Genuine = 1", nativeQuery=true)
    List<Artwork> getAllRealArtwork();

    @Query(value="select * from artwork where Genuine = 0", nativeQuery=true)
    List<Artwork> getAllFakeArtwork();
}
