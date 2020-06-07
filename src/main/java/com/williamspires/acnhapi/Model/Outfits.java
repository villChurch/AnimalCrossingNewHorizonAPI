package com.williamspires.acnhapi.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dress_up")
@Getter
@Setter
public class Outfits {
    @Id
    @Column(name="Unique_Entry_ID")
    private String uniqueEntryID;
    @Column(name="me")
    private String name;
    @Column(name="Variation")
    private String variation;
    @Column(name="DIY")
    private String diy;
    @Column(name="Buy")
    private String buy;
    @Column(name="Sell")
    private int sell;
    @Column(name="Color_1")
    private String color1;
    @Column(name="Color_2")
    private String color2;
    @Column(name="Size")
    private String size;
    @Column(name="Source")
    private String source;
    @Column(name="Source_Notes")
    private String sourceNotes;
    @Column(name="Seasonal_Availability")
    private String seasonalAvailability;
    @Column(name="Mannequin_Piece")
    private String mannequinPiece;
    @Column(name="Version")
    private String version;
    @Column(name="Style")
    private String style;
    @Column(name="Label_Themes")
    private String labelThemes;
    @Column(name="Villager_Equippable")
    private String villagerEquippable;
    @Column(name="Catalog")
    private String catalog;
    @Column(name="Primary_Shape")
    private String primaryShape;
    @Column(name="Secondary_Shape")
    private String secondaryShape;
    @Column(name="Filename")
    private String filename;
    @Column(name="Internal_ID")
    private String internalID;


}
