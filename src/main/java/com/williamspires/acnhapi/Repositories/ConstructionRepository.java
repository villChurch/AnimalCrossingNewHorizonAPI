package com.williamspires.acnhapi.Repositories;

import com.williamspires.acnhapi.Model.Construction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConstructionRepository  extends JpaRepository<Construction, String> {

    Construction findConstructionByName(String name);

    @Query(value = "select * from construction", nativeQuery = true)
    List<Construction> getAllConstruction();
}
