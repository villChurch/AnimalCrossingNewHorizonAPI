package com.williamspires.acnhapi.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reactions")
public class Reactions {

    @Id
    @Column(name="Unique_Entry_ID")
    private String uniqueEntryID;
    @Column(name="me")
    private String name;
    @Column(name="Source")
    private String source;
    @Column(name="Source_Notes")
    private String sourceNotes;

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
}
