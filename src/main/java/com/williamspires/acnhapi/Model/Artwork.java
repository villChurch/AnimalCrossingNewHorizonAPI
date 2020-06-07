package com.williamspires.acnhapi.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="artwork")
public class Artwork {
    @Id
    @Column(name="Unique_Entry_ID")
    private String uniqueEntryID;
    @Column(name="Name")
    private String name;
    @Column(name="Genuine")
    private boolean real;
    @Column(name="Category")
    private String category;
    @Column(name="Buy")
    private int buy;
    @Column(name="Sell")
    private int sell;
    @Column(name="Color_1")
    private String color1;
    @Column(name="Color_2")
    private String color2;
    @Column(name="Size")
    private String size;
    @Column(name="Real_Artwork_Title")
    private String realArtworkTitle;
    @Column(name="Artist")
    private String artist;
    @Column(name="Museum_Description")
    private String museumDescription;
    @Column(name="Source")
    private String source;
    @Column(name="Source_Notes")
    private String sourceNotes;
    @Column(name="Version_Added")
    private String versionAdded;
    @Column(name="Version_Unlocked")
    private String versionUnlocked;
    @Column(name="HHA_Concept_1")
    private String hhaConcept1;
    @Column(name="HHA_Concept_2")
    private String hhaConcept2;
    @Column(name="HHA_Series")
    private String hhaSeries;
    @Column(name="HHA_Set")
    private String hhaSet;
    @Column(name="Interact")
    private String interact;
    @Column(name="Tag")
    private String tag;
    @Column(name="Speaker_Type")
    private String speakerType;
    @Column(name="Lighting_Type")
    private String lightingType;
    @Column(name="Catalog")
    private String catalog;
    @Column(name="Filename")
    private String filename;
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

    public boolean isReal() {
        return real;
    }

    public void setReal(boolean real) {
        this.real = real;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getBuy() {
        return buy;
    }

    public void setBuy(int buy) {
        this.buy = buy;
    }

    public int getSell() {
        return sell;
    }

    public void setSell(int sell) {
        this.sell = sell;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getRealArtworkTitle() {
        return realArtworkTitle;
    }

    public void setRealArtworkTitle(String realArtworkTitle) {
        this.realArtworkTitle = realArtworkTitle;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getMuseumDescription() {
        return museumDescription;
    }

    public void setMuseumDescription(String museumDescription) {
        this.museumDescription = museumDescription;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourceNotes() {
        return sourceNotes;
    }

    public void setSourceNotes(String sourceNotes) {
        this.sourceNotes = sourceNotes;
    }

    public String getVersionAdded() {
        return versionAdded;
    }

    public void setVersionAdded(String versionAdded) {
        this.versionAdded = versionAdded;
    }

    public String getVersionUnlocked() {
        return versionUnlocked;
    }

    public void setVersionUnlocked(String versionUnlocked) {
        this.versionUnlocked = versionUnlocked;
    }

    public String getHhaConcept1() {
        return hhaConcept1;
    }

    public void setHhaConcept1(String hhaConcept1) {
        this.hhaConcept1 = hhaConcept1;
    }

    public String getHhaConcept2() {
        return hhaConcept2;
    }

    public void setHhaConcept2(String hhaConcept2) {
        this.hhaConcept2 = hhaConcept2;
    }

    public String getHhaSeries() {
        return hhaSeries;
    }

    public void setHhaSeries(String hhaSeries) {
        this.hhaSeries = hhaSeries;
    }

    public String getHhaSet() {
        return hhaSet;
    }

    public void setHhaSet(String hhaSet) {
        this.hhaSet = hhaSet;
    }

    public String getInteract() {
        return interact;
    }

    public void setInteract(String interact) {
        this.interact = interact;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getSpeakerType() {
        return speakerType;
    }

    public void setSpeakerType(String speakerType) {
        this.speakerType = speakerType;
    }

    public String getLightingType() {
        return lightingType;
    }

    public void setLightingType(String lightingType) {
        this.lightingType = lightingType;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getInternalID() {
        return internalID;
    }

    public void setInternalID(int internalID) {
        this.internalID = internalID;
    }
}
