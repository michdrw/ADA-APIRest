package ar.com.ada.api.moverest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.moverest.entities.Inmobiliaria;
import ar.com.ada.api.moverest.entities.Locatario;
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
    LocatarioService locatarioService;
    @Autowired
    InmobiliariaService inmobiliariaService;

    public int crearUsuario(Boolean tipo, String nombre, int edad, String tipoIdentificacion, int nroIdentificacion, String email, String password){
    
        Usuario u = new Usuario();
        u.setEmail(email);
        u.setUsername(email);
        u.setPassword(password);

        if (tipo = true)
        {
        Locatario l = new Locatario();
        l.setNombre(nombre);
        l.setTipoIdentificacion(tipoIdentificacion);
        l.setEdad(edad);
        l.setUsuario(u);
        locatarioService.save(l);
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