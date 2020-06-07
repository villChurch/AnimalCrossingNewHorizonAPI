package com.williamspires.acnhapi.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="acnhevents")
public class acnhevents {
    @Id
    @Column(name="id")
    private int id;
    @Column(name="Event")
    private String event;
    @Column(name="Northern_Hemisphere_Dates")
    private String nothernHemisphereDates;
    @Column(name="Southern_Hemisphere_Dates")
    private String southernHemisphereDates;
    @Column(name="Times")
    private String times;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getNothernHemisphereDates() {
        return nothernHemisphereDates;
    }

    public void setNothernHemisphereDates(String nothernHemisphereDates) {
        this.nothernHemisphereDates = nothernHemisphereDates;
    }

    public String getSouthernHemisphereDates() {
        return southernHemisphereDates;
    }

    public void setSouthernHemisphereDates(String southernHemisphereDates) {
        this.southernHemisphereDates = southernHemisphereDates;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }
}
