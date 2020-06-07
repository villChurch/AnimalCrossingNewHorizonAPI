package com.williamspires.acnhapi.Repositories;

import com.williamspires.acnhapi.Model.InsectPuns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface InsectPunRepository extends JpaRepository<InsectPuns, String> {

    @Query(value="select * from sys_get_insect", nativeQuery=true)
    List<InsectPuns> getAllInsectPuns();
}
