package com.porfolioap.argprogramabackend.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.porfolioap.argprogramabackend.Entity.Experiencia;

@Repository
public interface RExperiencia extends JpaRepository<Experiencia, Integer> {
    public Optional<Experiencia> findByNombreExp(String nombreExp);

    public boolean existsByNombreExp(String nombreExp);

}
