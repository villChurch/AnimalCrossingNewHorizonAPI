package com.williamspires.acnhapi.Repositories;

import com.williamspires.acnhapi.Model.RedItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RedItemRepository extends JpaRepository<RedItem, String> {

    RedItem findItemByName(String name);

    @Query(value = "select * from red", nativeQuery = true)
    List<RedItem> getAllRedItems();
}
