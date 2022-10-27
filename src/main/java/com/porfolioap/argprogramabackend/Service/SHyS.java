package com.porfolioap.argprogramabackend.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porfolioap.argprogramabackend.Entity.HyS;
import com.porfolioap.argprogramabackend.Repository.RHyS;

@Service
@Transactional
public class SHyS {
    @Autowired
    RHyS rhys;

    public List<HyS> list(){
        return rhys.findAll();
    }

    public Optional<HyS> getOne(int id){
        return rhys.findById(id);
    }

    public Optional<HyS> getByNombre(String nombre){
        return rhys.findByNombre(nombre);
    }

    public void save(HyS hys){
        rhys.save(hys);
    }

    public void delete(int id){
        rhys.deleteById(id);
    }

    public boolean existsById(int id){
        return rhys.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return rhys.existsByNombre(nombre);
    }

    
}
