package com.williamspires.acnhapi.Model;

import javax.persistence.*;

@Entity
@Table(name="red")
public class RedItem {
    @Id
    private int ID;
    @Column(name="Name")
    private String name;
    private String Fake;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFake() {
        return Fake;
    }

    public void setFake(String fake) {
        Fake = fake;
    }
}
