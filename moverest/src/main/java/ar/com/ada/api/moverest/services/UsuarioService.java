package ar.com.ada.api.moverest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.moverest.entities.Inmobiliaria;
import ar.com.ada.api.moverest.entities.Persona;
import ar.com.ada.api.moverest.entities.Usuario;
import ar.com.ada.api.moverest.repositories.UsuarioRepository;

/**
 * UsuarioService
 */
@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repoUsuario;
    @Autowired
    PersonaService personaService;
    @Autowired
    InmobiliariaService inmobiliariaService;

    public int crearUsuario(Boolean tipo, String nombre, int edad, String tipoIdentificacion, int nroIdentificacion, String email, String password){
    
        Usuario u = new Usuario();
        u.setEmail(email);
        u.setUsername(email);
        u.setPassword(password);

        if (tipo = true)
        {
        Persona p = new Persona();
        p.setNombre(nombre);
        p.setTipoIdentificacion(tipoIdentificacion);
        p.setEdad(edad);
        p.setUsuario(u);
        personaService.save(p);
        }
        else
        {
            Inmobiliaria mr = new Inmobiliaria(); 
            mr.setUsuario(u);
            inmobiliariaService.save(mr);
        }

        return u.getUsuarioId();
    }
}