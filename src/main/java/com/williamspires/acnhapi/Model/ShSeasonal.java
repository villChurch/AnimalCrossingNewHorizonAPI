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
@Table(name="shseasons")
public class ShSeasonal {
    @Id
    @Column(name="id")
    private int id;
    @Column(name="From")
    private String fromDate;
    @Column(name="To")
    private String toDate;
    @Column(name="Days")
    private int numberOfDays;
    @Column(name="Season")
    private String season;
    @Column(name="Shops")
    private String shops;
    @Column(name="Vegetation")
    private String vegetation;
    @Column(name="Blossoms")
    private String blossoms;
    @Column(name="Fog")
    private String fog;
}
