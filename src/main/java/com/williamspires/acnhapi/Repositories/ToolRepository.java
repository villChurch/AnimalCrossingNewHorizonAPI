package com.williamspires.acnhapi.Repositories;

import com.williamspires.acnhapi.Model.Tools;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToolRepository extends JpaRepository<Tools, String> {

/* TO-DO find a way to make dinstinct work.
*  needs unique entitty id in JPA which wont produce distinct results
*  Probably going to need to not use JPA
*
*  @Query(value = "SELECT `me`, `DIY`,`Uses`,`Buy`,`Sell`,`Miles_Price` FROM `tools` WHERE me = ?1 GROUP BY me, Uses, DIY, Buy, Sell, Miles_Price", nativeQuery = true)
*  Tools findToolsByNameDistinct(String name);
*
 */

    List<Tools> findToolByName(String name);

    @Query(value = "select * from tools", nativeQuery = true)
    List<Tools> getAllTools();
}
