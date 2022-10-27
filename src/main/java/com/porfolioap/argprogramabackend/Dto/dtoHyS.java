package com.porfolioap.argprogramabackend.Dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class dtoHyS {
    @NotBlank
    private String nombre;
    @NotBlank
    private int porcentaje;

     //Constructores

     public dtoHyS() {
    }

    public dtoHyS(@NotBlank String nombre, @NotBlank int porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }
}
