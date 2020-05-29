package com.williamspires.acnhapi.Repositories;

import com.williamspires.acnhapi.Model.FishPuns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FishPunRepository extends JpaRepository<FishPuns, String> {

    @Query(value="select label, text from sys_get_fish", nativeQuery=true)
    List<FishPuns> getAllFishPuns();
}
