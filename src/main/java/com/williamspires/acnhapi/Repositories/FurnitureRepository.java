package com.williamspires.acnhapi.Repositories;

import com.williamspires.acnhapi.Model.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FurnitureRepository extends JpaRepository<Furniture, String> {

    Furniture getFurnitureByName(String name);

    @Query(value = "select * from furniture", nativeQuery = true)
    List<Furniture> getAllFurniture();
}
