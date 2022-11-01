package com.porfolioap.argprogramabackend.Dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class dtoProyecto {
    @NotBlank
    private String nombreP;

    @NotBlank
    private String descripcionP;

    // Constructores
    public dtoProyecto() {
    }

    public dtoProyecto(@NotBlank String nombreP, @NotBlank String descripcionP) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
    }
}
