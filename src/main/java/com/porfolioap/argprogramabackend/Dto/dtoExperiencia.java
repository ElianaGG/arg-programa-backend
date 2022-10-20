package com.porfolioap.argprogramabackend.Dto;

import javax.validation.constraints.NotBlank;

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

    //Getters & Setters
    public String getNombreExp() {
        return nombreExp;
    }

    public void setNombreExp(String nombreExp) {
        this.nombreExp = nombreExp;
    }

    public String getDescriptionExp() {
        return descriptionExp;
    }

    public void setDescriptionExp(String descriptionExp) {
        this.descriptionExp = descriptionExp;
    }

   

    
}
