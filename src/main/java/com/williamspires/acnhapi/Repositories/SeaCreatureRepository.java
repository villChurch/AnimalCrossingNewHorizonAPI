package com.williamspires.acnhapi.Repositories;

import com.williamspires.acnhapi.Model.SeaCreatures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeaCreatureRepository extends JpaRepository<SeaCreatures, String> {

    @Query(value="select * from seacreatures where Name = :name", nativeQuery=true)
    SeaCreatures findSeaCreatureByName(@Param("name") String name);

    @Query(value="select * from seacreatures where NH_JAN <> 'NA' OR SH_JAN <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesAvailableInJanuary();

    @Query(value="select * from seacreatures where NH_FEB <> 'NA' OR SH_FEB <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesAvailableInFebruary();

    @Query(value = "select * from seacreatures where NH_MAR <> 'NA' OR SH_MAR <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesAvailableInMarch();

    @Query(value = "select * from seacreatures where NH_APR <> 'NA' OR SH_APR <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesAvailableInApril();

    @Query(value = "select * from seacreatures where NH_MAY <> 'NA' OR SH_MAY <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesAvailableInMay();

    @Query(value = "select * from seacreatures where NH_JUN <> 'NA' OR SH_JUN <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesAvailableInJune();

    @Query(value = "select * from seacreatures where NH_JUL <> 'NA' OR SH_JUL <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesAvailableInJuly();

    @Query(value = "select * from seacreatures where NH_AUG <> 'NA' OR SH_AUG <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesAvailableInAugust();

    @Query(value = "select * from seacreatures where NH_SEP <> 'NA' OR SH_SEP <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesAvailableInSeptember();

    @Query(value = "select * from seacreatures where NH_OCT <> 'NA' OR SH_OCT <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesAvailableInOctober();

    @Query(value = "select * from seacreatures where NH_NOV <> 'NA' OR SH_NOV <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesAvailableInNovember();

    @Query(value = "select * from seacreatures where NH_DEC <> 'NA' OR SH_DEC <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesAvailableInDecember();

    @Query(value = "select * from seacreatures where NH_JAN <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesAvailableInJanuaryNH();

    @Query(value = "select * from seacreatures where SH_JAN <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesAvailableInJanuarySH();

    @Query(value = "select * from seacreatures where NH_FEB <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesAvailableInFebruaryNH();

    @Query(value = "select * from seacreatures where SH_FEB <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesAvailableInFebruarySH();

    @Query(value = "select * from seacreatures where NH_MAR <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesAvailableInMarchNH();

    @Query(value = "select * from seacreatures where SH_MAR <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesAvailableInMarchSH();

    @Query(value = "select * from seacreatures where NH_APR <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesAvailableInAprilNH();

    @Query(value = "select * from seacreatures where SH_APR <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesAvailableInAprilSH();

    @Query(value = "select * from seacreatures where NH_MAY <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesAvailableInMayNH();

    @Query(value = "select * from seacreatures where SH_MAY <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesAvailableInMaySH();

    @Query(value = "select * from seacreatures where NH_JUN <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesAvailableInJuneNH();

    @Query(value = "select * from seacreatures where SH_JUN <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesAvailableInJuneSH();

    @Query(value = "select * from seacreatures where NH_JUL <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesAvailableInJulyNH();

    @Query(value = "select * from seacreatures where SH_JUL <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesAvailableInJulySH();

    @Query(value = "select * from seacreatures where NH_AUG <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesAvailableInAugustNH();

    @Query(value = "select * from seacreatures where SH_AUG <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesAvailableInAugustSH();

    @Query(value = "select * from seacreatures where NH_SEP <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesAvailableInSeptemberNH();

    @Query(value = "select * from seacreatures where SH_SEP <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesAvailableInSeptemberSH();

    @Query(value = "select * from seacreatures where NH_OCT <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesAvailabeInOctoberNH();

    @Query(value = "select* from seacreatures where SH_OCT <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesAvailableInOctoberSH();

    @Query(value = "select * from seacreatures where NH_NOV <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesAvailableInNovemberNH();

    @Query(value = "select * from seacreatures where SH_NOV <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesAvailableInNovemberSH();

    @Query(value = "select * from seacreatures where NH_DEC <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesAvailableInDecemberNH();

    @Query(value = "select * from seacreatures where SH_DEC <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesAvailableInDecemberSH();

    @Query(value = "select * from seacreatures where NH_JAN <> 'NA' AND NH_FEB = 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesLeavingAfterJanuaryNH();

    @Query(value = "select * from seacreatures where SH_JAN <> 'NA' AND SH_FEB = 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesLeavingAfterJanuarySH();

    @Query(value = "select * from seacreatures where NH_FEB <> 'NA' AND NH_MAR = 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesLeavingAfterFebruaryNH();

    @Query(value = "select * from seacreatures where SH_FEB <> 'NA' AND SH_MAR = 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesLeavingAfterFebruarySH();

    @Query(value = "select * from seacreatures where NH_MAR <> 'NA' AND NH_APR = 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesLeavingAfterMarchNH();

    @Query(value = "select * from seacreatures where SH_MAR <> 'NA' AND SH_APR = 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesLeavingAfterMarchSH();

    @Query(value = "select * from seacreatures where NH_APR <> 'NA' AND NH_MAY = 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesLeavingAfterAprilNH();

    @Query(value = "select * from seacreatures where SH_APR <> 'NA' AND SH_MAY = 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesLeavingAfterAprilSH();

    @Query(value = "select * from seacreatures where NH_MAY <> 'NA' AND NH_JUN = 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesLeavingAfterMayNH();

    @Query(value = "select * from seacreatures where SH_MAY <> 'NA' AND SH_JUN = 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesLeavingAfterMaySH();

    @Query(value = "select * from seacreatures where NH_JUN <> 'NA' AND NH_JUL = 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesLeavingAfterJuneNH();

    @Query(value = "select * from seacreatures where SH_JUN <> 'NA' AND SH_JUL = 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesLeavingAfterJuneSH();

    @Query(value = "select * from seacreatures where NH_JUL <> 'NA' AND NH_AUG = 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesLeavingAfterJulyNH();

    @Query(value = "select * from seacreatures where SH_JUL <> 'NA' AND SH_AUG = 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesLeavingAfterJulySH();

    @Query(value = "select * from seacreatures where NH_AUG <> 'NA' AND NH_SEP = 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesLeavingAfterAugustNH();

    @Query(value = "select * from seacreatures where SH_AUG <> 'NA' AND SH_SEP = 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesLeavingAfterAugustSH();

    @Query(value = "select * from seacreatures where NH_SEP <> 'NA' AND NH_OCT = 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesLeavingAfterSeptemberNH();

    @Query(value = "select * from seacreatures where SH_SEP <> 'NA' AND SH_OCT = 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesLeavingAfterSeptemberSH();

    @Query(value = "select * from seacreatures where NH_OCT <> 'NA' AND NH_NOV = 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesLeavingAfterOctoberNH();

    @Query(value = "select * from seacreatures where SH_OCT <> 'NA' AND SH_NOV = 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesLeavingAfterOctoberSH();

    @Query(value = "select * from seacreatures where NH_NOV <> 'NA' AND NH_DEC = 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesLeavingAfterNovemberNH();

    @Query(value = "select * from seacreatures where SH_NOV <> 'NA' AND SH_DEC = 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesLeavingAfterNovemberSH();

    @Query(value = "select * from seacreatures where NH_DEC <> 'NA' AND NH_JAN = 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesLeavingAfterDecemberNH();

    @Query(value = "select * from seacreatures where SH_DEC <> 'NA' AND SH_JAN = 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesLeavingAfterDecemberSH();

    @Query(value = "select * from seacreatures where NH_DEC = 'NA' AND NH_JAN <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesArrivingInJanuaryNH();

    @Query(value = "select * from seacreatures where SH_DEC = 'NA' AND SH_JAN <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesArrivingInJanuarySH();

    @Query(value = "select * from seacreatures where NH_JAN = 'NA' AND NH_FEB <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesArrivingInFebruaryNH();

    @Query(value = "select * from seacreatures where SH_JAN = 'NA' AND SH_FEB <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesArrivingInFebruarySH();

    @Query(value = "select * from seacreatures where NH_FEB = 'NA' AND NH_MAR <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesArrivingInMarchNH();

    @Query(value = "select * from seacreatures where SH_FEB = 'NA' AND SH_MAR <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesArrivingInMarchSH();

    @Query(value = "select * from seacreatures where NH_MAR = 'NA' AND NH_APR <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesArrivingInAprilNH();

    @Query(value = "select * from seacreatures where SH_MAR = 'NA' AND SH_APR <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesArrivingInAprilSH();

    @Query(value = "select * from seacreatures where NH_APR = 'NA' AND NH_MAY <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesArrivingInMayNH();

    @Query(value = "select * from seacreatures where SH_APR = 'NA' AND SH_MAY <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesArrivingInMaySH();

    @Query(value = "select * from seacreatures where NH_MAY = 'NA' AND NH_JUN <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesArrivingInJuneNH();

    @Query(value = "select * from seacreatures where SH_MAY = 'NA' AND SH_JUN <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesArrivingInJuneSH();

    @Query(value = "select * from seacreatures where NH_JUN = 'NA' AND NH_JUL <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesArrivingInJulyNH();

    @Query(value = "select * from seacreatures where SH_JUN = 'NA' AND SH_JUL <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesArrivingInJulySH();

    @Query(value = "select * from seacreatures where NH_JUL = 'NA' AND NH_AUG <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesArrivingInAugustNH();

    @Query(value = "select * from seacreatures where SH_JUL = 'NA' AND SH_AUG <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesArrivingInAugustSH();

    @Query(value = "select * from seacreatures where NH_AUG = 'NA' AND NH_SEP <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesArrivingInSeptemberNH();

    @Query(value = "select * from seacreatures where SH_AUG = 'NA' AND SH_SEP <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesArrivingInSeptemberSH();

    @Query(value = "select * from seacreatures where NH_SEP = 'NA' AND NH_OCT <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesArrivingInOctoberNH();

    @Query(value = "select * from seacreatures where SH_SEP = 'NA' AND SH_OCT <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesArrivingInOctoberSH();

    @Query(value = "select * from seacreatures where NH_OCT = 'NA' AND NH_NOV <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesArrivingInNovemberNH();

    @Query(value = "select * from seacreatures where SH_OCT = 'NA' AND SH_NOV <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesArrivingInNovemberSH();

    @Query(value = "select * from seacreatures where NH_NOV = 'NA' AND NH_DEC <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesArrivingInDecemberNH();

    @Query(value = "select * from seacreatures where SH_NOV = 'NA' AND SH_DEC <> 'NA'", nativeQuery = true)
    List<SeaCreatures> seacreaturesArrivingInDecemberSH();

    @Query(value = "select * from seacreatures", nativeQuery = true)
    List<SeaCreatures> getAllSeaCreatures();
    
}
