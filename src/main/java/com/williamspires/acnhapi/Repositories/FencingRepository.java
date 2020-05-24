package com.williamspires.acnhapi.Repositories;

import com.williamspires.acnhapi.Model.Fencing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FencingRepository extends JpaRepository<Fencing, String> {

    Fencing findFencingByName(String name);
}
