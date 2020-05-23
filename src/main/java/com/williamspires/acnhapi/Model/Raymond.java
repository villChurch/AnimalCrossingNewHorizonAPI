package com.williamspires.acnhapi.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="raymond")
public class Raymond {

    @Id
    private int id;
    private String item;
    private String color_1;
    private String color_2;
    private String emotion;
    private String category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getColor_1() {
        return color_1;
    }

    public void setColor_1(String colour_1) {
        this.color_1 = colour_1;
    }

    public String getColor_2() {
        return color_2;
    }

    public void setColor_2(String colour_2) {
        this.color_2 = colour_2;
    }

    public String getEmotion() {
        return emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
