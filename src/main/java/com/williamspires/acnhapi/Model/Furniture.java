package com.williamspires.acnhapi.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Furniture {

    @Id
    private int ID;
    private String name;
    private String buy_price;
    private String hha_themes;
    private String obtainable_from;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuy_price() {
        return buy_price;
    }

    public void setBuy_price(String buy_price) {
        this.buy_price = buy_price;
    }

    public String getHha_themes() {
        return hha_themes;
    }

    public void setHha_themes(String hha_themes) {
        this.hha_themes = hha_themes;
    }

    public String getObtainable_from() {
        return obtainable_from;
    }

    public void setObtainable_from(String obtainable_from) {
        this.obtainable_from = obtainable_from;
    }
}
