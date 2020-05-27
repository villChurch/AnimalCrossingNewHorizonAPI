package com.williamspires.acnhapi.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fossils")
public class Fossil {
    @Id
    @Column(name="Unique_Entry_ID")
    private String UniqueEntryID;
    @Column(name="me")
    private String name;
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
    @Column(name="Museum")
    private String museum;
    @Column(name="Version")
    private String version;
    @Column(name="Interact")
    private String interact;
    @Column(name="Catalog")
    private String catalog;
    @Column(name="Filename")
    private String filename;
    @Column(name="Internal_ID")
    private int internalID;

    public String getUniqueEntryID() {
        return UniqueEntryID;
    }

    public void setUniqueEntryID(String uniqueEntryID) {
        this.UniqueEntryID = uniqueEntryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getMuseum() {
        return museum;
    }

    public void setMuseum(String museum) {
        this.museum = museum;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getInteract() {
        return interact;
    }

    public void setInteract(String interact) {
        this.interact = interact;
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
