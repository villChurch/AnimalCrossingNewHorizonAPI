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

    @Query(value = "select * from insects", nativeQuery = true)
    List<Insect> getAllInsects();
}
