package ar.com.ada.api.moverest.services;

import java.util.Optional;

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

    public void save(Usuario u) 
    {
        repoUsuario.save(u);
    }

    public int crearUsuario(String email, String password, Boolean tipo, String nombre, int edad, String tipoIdentificacion, int nroIdentificacion){
    
        Usuario u = new Usuario();
        u.setEmail(email);
        u.setUsername(email);
        u.setPassword(password);
        save(u);

        if (tipo == true)
        {
        Locatario l = new Locatario();
        l.setNombre(nombre);
        l.setTipoIdentificacion(tipoIdentificacion);
        l.setNroIdentificacion(nroIdentificacion);
        l.setEdad(edad);
        l.setUsuario(u);
        
        save(u);
        locatarioService.save(l);
        }
        else
        {
            Inmobiliaria mr = new Inmobiliaria(); 
            mr.setUsuario(u);
            inmobiliariaService.save(mr);
            u.setInmobiliaria(mr);
            save(u);
        }

        return u.getUsuarioId();
    }

      public Usuario buscarPorId(Integer id) {
        Optional<Usuario> u = repoUsuario.findById(id);
        if (u.isPresent())
            return u.get();
        return null;
    }

     public void modificaPassword(Integer usuarioId, String password) {
        Usuario u = this.buscarPorId(usuarioId);
        u.setUsuarioId(usuarioId);
        u.setPassword(password);
        repoUsuario.save(u);

    }
}