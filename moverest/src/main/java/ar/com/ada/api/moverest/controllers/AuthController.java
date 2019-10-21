package ar.com.ada.api.moverest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.moverest.models.requests.RegistrationRequest;
import ar.com.ada.api.moverest.models.responses.BasicResponse;
import ar.com.ada.api.moverest.services.UsuarioService;

/**
 * AuthController
 */
@RestController
public class AuthController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("auth/register")
    public BasicResponse postRegisterUser(@RequestBody RegistrationRequest req) {


        BasicResponse b = new BasicResponse();
        int usuarioCreadoId = usuarioService.crearUsuario(req.tipo, req.personaData.nombre, req.personaData.edad, req.personaData.tipoIdentificacion, req.personaData.nroIdentificacion, req.email, req.password);
        

        b.isOk = true;
        b.message = "Te registraste con exito";
        b.id = usuarioCreadoId; 

        return b;
        
    }

}