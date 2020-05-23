package com.williamspires.acnhapi.Repositories;

import com.williamspires.acnhapi.Model.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FurnitureRepository extends JpaRepository<Furniture, String> {

    Furniture getFurnitureByName(String name);
}
