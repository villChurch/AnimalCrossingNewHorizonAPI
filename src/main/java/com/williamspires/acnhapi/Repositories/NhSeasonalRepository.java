package com.williamspires.acnhapi.Repositories;

import com.williamspires.acnhapi.Model.NhSeasonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhSeasonalRepository extends JpaRepository<NhSeasonal, String> {

    List<NhSeasonal> findByBlossoms(String blossoms);

    @Query(value="select * from nhseasons", nativeQuery=true)
    List<NhSeasonal> getAllNhBlossoms();
}
