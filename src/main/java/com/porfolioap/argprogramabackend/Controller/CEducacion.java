package com.porfolioap.argprogramabackend.Controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.porfolioap.argprogramabackend.Dto.dtoEducacion;
import com.porfolioap.argprogramabackend.Entity.Educacion;
import com.porfolioap.argprogramabackend.Security.Controller.Mensaje;
import com.porfolioap.argprogramabackend.Service.SEducacion;

@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = "https://arg-programa-backend.web.app/")
public class CEducacion {
    @Autowired
    SEducacion sEducacion;

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity<>(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }   
        Educacion educacion = sEducacion.getOne(id).get();
            return new ResponseEntity<>(educacion, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoedu){
        if(StringUtils.isBlank(dtoedu.getNombreEdu())) {
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        } 
        
        if(sEducacion.existsByNombreEdu(dtoedu.getNombreEdu())){
            return new ResponseEntity<>(new Mensaje("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
          
        Educacion educacion  = new Educacion(dtoedu.getNombreEdu(), dtoedu.getDescriptionEdu());
        
        sEducacion.save(educacion);

        return new ResponseEntity<>(new Mensaje("Educacion agregada"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity<>(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        sEducacion.delete(id);
            return new ResponseEntity<>(new Mensaje("Educacion elimanada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoedu){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity<>(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }    

        if(sEducacion.existsByNombreEdu(dtoedu.getNombreEdu()) && 
        sEducacion.getByNombreEdu(dtoedu.getNombreEdu()).get().getId() != id) {
            return new ResponseEntity<>(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
           
        if(StringUtils.isBlank(dtoedu.getNombreEdu())){
            return new ResponseEntity<>(new Mensaje("El campo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
            
            Educacion educacion = sEducacion.getOne(id).get();
            educacion.setNombreEdu(dtoedu.getNombreEdu());
            educacion.setDescriptionEdu(dtoedu.getDescriptionEdu());

            sEducacion.save(educacion);
                return new ResponseEntity<>(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }
}
