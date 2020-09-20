package com.williamspires.acnhapi.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CatalogFurniture")
@Getter
@Setter
public class CatalogItems {

    @Id
    @Column(name="Name")
    private String name;
}
