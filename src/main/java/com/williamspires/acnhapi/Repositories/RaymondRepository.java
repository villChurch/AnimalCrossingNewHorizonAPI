package com.williamspires.acnhapi.Repositories;

import com.williamspires.acnhapi.Model.Raymond;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaymondRepository extends JpaRepository<Raymond, String> {

    Raymond getRaymondByItem(String item);
}
