package com.williamspires.acnhapi.Repositories;

import com.williamspires.acnhapi.Model.AllCatalogItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AllCatalogItemsRepository extends JpaRepository<AllCatalogItems, String> {

    @Query(value="SELECT * FROM AllCatalogFurniture", nativeQuery=true)
    List<AllCatalogItems> getAllItems();
}
