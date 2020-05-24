package com.williamspires.acnhapi.Repositories;

import com.williamspires.acnhapi.Model.Tools;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToolRepository extends JpaRepository<Tools, String> {

    Tools findToolByName(String name);
}
