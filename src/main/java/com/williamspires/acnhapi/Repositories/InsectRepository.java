package com.williamspires.acnhapi.Repositories;

import com.williamspires.acnhapi.Model.Insect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsectRepository extends JpaRepository<Insect, String> {

    Insect findInsectByName(String name);

    @Query(value="select * from insects where NH_JAN <> 'NA' OR SH_JAN <> 'NA'", nativeQuery = true)
    List<Insect> insectsAvailableInJanuary();

    @Query(value="select * from insects where NH_FEB <> 'NA' OR SH_FEB <> 'NA'", nativeQuery = true)
    List<Insect> insectsAvailableInFebruary();

    @Query(value = "select * from insects where NH_MAR <> 'NA' OR SH_MAR <> 'NA'", nativeQuery = true)
    List<Insect> insectsAvailableInMarch();

    @Query(value = "select * from insects where NH_APR <> 'NA' OR SH_APR <> 'NA'", nativeQuery = true)
    List<Insect> insectsAvailableInApril();

    @Query(value = "select * from insects where NH_MAY <> 'NA' OR SH_MAY <> 'NA'", nativeQuery = true)
    List<Insect> insectsAvailableInMay();

    @Query(value = "select * from insects where NH_JUN <> 'NA' OR SH_JUN <> 'NA'", nativeQuery = true)
    List<Insect> insectsAvailableInJune();

    @Query(value = "select * from insects where NH_JUL <> 'NA' OR SH_JUL <> 'NA'", nativeQuery = true)
    List<Insect> insectsAvailableInJuly();

    @Query(value = "select * from insects where NH_AUG <> 'NA' OR SH_AUG <> 'NA'", nativeQuery = true)
    List<Insect> insectsAvailableInAugust();

    @Query(value = "select * from insects where NH_SEP <> 'NA' OR SH_SEP <> 'NA'", nativeQuery = true)
    List<Insect> insectsAvailableInSeptember();

    @Query(value = "select * from insects where NH_OCT <> 'NA' OR SH_OCT <> 'NA'", nativeQuery = true)
    List<Insect> insectsAvailableInOctober();

    @Query(value = "select * from insects where NH_NOV <> 'NA' OR SH_NOV <> 'NA'", nativeQuery = true)
    List<Insect> insectsAvailableInNovember();

    @Query(value = "select * from insects where NH_DEC <> 'NA' OR SH_DEC <> 'NA'", nativeQuery = true)
    List<Insect> insectsAvailableInDecember();

    @Query(value = "select * from insects where NH_JAN <> 'NA'", nativeQuery = true)
    List<Insect> insectsAvailableInJanuaryNH();

    @Query(value = "select * from insects where SH_JAN <> 'NA'", nativeQuery = true)
    List<Insect> insectsAvailableInJanuarySH();

    @Query(value = "select * from insects where NH_FEB <> 'NA'", nativeQuery = true)
    List<Insect> insectsAvailableInFebruaryNH();

    @Query(value = "select * from insects where SH_FEB <> 'NA'", nativeQuery = true)
    List<Insect> insectsAvailableInFebruarySH();

    @Query(value = "select * from insects where NH_MAR <> 'NA'", nativeQuery = true)
    List<Insect> insectsAvailableInMarchNH();

    @Query(value = "select * from insects where SH_MAR <> 'NA'", nativeQuery = true)
    List<Insect> insectsAvailableInMarchSH();

    @Query(value = "select * from insects where NH_APR <> 'NA'", nativeQuery = true)
    List<Insect> insectsAvailableInAprilNH();

    @Query(value = "select * from insects where SH_APR <> 'NA'", nativeQuery = true)
    List<Insect> insectsAvailableInAprilSH();

    @Query(value = "select * from insects where NH_MAY <> 'NA'", nativeQuery = true)
    List<Insect> insectsAvailableInMayNH();

    @Query(value = "select * from insects where SH_MAY <> 'NA'", nativeQuery = true)
    List<Insect> insectsAvailableInMaySH();

    @Query(value = "select * from insects where NH_JUN <> 'NA'", nativeQuery = true)
    List<Insect> insectsAvailableInJuneNH();

    @Query(value = "select * from insects where SH_JUN <> 'NA'", nativeQuery = true)
    List<Insect> insectsAvailableInJuneSH();

    @Query(value = "select * from insects where NH_JUL <> 'NA'", nativeQuery = true)
    List<Insect> insectsAvailableInJulyNH();

    @Query(value = "select * from insects where SH_JUL <> 'NA'", nativeQuery = true)
    List<Insect> insectsAvailableInJulySH();

    @Query(value = "select * from insects where NH_AUG <> 'NA'", nativeQuery = true)
    List<Insect> insectsAvailableInAugustNH();

    @Query(value = "select * from insects where SH_AUG <> 'NA'", nativeQuery = true)
    List<Insect> insectsAvailableInAugustSH();

    @Query(value = "select * from insects where NH_SEP <> 'NA'", nativeQuery = true)
    List<Insect> insectsAvailableInSeptemberNH();

    @Query(value = "select * from insects where SH_SEP <> 'NA'", nativeQuery = true)
    List<Insect> insectsAvailableInSeptemberSH();

    @Query(value = "select * from insects where NH_OCT <> 'NA'", nativeQuery = true)
    List<Insect> insectsAvailabeInOctoberNH();

    @Query(value = "select* from insects where SH_OCT <> 'NA'", nativeQuery = true)
    List<Insect> insectsAvailableInOctoberSH();

    @Query(value = "select * from insects where NH_NOV <> 'NA'", nativeQuery = true)
    List<Insect> insectsAvailableInNovemberNH();

    @Query(value = "select * from insects where SH_NOV <> 'NA'", nativeQuery = true)
    List<Insect> insectsAvailableInNovemberSH();

    @Query(value = "select * from insects where NH_DEC <> 'NA'", nativeQuery = true)
    List<Insect> insectsAvailableInDecemberNH();

    @Query(value = "select * from insects where SH_DEC <> 'NA'", nativeQuery = true)
    List<Insect> insectsAvailableInDecemberSH();

    @Query(value = "select * from insects where NH_JAN <> 'NA' AND NH_FEB = 'NA'", nativeQuery = true)
    List<Insect> insectsLeavingAfterJanuaryNH();

    @Query(value = "select * from insects where SH_JAN <> 'NA' AND SH_FEB = 'NA'", nativeQuery = true)
    List<Insect> insectsLeavingAfterJanuarySH();

    @Query(value = "select * from insects where NH_FEB <> 'NA' AND NH_MAR = 'NA'", nativeQuery = true)
    List<Insect> insectsLeavingAfterFebruaryNH();

    @Query(value = "select * from insects where SH_FEB <> 'NA' AND SH_MAR = 'NA'", nativeQuery = true)
    List<Insect> insectsLeavingAfterFebruarySH();

    @Query(value = "select * from insects where NH_MAR <> 'NA' AND NH_APR = 'NA'", nativeQuery = true)
    List<Insect> insectsLeavingAfterMarchNH();

    @Query(value = "select * from insects where SH_MAR <> 'NA' AND SH_APR = 'NA'", nativeQuery = true)
    List<Insect> insectsLeavingAfterMarchSH();

    @Query(value = "select * from insects where NH_APR <> 'NA' AND NH_MAY = 'NA'", nativeQuery = true)
    List<Insect> insectsLeavingAfterAprilNH();

    @Query(value = "select * from insects where SH_APR <> 'NA' AND SH_MAY = 'NA'", nativeQuery = true)
    List<Insect> insectsLeavingAfterAprilSH();

    @Query(value = "select * from insects where NH_MAY <> 'NA' AND NH_JUN = 'NA'", nativeQuery = true)
    List<Insect> insectsLeavingAfterMayNH();

    @Query(value = "select * from insects where SH_MAY <> 'NA' AND SH_JUN = 'NA'", nativeQuery = true)
    List<Insect> insectsLeavingAfterMaySH();

    @Query(value = "select * from insects where NH_JUN <> 'NA' AND NH_JUL = 'NA'", nativeQuery = true)
    List<Insect> insectsLeavingAfterJuneNH();

    @Query(value = "select * from insects where SH_JUN <> 'NA' AND SH_JUL = 'NA'", nativeQuery = true)
    List<Insect> insectsLeavingAfterJuneSH();

    @Query(value = "select * from insects where NH_JUL <> 'NA' AND NH_AUG = 'NA'", nativeQuery = true)
    List<Insect> insectsLeavingAfterJulyNH();

    @Query(value = "select * from insects where SH_JUL <> 'NA' AND SH_AUG = 'NA'", nativeQuery = true)
    List<Insect> insectsLeavingAfterJulySH();

    @Query(value = "select * from insects where NH_AUG <> 'NA' AND NH_SEP = 'NA'", nativeQuery = true)
    List<Insect> insectsLeavingAfterAugustNH();

    @Query(value = "select * from insects where SH_AUG <> 'NA' AND SH_SEP = 'NA'", nativeQuery = true)
    List<Insect> insectsLeavingAfterAugustSH();

    @Query(value = "select * from insects where NH_SEP <> 'NA' AND NH_OCT = 'NA'", nativeQuery = true)
    List<Insect> insectsLeavingAfterSeptemberNH();

    @Query(value = "select * from insects where SH_SEP <> 'NA' AND SH_OCT = 'NA'", nativeQuery = true)
    List<Insect> insectsLeavingAfterSeptemberSH();

    @Query(value = "select * from insects where NH_OCT <> 'NA' AND NH_NOV = 'NA'", nativeQuery = true)
    List<Insect> insectsLeavingAfterOctoberNH();

    @Query(value = "select * from insects where SH_OCT <> 'NA' AND SH_NOV = 'NA'", nativeQuery = true)
    List<Insect> insectsLeavingAfterOctoberSH();

    @Query(value = "select * from insects where NH_NOV <> 'NA' AND NH_DEC = 'NA'", nativeQuery = true)
    List<Insect> insectsLeavingAfterNovemberNH();

    @Query(value = "select * from insects where SH_NOV <> 'NA' AND SH_DEC = 'NA'", nativeQuery = true)
    List<Insect> insectsLeavingAfterNovemberSH();

    @Query(value = "select * from insects where NH_DEC <> 'NA' AND NH_JAN = 'NA'", nativeQuery = true)
    List<Insect> insectsLeavingAfterDecemberNH();

    @Query(value = "select * from insects where SH_DEC <> 'NA' AND SH_JAN = 'NA'", nativeQuery = true)
    List<Insect> insectsLeavingAfterDecemberSH();

    @Query(value = "select * from insects", nativeQuery = true)
    List<Insect> getAllInsects();
}
