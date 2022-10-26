package com.porfolioap.argprogramabackend.Dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoExperiencia {
    @NotBlank
    private String nombreExp;

    @NotBlank   
    private String descriptionExp;

    //Constructores

    public dtoExperiencia() {
    }

    public dtoExperiencia(@NotBlank String nombreExp, @NotBlank String descriptionExp) {
        this.nombreExp = nombreExp;
        this.descriptionExp = descriptionExp;
    }
}
