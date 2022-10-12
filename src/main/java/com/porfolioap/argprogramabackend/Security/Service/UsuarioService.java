package com.porfolioap.argprogramabackend.Security.Service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porfolioap.argprogramabackend.Security.Entity.Usuario;
import com.porfolioap.argprogramabackend.Security.Repository.iUsuarioRepository;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    iUsuarioRepository iusuarioRepository;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return iusuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public boolean existsByNombreUsuario(String nombreUsuario){
        return iusuarioRepository.existByNombreUsuario(nombreUsuario);
    }
  
    public boolean existsByEmail(String email){
        return iusuarioRepository.existByEmail(email);
    }

    public void save(Usuario usuario){
        iusuarioRepository.save(usuario);
       }
}
