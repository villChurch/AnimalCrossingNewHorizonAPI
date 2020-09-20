package com.williamspires.acnhapi.Repositories;

import com.williamspires.acnhapi.Model.CatalogItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogItemsRepostiory extends JpaRepository<CatalogItems, String> {

    @Query(value="SELECT * FROM CatalogFurniture", nativeQuery=true)
    List<CatalogItems> getAllItems();
}
