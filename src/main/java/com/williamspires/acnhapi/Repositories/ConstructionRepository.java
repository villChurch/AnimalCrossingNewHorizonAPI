package com.williamspires.acnhapi.Repositories;

import com.williamspires.acnhapi.Model.Construction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstructionRepository  extends JpaRepository<Construction, String> {

    Construction findConstructionByName(String name);
}
