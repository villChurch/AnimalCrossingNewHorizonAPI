package com.williamspires.acnhapi.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name ="seacreatures")
public class SeaCreatures {
    @Id
    @Column(name="#")
    private String number;
    @Column(name="Name")
    private String name;
    private String Icon_Image;
    private String Critterpedia_Image;
    private String Furniture_Image;
    private String Size;
    private String Surface;
    private int Sell;
    private String Shadow;
    private int Total_Catches_To_Unlock;
    private String Spawn_Rates;
    @Column(name="NH_Jan")
    private String nhJan;
    @Column(name="NH_Feb")
    private String nhFeb;
    @Column(name="NH_Mar")
    private String nhMar;
    @Column(name="NH_Apr")
    private String nhApr;
    @Column(name="NH_May")
    private String nhMay;
    @Column(name="NH_Jun")
    private String nhJun;
    @Column(name="NH_Jul")
    private String nhJul;
    @Column(name="NH_Aug")
    private String nhAug;
    @Column(name="NH_Sep")
    private String nhSep;
    @Column(name="NH_Oct")
    private String nhOct;
    @Column(name="NH_Nov")
    private String nhNov;
    @Column(name="NH_Dec")
    private String nhDec;
    @Column(name="SH_Jan")
    private String shJan;
    @Column(name="SH_Feb")
    private String shFeb;
    @Column(name="SH_Mar")
    private String shMar;
    @Column(name="SH_Apr")
    private String shApr;
    @Column(name="SH_May")
    private String shMay;
    @Column(name="SH_Jun")
    private String shJun;
    @Column(name="SH_Jul")
    private String shJul;
    @Column(name="SH_Aug")
    private String shAug;
    @Column(name="SH_Sep")
    private String shSep;
    @Column(name="SH_Oct")
    private String shOct;
    @Column(name="SH_Nov")
    private String shNov;
    @Column(name="SH_Dec")
    private String shDec;
    private String HHA_Base_Points;
    private String Color_1;
    private String Color_2;
    private String Lighting_Type;
    private String Icon_Filename;
    private String Critterpedia_Filename;
    private String Furniture_Filename;
    private int Internal_ID;
    private String Unique_Entry_ID;
}
