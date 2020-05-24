package com.williamspires.acnhapi.Repositories;

import com.williamspires.acnhapi.Model.Fencing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FencingRepository extends JpaRepository<Fencing, String> {

    Fencing findFencingByName(String name);

    @Query(value = "select * from fencing", nativeQuery = true)
    List<Fencing> getAllFencing();
}
