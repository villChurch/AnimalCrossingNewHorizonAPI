package com.williamspires.acnhapi.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="recipes")
public class Recipes {

    @Column(name="me")
    private String name;
    private int matnum1;
    private String Material_1;
    private int matnum2;
    private String Material_2;
    private int matnum3;
    private String Material_3;
    private int matnum4;
    private String Material_4;
    private int matnum5;
    private String Material_5;
    private int matnum6;
    private String Material_6;
    private String Buy;
    private int Sell;
    private String Miles_Price;
    private String Source;
    private String Source_Notes;
    private int Recipes_to_Unlock;
    private String Version;
    private String Category;
    private int Serial_ID;
    private int Internal_ID;
    @Id
    private String Unique_Entry_ID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMatnum1() {
        return matnum1;
    }

    public void setMatnum1(int matnum1) {
        this.matnum1 = matnum1;
    }

    public String getMaterial_1() {
        return Material_1;
    }

    public void setMaterial_1(String material_1) {
        Material_1 = material_1;
    }

    public int getMatnum2() {
        return matnum2;
    }

    public void setMatnum2(int matnum2) {
        this.matnum2 = matnum2;
    }

    public String getMaterial_2() {
        return Material_2;
    }

    public void setMaterial_2(String material_2) {
        Material_2 = material_2;
    }

    public int getMatnum3() {
        return matnum3;
    }

    public void setMatnum3(int matnum3) {
        this.matnum3 = matnum3;
    }

    public String getMaterial_3() {
        return Material_3;
    }

    public void setMaterial_3(String material_3) {
        Material_3 = material_3;
    }

    public int getMatnum4() {
        return matnum4;
    }

    public void setMatnum4(int matnum4) {
        this.matnum4 = matnum4;
    }

    public String getMaterial_4() {
        return Material_4;
    }

    public void setMaterial_4(String material_4) {
        Material_4 = material_4;
    }

    public int getMatnum5() {
        return matnum5;
    }

    public void setMatnum5(int matnum5) {
        this.matnum5 = matnum5;
    }

    public String getMaterial_5() {
        return Material_5;
    }

    public void setMaterial_5(String material_5) {
        Material_5 = material_5;
    }

    public int getMatnum6() {
        return matnum6;
    }

    public void setMatnum6(int matnum6) {
        this.matnum6 = matnum6;
    }

    public String getMaterial_6() {
        return Material_6;
    }

    public void setMaterial_6(String material_6) {
        Material_6 = material_6;
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

    public int getRecipes_to_Unlock() {
        return Recipes_to_Unlock;
    }

    public void setRecipes_to_Unlock(int recipes_to_Unlock) {
        Recipes_to_Unlock = recipes_to_Unlock;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public int getSerial_ID() {
        return Serial_ID;
    }

    public void setSerial_ID(int serial_ID) {
        Serial_ID = serial_ID;
    }

    public int getInternal_ID() {
        return Internal_ID;
    }

    public void setInternal_ID(int internal_ID) {
        Internal_ID = internal_ID;
    }

    public String getUnique_Entry_ID() {
        return Unique_Entry_ID;
    }

    public void setUnique_Entry_ID(String unique_Entry_ID) {
        Unique_Entry_ID = unique_Entry_ID;
    }
}
