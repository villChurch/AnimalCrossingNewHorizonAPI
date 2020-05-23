package com.williamspires.acnhapi.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "villagers")
public class Villager {
    @Id
    private String Unique_Entry_ID;
    @Column(name="me")
    private String name;
    private String Species;
    private String Gender;
    private String personality;
    private String Hobby;
    private String Birthday;
    private String Catchphrase;
    private String Favorite_Song;
    private String Style_1;
    private String Style_2;
    private String Color_1;
    private String Color_2;
    private String Wallpaper;
    private String Flooring;
    private String Furniture_List;
    private String Filename;

    public Villager() {     }

    public Villager(String Name, String species, String gender, String personality, String hobby, String birthday, String catchphrase,
                    String favorite_Song, String style_1, String style_2, String color_1, String color_2, String wallpaper, String flooring,
                    String furniture_List, String filename, String unique_Entry_ID) {
        this.name = Name;
        this.Species = species;
        this.Gender = gender;
        this.personality =personality;
        this.Hobby = hobby;
        this.Birthday = birthday;
        this.Catchphrase = catchphrase;
        this.Favorite_Song = favorite_Song;
        this.Style_1 = style_1;
        this.Style_2 = style_2;
        this.Color_1 = color_1;
        this.Color_2 = color_2;
        this.Wallpaper = wallpaper;
        this.Flooring = flooring;
        this.Furniture_List = furniture_List;
        this.Filename = filename;
        this.Unique_Entry_ID = unique_Entry_ID;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnique_Entry_ID() {
        return Unique_Entry_ID;
    }

    public void setUnique_Entry_ID(String unique_Entry_ID) {
        Unique_Entry_ID = unique_Entry_ID;
    }

    public String getSpecies() {
        return Species;
    }

    public void setSpecies(String species) {
        Species = species;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public String getHobby() {
        return Hobby;
    }

    public void setHobby(String hobby) {
        Hobby = hobby;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public String getCatchphrase() {
        return Catchphrase;
    }

    public void setCatchphrase(String catchphrase) {
        Catchphrase = catchphrase;
    }

    public String getFavorite_Song() {
        return Favorite_Song;
    }

    public void setFavorite_Song(String favorite_Song) {
        Favorite_Song = favorite_Song;
    }

    public String getStyle_1() {
        return Style_1;
    }

    public void setStyle_1(String style_1) {
        Style_1 = style_1;
    }

    public String getStyle_2() {
        return Style_2;
    }

    public void setStyle_2(String style_2) {
        Style_2 = style_2;
    }

    public String getColor_1() {
        return Color_1;
    }

    public void setColor_1(String color_1) {
        Color_1 = color_1;
    }

    public String getColor_2() {
        return Color_2;
    }

    public void setColor_2(String color_2) {
        Color_2 = color_2;
    }

    public String getWallpaper() {
        return Wallpaper;
    }

    public void setWallpaper(String wallpaper) {
        Wallpaper = wallpaper;
    }

    public String getFlooring() {
        return Flooring;
    }

    public void setFlooring(String flooring) {
        Flooring = flooring;
    }

    public String getFurniture_List() {
        return Furniture_List;
    }

    public void setFurniture_List(String furniture_List) {
        Furniture_List = furniture_List;
    }

    public String getFilename() {
        return Filename;
    }

    public void setFilename(String filename) {
        Filename = filename;
    }
}
