package com.williamspires.acnhapi.Repositories;

import com.williamspires.acnhapi.Model.Tools;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToolRepository extends JpaRepository<Tools, String> {

    Tools findToolByName(String name);

    @Query(value = "select * from red", nativeQuery = true)
    List<Tools> getAllTools();
}
