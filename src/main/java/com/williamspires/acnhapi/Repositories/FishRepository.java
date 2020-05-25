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

    @Query(value = "select * from fish where NH_JAN <> 'NA'", nativeQuery = true)
    List<Fish> fishAvailableInJanuaryNH();

    @Query(value = "select * from fish where SH_JAN <> 'NA'", nativeQuery = true)
    List<Fish> fishAvailableInJanuarySH();

    @Query(value = "select * from fish where NH_FEB <> 'NA'", nativeQuery = true)
    List<Fish> fishAvailableInFebruaryNH();

    @Query(value = "select * from fish where SH_FEB <> 'NA'", nativeQuery = true)
    List<Fish> fishAvailableInFebruarySH();

    @Query(value = "select * from fish where NH_MAR <> 'NA'", nativeQuery = true)
    List<Fish> fishAvailableInMarchNH();

    @Query(value = "select * from fish where SH_MAR <> 'NA'", nativeQuery = true)
    List<Fish> fishAvailableInMarchSH();

    @Query(value = "select * from fish where NH_APR <> 'NA'", nativeQuery = true)
    List<Fish> fishAvailableInAprilNH();

    @Query(value = "select * from fish where SH_APR <> 'NA'", nativeQuery = true)
    List<Fish> fishAvailableInAprilSH();

    @Query(value = "select * from fish where NH_MAY <> 'NA'", nativeQuery = true)
    List<Fish> fishAvailableInMayNH();

    @Query(value = "select * from fish where SH_MAY <> 'NA'", nativeQuery = true)
    List<Fish> fishAvailableInMaySH();

    @Query(value = "select * from fish where NH_JUN <> 'NA'", nativeQuery = true)
    List<Fish> fishAvailableInJuneNH();

    @Query(value = "select * from fish where SH_JUN <> 'NA'", nativeQuery = true)
    List<Fish> fishAvailableInJuneSH();

    @Query(value = "select * from fish where NH_JUL <> 'NA'", nativeQuery = true)
    List<Fish> fishAvailableInJulyNH();

    @Query(value = "select * from fish where SH_JUL <> 'NA'", nativeQuery = true)
    List<Fish> fishAvailableInJulySH();

    @Query(value = "select * from fish where NH_AUG <> 'NA'", nativeQuery = true)
    List<Fish> fishAvailableInAugustNH();

    @Query(value = "select * from fish where SH_AUG <> 'NA'", nativeQuery = true)
    List<Fish> fishAvailableInAugustSH();

    @Query(value = "select * from fish where NH_SEP <> 'NA'", nativeQuery = true)
    List<Fish> fishAvailableInSeptemberNH();

    @Query(value = "select * from fish where SH_SEP <> 'NA'", nativeQuery = true)
    List<Fish> fishAvailableInSeptemberSH();

    @Query(value = "select * from fish where NH_OCT <> 'NA'", nativeQuery = true)
    List<Fish> fishAvailabeInOctoberNH();

    @Query(value = "select* from fish where SH_OCT <> 'NA'", nativeQuery = true)
    List<Fish> fishAvailableInOctoberSH();

    @Query(value = "select * from fish where NH_NOV <> 'NA'", nativeQuery = true)
    List<Fish> fishAvailableInNovemberNH();

    @Query(value = "select * from fish where SH_NOV <> 'NA'", nativeQuery = true)
    List<Fish> fishAvailableInNovemberSH();

    @Query(value = "select * from fish where NH_DEC <> 'NA'", nativeQuery = true)
    List<Fish> fishAvailableInDecemberNH();

    @Query(value = "select * from fish where SH_DEC <> 'NA'", nativeQuery = true)
    List<Fish> fishAvailableInDecemberSH();

    @Query(value = "select * from fish where NH_JAN <> 'NA' AND NH_FEB = 'NA'", nativeQuery = true)
    List<Fish> fishLeavingAfterJanuaryNH();

    @Query(value = "select * from fish where SH_JAN <> 'NA' AND SH_FEB = 'NA'", nativeQuery = true)
    List<Fish> fishLeavingAfterJanuarySH();

    @Query(value = "select * from fish where NH_FEB <> 'NA' AND NH_MAR = 'NA'", nativeQuery = true)
    List<Fish> fishLeavingAfterFebruaryNH();

    @Query(value = "select * from fish where SH_FEB <> 'NA' AND SH_MAR = 'NA'", nativeQuery = true)
    List<Fish> fishLeavingAfterFebruarySH();

    @Query(value = "select * from fish where NH_MAR <> 'NA' AND NH_APR = 'NA'", nativeQuery = true)
    List<Fish> fishLeavingAfterMarchNH();

    @Query(value = "select * from fish where SH_MAR <> 'NA' AND SH_APR = 'NA'", nativeQuery = true)
    List<Fish> fishLeavingAfterMarchSH();

    @Query(value = "select * from fish where NH_APR <> 'NA' AND NH_MAY = 'NA'", nativeQuery = true)
    List<Fish> fishLeavingAfterAprilNH();

    @Query(value = "select * from fish where SH_APR <> 'NA' AND SH_MAY = 'NA'", nativeQuery = true)
    List<Fish> fishLeavingAfterAprilSH();

    @Query(value = "select * from fish where NH_MAY <> 'NA' AND NH_JUN = 'NA'", nativeQuery = true)
    List<Fish> fishLeavingAfterMayNH();

    @Query(value = "select * from fish where SH_MAY <> 'NA' AND SH_JUN = 'NA'", nativeQuery = true)
    List<Fish> fishLeavingAfterMaySH();

    @Query(value = "select * from fish where NH_JUN <> 'NA' AND NH_JUL = 'NA'", nativeQuery = true)
    List<Fish> fishLeavingAfterJuneNH();

    @Query(value = "select * from fish where SH_JUN <> 'NA' AND SH_JUL = 'NA'", nativeQuery = true)
    List<Fish> fishLeavingAfterJuneSH();

    @Query(value = "select * from fish where NH_JUL <> 'NA' AND NH_AUG = 'NA'", nativeQuery = true)
    List<Fish> fishLeavingAfterJulyNH();

    @Query(value = "select * from fish where SH_JUL <> 'NA' AND SH_AUG = 'NA'", nativeQuery = true)
    List<Fish> fishLeavingAfterJulySH();

    @Query(value = "select * from fish where NH_AUG <> 'NA' AND NH_SEP = 'NA'", nativeQuery = true)
    List<Fish> fishLeavingAfterAugustNH();

    @Query(value = "select * from fish where SH_AUG <> 'NA' AND SH_SEP = 'NA'", nativeQuery = true)
    List<Fish> fishLeavingAfterAugustSH();

    @Query(value = "select * from fish where NH_SEP <> 'NA' AND NH_OCT = 'NA'", nativeQuery = true)
    List<Fish> fishLeavingAfterSeptemberNH();

    @Query(value = "select * from fish where SH_SEP <> 'NA' AND SH_OCT = 'NA'", nativeQuery = true)
    List<Fish> fishLeavingAfterSeptemberSH();

    @Query(value = "select * from fish where NH_OCT <> 'NA' AND NH_NOV = 'NA'", nativeQuery = true)
    List<Fish> fishLeavingAfterOctoberNH();

    @Query(value = "select * from fish where SH_OCT <> 'NA' AND SH_NOV = 'NA'", nativeQuery = true)
    List<Fish> fishLeavingAfterOctoberSH();

    @Query(value = "select * from fish where NH_NOV <> 'NA' AND NH_DEC = 'NA'", nativeQuery = true)
    List<Fish> fishLeavingAfterNovemberNH();

    @Query(value = "select * from fish where SH_NOV <> 'NA' AND SH_DEC = 'NA'", nativeQuery = true)
    List<Fish> fishLeavingAfterNovemberSH();

    @Query(value = "select * from fish where NH_DEC <> 'NA' AND NH_JAN = 'NA'", nativeQuery = true)
    List<Fish> fishLeavingAfterDecemberNH();

    @Query(value = "select * from fish where SH_DEC <> 'NA' AND SH_JAN = 'NA'", nativeQuery = true)
    List<Fish> fishLeavingAfterDecemberSH();

    @Query(value = "select * from fish where NH_DEC = 'NA' AND NH_JAN <> 'NA'", nativeQuery = true)
    List<Fish> fishArrivingInJanuaryNH();

    @Query(value = "select * from fish where SH_DEC = 'NA' AND SH_JAN <> 'NA'", nativeQuery = true)
    List<Fish> fishArrivingInJanuarySH();

    @Query(value = "select * from fish where NH_JAN = 'NA' AND NH_FEB <> 'NA'", nativeQuery = true)
    List<Fish> fishArrivingInFebruaryNH();

    @Query(value = "select * from fish where SH_JAN = 'NA' AND SH_FEB <> 'NA'", nativeQuery = true)
    List<Fish> fishArrivingInFebruarySH();

    @Query(value = "select * from fish where NH_FEB = 'NA' AND NH_MAR <> 'NA'", nativeQuery = true)
    List<Fish> fishArrivingInMarchNH();

    @Query(value = "select * from fish where SH_FEB = 'NA' AND SH_MAR <> 'NA'", nativeQuery = true)
    List<Fish> fishArrivingInMarchSH();

    @Query(value = "select * from fish where NH_MAR = 'NA' AND NH_APR <> 'NA'", nativeQuery = true)
    List<Fish> fishArrivingInAprilNH();

    @Query(value = "select * from fish where SH_MAR = 'NA' AND SH_APR <> 'NA'", nativeQuery = true)
    List<Fish> fishArrivingInAprilSH();

    @Query(value = "select * from fish where NH_APR = 'NA' AND NH_MAY <> 'NA'", nativeQuery = true)
    List<Fish> fishArrivingInMayNH();

    @Query(value = "select * from fish where SH_APR = 'NA' AND SH_MAY <> 'NA'", nativeQuery = true)
    List<Fish> fishArrivingInMaySH();

    @Query(value = "select * from fish where NH_MAY = 'NA' AND NH_JUN <> 'NA'", nativeQuery = true)
    List<Fish> fishArrivingInJuneNH();

    @Query(value = "select * from fish where SH_MAY = 'NA' AND SH_JUN <> 'NA'", nativeQuery = true)
    List<Fish> fishArrivingInJuneSH();

    @Query(value = "select * from fish where NH_JUN = 'NA' AND NH_JUL <> 'NA'", nativeQuery = true)
    List<Fish> fishArrivingInJulyNH();

    @Query(value = "select * from fish where SH_JUN = 'NA' AND SH_JUL <> 'NA'", nativeQuery = true)
    List<Fish> fishArrivingInJulySH();

    @Query(value = "select * from fish where NH_JUL = 'NA' AND NH_AUG <> 'NA'", nativeQuery = true)
    List<Fish> fishArrivingInAugustNH();

    @Query(value = "select * from fish where SH_JUL = 'NA' AND SH_AUG <> 'NA'", nativeQuery = true)
    List<Fish> fishArrivingInAugustSH();

    @Query(value = "select * from fish where NH_AUG = 'NA' AND NH_SEP <> 'NA'", nativeQuery = true)
    List<Fish> fishArrivingInSeptemberNH();

    @Query(value = "select * from fish where SH_AUG = 'NA' AND SH_SEP <> 'NA'", nativeQuery = true)
    List<Fish> fishArrivingInSeptemberSH();

    @Query(value = "select * from fish where NH_SEP = 'NA' AND NH_OCT <> 'NA'", nativeQuery = true)
    List<Fish> fishArrivingInOctoberNH();

    @Query(value = "select * from fish where SH_SEP = 'NA' AND SH_OCT <> 'NA'", nativeQuery = true)
    List<Fish> fishArrivingInOctoberSH();

    @Query(value = "select * from fish where NH_OCT = 'NA' AND NH_NOV <> 'NA'", nativeQuery = true)
    List<Fish> fishArrivingInNovemberNH();

    @Query(value = "select * from fish where SH_OCT = 'NA' AND SH_NOV <> 'NA'", nativeQuery = true)
    List<Fish> fishArrivingInNovemberSH();

    @Query(value = "select * from fish where NH_NOV = 'NA' AND NH_DEC <> 'NA'", nativeQuery = true)
    List<Fish> fishArrivingInDecemberNH();

    @Query(value = "select * from fish where SH_NOV = 'NA' AND SH_DEC <> 'NA'", nativeQuery = true)
    List<Fish> fishArrivingInDecemberSH();

    @Query(value = "select * from fish", nativeQuery = true)
    List<Fish> getAllFish();
}
