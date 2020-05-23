package com.williamspires.acnhapi.Repositories;

import com.williamspires.acnhapi.Model.Villager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VillagerRepository extends JpaRepository<Villager, Integer> {

    Villager findVillagerByName(String name);
}
