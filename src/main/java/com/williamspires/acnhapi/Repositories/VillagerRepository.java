package com.williamspires.acnhapi.Repositories;

import com.williamspires.acnhapi.Model.Villager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VillagerRepository extends JpaRepository<Villager, Integer> {

    Villager findVillagerByName(String name);

    List<Villager> findVillagerByPersonality(String personality);

    @Query(value = "select * from villagers", nativeQuery = true)
    List<Villager> getAllVillagers();

    List<Villager> findVillagersBySpecies(String species);

    List<Villager> findVillagersByFavoriteSong(String favoriteSong);
}
