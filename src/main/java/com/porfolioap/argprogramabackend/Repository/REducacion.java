package com.porfolioap.argprogramabackend.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.porfolioap.argprogramabackend.Entity.Educacion;

@Repository
public interface REducacion extends JpaRepository<Educacion, Integer> {
    public Optional<Educacion> findByNombreEdu(String nombreEdu);

    public boolean existsByNombreEdu(String nombreEdu);
}
