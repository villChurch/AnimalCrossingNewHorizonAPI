package com.williamspires.acnhapi.Repositories;

import com.williamspires.acnhapi.Model.Fish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FishRepository extends JpaRepository<Fish, Integer> {

    Fish findFishByName(String name);
}
