package com.williamspires.acnhapi.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "insects")
public class Insect {

    @Id
    @Column(name="Unique_Entry_ID")
    private String uniqueEntryID;
    @Column(name="Name")
    private String name;
    private int Sell;
    @Column(name="whereorhow")
    private String whereorhow;
    private String Weather;
    @Column(name="Total_Catches_to_Unlock")
    private int unlockCatches;
    @Column(name="Spawn_Rates")
    private String spawnRate;
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
    @Column(name="Color_1")
    private String color1;
    @Column(name="Color_2")
    private String color2;
    @Column(name="Icon_Filename")
    private String iconFilename;
    @Column(name="Critterpedia_Filename")
    private String critterpediaFilename;
    @Column(name="Furniture_Filename")
    private String furnitureFilename;
    @Column(name="Internal_ID")
    private int internalID;

    public String getUniqueEntryID() {
        return uniqueEntryID;
    }

    public void setUniqueEntryID(String uniqueEntryID) {
        this.uniqueEntryID = uniqueEntryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSell() {
        return Sell;
    }

    public void setSell(int sell) {
        Sell = sell;
    }

    public String getWhereOrHow() {
        return whereorhow;
    }

    public void setWhereOrHow(String whereOrHow) {
        whereorhow = whereOrHow;
    }

    public String getWeather() {
        return Weather;
    }

    public void setWeather(String weather) {
        Weather = weather;
    }

    public int getUnlockCatches() {
        return unlockCatches;
    }

    public void setUnlockCatches(int unlockCatches) {
        this.unlockCatches = unlockCatches;
    }

    public String getSpawnRate() {
        return spawnRate;
    }

    public void setSpawnRate(String spawnRate) {
        this.spawnRate = spawnRate;
    }

    public String getNhJan() {
        return nhJan;
    }

    public void setNhJan(String nhJan) {
        this.nhJan = nhJan;
    }

    public String getNhFeb() {
        return nhFeb;
    }

    public void setNhFeb(String nhFeb) {
        this.nhFeb = nhFeb;
    }

    public String getNhMar() {
        return nhMar;
    }

    public void setNhMar(String nhMar) {
        this.nhMar = nhMar;
    }

    public String getNhApr() {
        return nhApr;
    }

    public void setNhApr(String nhApr) {
        this.nhApr = nhApr;
    }

    public String getNhMay() {
        return nhMay;
    }

    public void setNhMay(String nhMay) {
        this.nhMay = nhMay;
    }

    public String getNhJun() {
        return nhJun;
    }

    public void setNhJun(String nhJun) {
        this.nhJun = nhJun;
    }

    public String getNhJul() {
        return nhJul;
    }

    public void setNhJul(String nhJul) {
        this.nhJul = nhJul;
    }

    public String getNhAug() {
        return nhAug;
    }

    public void setNhAug(String nhAug) {
        this.nhAug = nhAug;
    }

    public String getNhSep() {
        return nhSep;
    }

    public void setNhSep(String nhSep) {
        this.nhSep = nhSep;
    }

    public String getNhOct() {
        return nhOct;
    }

    public void setNhOct(String nhOct) {
        this.nhOct = nhOct;
    }

    public String getNhNov() {
        return nhNov;
    }

    public void setNhNov(String nhNov) {
        this.nhNov = nhNov;
    }

    public String getNhDec() {
        return nhDec;
    }

    public void setNhDec(String nhDec) {
        this.nhDec = nhDec;
    }

    public String getShJan() {
        return shJan;
    }

    public void setShJan(String shJan) {
        this.shJan = shJan;
    }

    public String getShFeb() {
        return shFeb;
    }

    public void setShFeb(String shFeb) {
        this.shFeb = shFeb;
    }

    public String getShMar() {
        return shMar;
    }

    public void setShMar(String shMar) {
        this.shMar = shMar;
    }

    public String getShApr() {
        return shApr;
    }

    public void setShApr(String shApr) {
        this.shApr = shApr;
    }

    public String getShMay() {
        return shMay;
    }

    public void setShMay(String shMay) {
        this.shMay = shMay;
    }

    public String getShJun() {
        return shJun;
    }

    public void setShJun(String shJun) {
        this.shJun = shJun;
    }

    public String getShJul() {
        return shJul;
    }

    public void setShJul(String shJul) {
        this.shJul = shJul;
    }

    public String getShAug() {
        return shAug;
    }

    public void setShAug(String shAug) {
        this.shAug = shAug;
    }

    public String getShSep() {
        return shSep;
    }

    public void setShSep(String shSep) {
        this.shSep = shSep;
    }

    public String getShOct() {
        return shOct;
    }

    public void setShOct(String shOct) {
        this.shOct = shOct;
    }

    public String getShNov() {
        return shNov;
    }

    public void setShNov(String shNov) {
        this.shNov = shNov;
    }

    public String getShDec() {
        return shDec;
    }

    public void setShDec(String shDec) {
        this.shDec = shDec;
    }

    public String getColor1() {
        return color1;
    }

    public void setColor1(String color1) {
        this.color1 = color1;
    }

    public String getColor2() {
        return color2;
    }

    public void setColor2(String color2) {
        this.color2 = color2;
    }

    public String getIconFilename() {
        return iconFilename;
    }

    public void setIconFilename(String iconFilename) {
        this.iconFilename = iconFilename;
    }

    public String getCritterpediaFilename() {
        return critterpediaFilename;
    }

    public void setCritterpediaFilename(String critterpediaFilename) {
        this.critterpediaFilename = critterpediaFilename;
    }

    public String getFurnitureFilename() {
        return furnitureFilename;
    }

    public void setFurnitureFilename(String furnitureFilename) {
        this.furnitureFilename = furnitureFilename;
    }

    public int getInternalID() {
        return internalID;
    }

    public void setInternalID(int internalID) {
        this.internalID = internalID;
    }
}
