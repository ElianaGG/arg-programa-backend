package com.porfolioap.argprogramabackend.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.porfolioap.argprogramabackend.Entity.HyS;

@Repository
public interface RHyS extends JpaRepository<HyS, Integer> {
    public Optional<HyS> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
    
}