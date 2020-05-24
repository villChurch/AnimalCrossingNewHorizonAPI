package com.williamspires.acnhapi.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="construction")
public class Construction {
    @Id
    @Column(name = "Unique_Entry_ID")
    private String uniqueEntryID;
    @Column(name = "me")
    private String name;
    private int buy;
    private String category;
    private String source;
    private String filename;
    private String version;

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

    public int getBuy() {
        return buy;
    }

    public void setBuy(int buy) {
        this.buy = buy;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
