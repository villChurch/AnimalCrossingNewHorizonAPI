package com.williamspires.acnhapi.Repositories;

import com.williamspires.acnhapi.Model.ShSeasonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShSeasonalRepository extends JpaRepository<ShSeasonal, String> {

    List<ShSeasonal> findByBlossoms (String shrub);

    @Query(value="select * from shseasons", nativeQuery=true)
    List<ShSeasonal> getAllShBlossoms();
}
