package com.williamspires.acnhapi.Repositories;

import com.williamspires.acnhapi.Model.Outfits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutfitRepository extends JpaRepository<Outfits, String> {

    @Query(value="select * from dress_up", nativeQuery=true)
    List<Outfits> getAllOutfits();

    List<Outfits> findOutfitsByName(String name);
}
