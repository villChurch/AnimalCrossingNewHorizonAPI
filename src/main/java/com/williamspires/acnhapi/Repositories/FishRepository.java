package com.williamspires.acnhapi.Repositories;

import com.williamspires.acnhapi.Model.Fish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FishRepository extends JpaRepository<Fish, Integer> {

    Fish findFishByName(String name);

    @Query(value="select * from fish where NH_JAN <> 'NA' OR SH_JAN <> 'NA'", nativeQuery = true)
    List<Fish> fishAvailableInJanuary();

    @Query(value="select * from fish where NH_FEB <> 'NA' OR SH_FEB <> 'NA'", nativeQuery = true)
    List<Fish> fishAvailableInFeb();

    @Query(value = "select * from fish where NH_MAR <> 'NA' OR SH_MAR <> 'NA'", nativeQuery = true)
    List<Fish> fishAvailableInMarch();

    @Query(value = "select * from fish where NH_APR <> 'NA' OR SH_APR <> 'NA'", nativeQuery = true)
    List<Fish> fishAvailableInApril();

    @Query(value = "select * from fish where NH_MAY <> 'NA' OR SH_MAY <> 'NA'", nativeQuery = true)
    List<Fish> fishAvailableInMay();

    @Query(value = "select * from fish where NH_JUN <> 'NA' OR SH_JUN <> 'NA'", nativeQuery = true)
    List<Fish> fishAvailableInJune();

    @Query(value = "select * from fish where NH_JUL <> 'NA' OR SH_JUL <> 'NA'", nativeQuery = true)
    List<Fish> fishAvailableInJuly();

    @Query(value = "select * from fish where NH_AUG <> 'NA' OR SH_AUG <> 'NA'", nativeQuery = true)
    List<Fish> fishAvailableInAugust();

    @Query(value = "select * from fish where NH_SEP <> 'NA' OR SH_SEP <> 'NA'", nativeQuery = true)
    List<Fish> fishAvailableInSeptember();

    @Query(value = "select * from fish where NH_OCT <> 'NA' OR SH_OCT <> 'NA'", nativeQuery = true)
    List<Fish> fishAvailableInOctober();

    @Query(value = "select * from fish where NH_NOV <> 'NA' OR SH_NOV <> 'NA'", nativeQuery = true)
    List<Fish> fishAvailableInNovember();

    @Query(value = "select * from fish where NH_DEC <> 'NA' OR SH_DEC <> 'NA'", nativeQuery = true)
    List<Fish> fishAvailableInDecember();

    @Query(value = "select * from fish", nativeQuery = true)
    List<Fish> getAllFish();
}
