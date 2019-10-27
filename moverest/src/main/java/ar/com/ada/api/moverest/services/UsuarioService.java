package ar.com.ada.api.moverest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.moverest.entities.Inmobiliaria;
import ar.com.ada.api.moverest.entities.Locatario;
import ar.com.ada.api.moverest.entities.Usuario;
import ar.com.ada.api.moverest.repositories.UsuarioRepository;
import ar.com.ada.api.moverest.security.Crypto;

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

    public void save(Usuario u) {
        repoUsuario.save(u);
    }

    public int crearUsuario(String email, String password, Boolean tipo, String nombre, int edad,
            String tipoIdentificacion, int nroIdentificacion) {

        String passwordEncriptada;
        String passwordEnTextoClaroDesencriptado;
        String passwordEnTextoClaro;
        Usuario u = new Usuario();
        u.setEmail(email);
        u.setUsername(email);

        passwordEnTextoClaro = password;
        passwordEncriptada = Crypto.encrypt(passwordEnTextoClaro, u.getUsername());
        passwordEnTextoClaroDesencriptado = Crypto.decrypt(passwordEncriptada, u.getUsername());

        if (passwordEnTextoClaro.equals(passwordEnTextoClaroDesencriptado)) {
            
        u.setPassword(passwordEncriptada);
        save(u);
            if (tipo == true) {
                Locatario l = new Locatario();
                l.setNombre(nombre);
                l.setTipoIdentificacion(tipoIdentificacion);
                l.setNroIdentificacion(nroIdentificacion);
                l.setEdad(edad);
                l.setUsuario(u);

                save(u);
                locatarioService.save(l);
            } else {
                Inmobiliaria mr = new Inmobiliaria();
                mr.setUsuario(u);
                inmobiliariaService.save(mr);
                u.setInmobiliaria(mr);
                save(u);
            }
        }

        return u.getUsuarioId();
    }

    public Usuario buscarPorId(Integer id) {
        Optional<Usuario> u = repoUsuario.findById(id);
        if (u.isPresent())
            return u.get();
        return null;
    }

    public int modificaPassword(Integer usuarioId, String password) {
        String passwordEncriptada;

        Usuario u = this.buscarPorId(usuarioId);
        u.setUsuarioId(usuarioId);

        passwordEncriptada = Crypto.encrypt(password, u.getUsername());
        u.setPassword(passwordEncriptada);
            repoUsuario.save(u);
        return u.getUsuarioId();

    }
}