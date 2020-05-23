package com.williamspires.acnhapi.Repositories;

import com.williamspires.acnhapi.Model.RedItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RedItemRepository extends JpaRepository<RedItem, String> {

    RedItem findItemByName(String name);
}
