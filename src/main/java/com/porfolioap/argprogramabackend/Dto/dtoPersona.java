package com.porfolioap.argprogramabackend.Dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class dtoPersona {
    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    @NotBlank
    private String descripcion;

    @NotBlank
    private String img;

    // Constructores

    public dtoPersona() {
    }

    public dtoPersona(@NotBlank String nombre, @NotBlank String apellido, @NotBlank String descripcion,
    @NotBlank String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.img = img;
    }

}
