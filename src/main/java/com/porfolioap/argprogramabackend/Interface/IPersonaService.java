package com.porfolioap.argprogramabackend.Interface;

import com.porfolioap.argprogramabackend.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    //Traer una lista de personas
    public List<Persona> getPersona();
    
    //Guardar un objeto de tipo Persona
    public void savePersona(Persona persona);
    
    //Eliminar un objeto buscando con ID
    public void deletePersona(Long id);
    
    //Buscar persona con ID
    public Persona findPersona(Long id);
}
