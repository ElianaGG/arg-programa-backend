package com.porfolioap.argprogramabackend.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreEdu;
    private String descriptionEdu;

    //Constructores
    public Educacion() {
    } 

    public Educacion(String nombreEdu, String descriptionEdu) {
        this.nombreEdu = nombreEdu;
        this.descriptionEdu = descriptionEdu;
    }

}