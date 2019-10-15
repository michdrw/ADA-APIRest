package ar.com.ada.api.moverest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public int crearUsuario(String nombre, int edad, String tipoIdentificacion, int nroIdentificacion, String email, String password){
    
        Usuario u = new Usuario();
        u.setEmail(email);
        u.setUsername(email);
        u.setPassword(password);
        

        Persona p = new Persona();
        p.setNombre(nombre);
        p.setContactoEmail(u.getEmail());
        p.setTipoIdentificacion(tipoIdentificacion);
        p.setEdad(edad);
        p.setUsuario(u);
        personaService.save(p);

        return u.getUsuarioId();
    }
}