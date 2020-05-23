package com.williamspires.acnhapi.Repositories;

import com.williamspires.acnhapi.Model.Raymond;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaymondRepository extends JpaRepository<Raymond, String> {

    Raymond getRaymondByItem(String item);
}
