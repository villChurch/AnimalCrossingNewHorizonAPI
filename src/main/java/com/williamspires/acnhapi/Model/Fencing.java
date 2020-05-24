package com.williamspires.acnhapi.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fencing")
public class Fencing {
    @Id
    @Column(name = "Unique_Entry_ID")
    private String uniqueEntryId;
    @Column(name="me")
    private String name;
    @Column(name = "DIY")
    private String DIY;
    @Column(name = "Stack_Size")
    private int stackSize;
    @Column(name = "Buy")
    private String buy;
    @Column(name = "Sell")
    private int sell;
    @Column(name = "Source")
    private String source;
    @Column(name = "Source_Notes")
    private String sourceNotes;
    @Column(name = "Version")
    private String version;
    @Column(name = "Filename")
    private String filename;
    @Column (name = "Internal_ID")
    private String internalId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDIY() {
        return DIY;
    }

    public void setDIY(String DIY) {
        this.DIY = DIY;
    }

    public int getStackSize() {
        return stackSize;
    }

    public void setStackSize(int stackSize) {
        this.stackSize = stackSize;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getInternalId() {
        return internalId;
    }

    public void setInternalId(String internalId) {
        this.internalId = internalId;
    }

    public String getUniqueEntryId() {
        return uniqueEntryId;
    }

    public void setUniqueEntryId(String uniqueEntryId) {
        this.uniqueEntryId = uniqueEntryId;
    }
}
