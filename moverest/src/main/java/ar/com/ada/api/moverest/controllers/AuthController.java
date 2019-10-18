package ar.com.ada.api.moverest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.moverest.models.requests.RegistrationRequest;
import ar.com.ada.api.moverest.models.responses.RegistrationResponse;
import ar.com.ada.api.moverest.services.UsuarioService;

/**
 * AuthController
 */
@RestController
public class AuthController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("auth/register")
    public RegistrationResponse postRegisterUser(@RequestBody RegistrationRequest req) {


        RegistrationResponse r = new RegistrationResponse();
        int usuarioCreadoId = usuarioService.crearUsuario(req.tipo, req.personaData.nombre, req.personaData.edad, req.personaData.tipoIdentificacion, req.personaData.nroIdentificacion, req.email, req.password);
        

        r.isOk = true;
        r.message = "Te registraste con exito";
        r.usuarioId = usuarioCreadoId; 

        return r;
        
    }

}