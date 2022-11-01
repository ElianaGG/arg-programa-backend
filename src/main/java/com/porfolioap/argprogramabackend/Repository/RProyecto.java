package com.porfolioap.argprogramabackend.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.porfolioap.argprogramabackend.Entity.Proyecto;

@Repository
public interface RProyecto extends JpaRepository<Proyecto, Integer> {
    public Optional<Proyecto> findByNombreP(String nombreP);

    public boolean existsByNombreP(String nombreP);
}
