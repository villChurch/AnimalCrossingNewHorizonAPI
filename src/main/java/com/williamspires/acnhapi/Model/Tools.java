package com.williamspires.acnhapi.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tools")
public class Tools {

    @Column(name="me")
    private String name;
    private String Variation;
    private String Body_Title;
    private String DIY;
    private String Customize;
    private String Kit_Cost;
    private String Uses;
    private int Stack_Size;
    private String Buy;
    private int Sell;
    private String Color_1;
    private String Color_2;
    private String Size;
    private String Set;
    private String Miles_Price;
    private String Source;
    private String Source_Notes;
    private String Version;
    private String Filename;
    private String Variant_ID;
    private String Internal_ID;
    @Id
    private String Unique_Entry_ID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVariation() {
        return Variation;
    }

    public void setVariation(String variation) {
        Variation = variation;
    }

    public String getBody_Title() {
        return Body_Title;
    }

    public void setBody_Title(String body_Title) {
        Body_Title = body_Title;
    }

    public String getDIY() {
        return DIY;
    }

    public void setDIY(String DIY) {
        this.DIY = DIY;
    }

    public String getCustomize() {
        return Customize;
    }

    public void setCustomize(String customize) {
        Customize = customize;
    }

    public String getKit_Cost() {
        return Kit_Cost;
    }

    public void setKit_Cost(String kit_Cost) {
        Kit_Cost = kit_Cost;
    }

    public String getUses() {
        return Uses;
    }

    public void setUses(String uses) {
        Uses = uses;
    }

    public int getStack_Size() {
        return Stack_Size;
    }

    public void setStack_Size(int stack_Size) {
        Stack_Size = stack_Size;
    }

    public String getBuy() {
        return Buy;
    }

    public void setBuy(String buy) {
        Buy = buy;
    }

    public int getSell() {
        return Sell;
    }

    public void setSell(int sell) {
        Sell = sell;
    }

    public String getColor_1() {
        return Color_1;
    }

    public void setColor_1(String color_1) {
        Color_1 = color_1;
    }

    public String getColor_2() {
        return Color_2;
    }

    public void setColor_2(String color_2) {
        Color_2 = color_2;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }

    public String getSet() {
        return Set;
    }

    public void setSet(String set) {
        Set = set;
    }

    public String getMiles_Price() {
        return Miles_Price;
    }

    public void setMiles_Price(String miles_Price) {
        Miles_Price = miles_Price;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getSource_Notes() {
        return Source_Notes;
    }

    public void setSource_Notes(String source_Notes) {
        Source_Notes = source_Notes;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public String getFilename() {
        return Filename;
    }

    public void setFilename(String filename) {
        Filename = filename;
    }

    public String getVariant_ID() {
        return Variant_ID;
    }

    public void setVariant_ID(String variant_ID) {
        Variant_ID = variant_ID;
    }

    public String getInternal_ID() {
        return Internal_ID;
    }

    public void setInternal_ID(String internal_ID) {
        Internal_ID = internal_ID;
    }

    public String getUnique_Entry_ID() {
        return Unique_Entry_ID;
    }

    public void setUnique_Entry_ID(String unique_Entry_ID) {
        Unique_Entry_ID = unique_Entry_ID;
    }
}
