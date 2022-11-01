package com.porfolioap.argprogramabackend.Dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class dtoExperiencia {
    @NotBlank
    private String nombreExp;

    @NotBlank
    private String descripcionExp;

    // Constructores

    public dtoExperiencia() {
    }

    public dtoExperiencia(@NotBlank String nombreExp, @NotBlank String descripcionExp) {
        this.nombreExp = nombreExp;
        this.descripcionExp = descripcionExp;
    }
}
