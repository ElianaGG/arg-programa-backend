package com.porfolioap.argprogramabackend.Controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.porfolioap.argprogramabackend.Dto.dtoPersona;
import com.porfolioap.argprogramabackend.Entity.Persona;
import com.porfolioap.argprogramabackend.Security.Controller.Mensaje;
import com.porfolioap.argprogramabackend.Service.ImpPersonaService;

@RestController
@CrossOrigin
@RequestMapping("/personas")
public class CPersona {
    @Autowired
    ImpPersonaService impPersonaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = impPersonaService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id) {
        if (!impPersonaService.existsById(id)) {
            return new ResponseEntity<>(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = impPersonaService.getOne(id).get();
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona) {
        if (!impPersonaService.existsById(id)) {
            return new ResponseEntity<>(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }

        if (impPersonaService.existsByNombre(dtopersona.getNombre()) &&
                impPersonaService.getByNombre(dtopersona.getNombre()).get().getId() != id) {
            return new ResponseEntity<>(new Mensaje("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtopersona.getNombre())) {
            return new ResponseEntity<>(new Mensaje("Nombre obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtopersona.getApellido())) {
            return new ResponseEntity<>(new Mensaje("Apellido obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtopersona.getDescripcion())) {
            return new ResponseEntity<>(new Mensaje("Descripción obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtopersona.getImg())) {
            return new ResponseEntity<>(new Mensaje("Descripción obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = impPersonaService.getOne(id).get();
        persona.setNombre(dtopersona.getNombre());
        persona.setApellido(dtopersona.getApellido());
        persona.setDescripcion(dtopersona.getDescripcion());
        persona.setImg(dtopersona.getImg());

        impPersonaService.save(persona);
        return new ResponseEntity<>(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }
}