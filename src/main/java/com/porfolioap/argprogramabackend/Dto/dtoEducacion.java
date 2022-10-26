package com.porfolioap.argprogramabackend.Dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoEducacion {
    @NotBlank
    private String nombreEdu;

    @NotBlank   
    private String descriptionEdu;

    //Constructores

    public dtoEducacion() {
    }

    public dtoEducacion(@NotBlank String nombreEdu, @NotBlank String descriptionEdu) {
        this.nombreEdu = nombreEdu;
        this.descriptionEdu = descriptionEdu;
    }
    
}
