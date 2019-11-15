package ar.com.ada.api.moverest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.moverest.models.requests.LoginRequest;
import ar.com.ada.api.moverest.models.requests.PasswordRequest;
import ar.com.ada.api.moverest.models.requests.RegistrationRequest;
import ar.com.ada.api.moverest.models.responses.BasicResponse;
import ar.com.ada.api.moverest.models.responses.JwtResponse;
import ar.com.ada.api.moverest.security.jwt.JWTTokenUtil;
import ar.com.ada.api.moverest.services.JWTUserDetailsService;
import ar.com.ada.api.moverest.services.UsuarioService;

/**
 * AuthController
 */
@RestController
public class AuthController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    private JWTTokenUtil jwtTokenUtil;
    
    @Autowired
    private JWTUserDetailsService userDetailsService;

    @PostMapping("/auth/register")
    public BasicResponse postRegisterUser(@RequestBody RegistrationRequest req) {

        BasicResponse b = new BasicResponse();
        int usuarioCreadoId = usuarioService.crearUsuario(req.email, req.password, req.tipo, req.personaData.nombre,
                req.personaData.edad, req.personaData.tipoIdentificacion, req.personaData.nroIdentificacion);

        b.isOk = true;
        b.message = "Te registraste con exito!!!";
        b.id = usuarioCreadoId;

        return b;

    }

    @PostMapping("auth/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest authenticationRequest)
            throws Exception {

        usuarioService.login(authenticationRequest.username, authenticationRequest.password);

        final UserDetails userDetails = userDetailsService
            .loadUserByUsername(authenticationRequest.username);

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));

    }

    @PutMapping("usuarios/{id}/password")
    public BasicResponse putPassword(@PathVariable int id, @RequestBody PasswordRequest req) throws Exception {

        BasicResponse p = new BasicResponse();

        int usuarioId = usuarioService.modificaPassword(id, req.password);

        p.isOk = true;
        p.message = "Password restablecida.";
        p.id = usuarioId;


        return p;
    }

}