package com.williamspires.acnhapi.Repositories;

import com.williamspires.acnhapi.Model.Fossil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FossilRepository extends JpaRepository<Fossil, String> {

    Fossil findFossilByName(String name);

    @Query(value="select * from fossils", nativeQuery=true)
    List<Fossil> getAllFossils();
}
