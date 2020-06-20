package com.williamspires.acnhapi.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="apistats")
public class ApiEvent {

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="path")
    private String path;

    @Column(name="time")
    private java.sql.Timestamp time;
}
