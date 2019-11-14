package ar.com.ada.api.moverest.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.moverest.entities.Inmueble;
import ar.com.ada.api.moverest.entities.Locatario;
import ar.com.ada.api.moverest.entities.Usuario;
import ar.com.ada.api.moverest.models.requests.EstadoInmuebleRequest;
import ar.com.ada.api.moverest.models.requests.PersonaRequest;
import ar.com.ada.api.moverest.models.requests.InmuebleRequest;
import ar.com.ada.api.moverest.models.responses.BasicResponse;
import ar.com.ada.api.moverest.services.InmobiliariaService;
import ar.com.ada.api.moverest.services.InmuebleService;
import ar.com.ada.api.moverest.services.LocatarioService;
import ar.com.ada.api.moverest.services.UsuarioService;

/**
 * InmobiliariaController
 */
@RestController
public class InmobiliariaController {

    @Autowired
    InmobiliariaService inmobiliariaService;

    @Autowired
    InmuebleService inmuebleService;

    @Autowired
    LocatarioService locatarioService;

    @Autowired
    UsuarioService usuarioService;

    

    @PostMapping("/locadores")
    public ResponseEntity<BasicResponse> postNewLocador(@RequestBody PersonaRequest req, Principal principal)
    {
        UsernamePasswordAuthenticationToken uat = (UsernamePasswordAuthenticationToken) principal;
        User ud = (User)uat.getPrincipal();
        String userName = ud.getUsername();
        Usuario u = usuarioService.buscarPorUsername(userName);

        if (!u.getTipoUsuario().equals("inmobiliaria")){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN); 
        }

        BasicResponse r = new BasicResponse();
        int locadorCreadoId = inmobiliariaService.crearLocador(req.nombre, req.tipoIdentificacion, req.nroIdentificacion, req.edad, req.juricidad, req.inmobiliariaId);

        r.isOk = true;
        r.message = "Locador creado con exito";
        r.id = locadorCreadoId;

        return ResponseEntity.ok(r);
    }

    @PostMapping("/inmuebles")
    public ResponseEntity<BasicResponse> postNewInmueble(@RequestBody InmuebleRequest req, Principal principal){

        UsernamePasswordAuthenticationToken uat = (UsernamePasswordAuthenticationToken) principal;
        User ud = (User)uat.getPrincipal();
        String userName = ud.getUsername();
        Usuario u = usuarioService.buscarPorUsername(userName);

        if (!u.getTipoUsuario().equals("inmobiliaria")){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN); 
        }

        BasicResponse r = new BasicResponse();
        int inmuebleCreadoId = inmuebleService.crearInmueble(req.locadorId, req.ubicacion, req.direccion, req.ambientes, req.amenities, req.instalaciones, req.superficie, req.precio, req.moneda, req.tipoInmueble, req.estado);

        r.isOk = true;
        r.message = "Inmueble publicado con exito";
        r.id = inmuebleCreadoId;
        
        return ResponseEntity.ok(r);
    }

    @GetMapping("/inmuebles")
    public ResponseEntity<List<Inmueble>> GetInmuebles(Principal principal) {

        UsernamePasswordAuthenticationToken uat = (UsernamePasswordAuthenticationToken) principal;
        User ud = (User)uat.getPrincipal();
        String userName = ud.getUsername();
        Usuario u = usuarioService.buscarPorUsername(userName);

        if (!u.getTipoUsuario().equals("inmobiliaria")){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN); 
        }

        List<Inmueble> li = inmuebleService.getInmuebles();

        return ResponseEntity.ok(li);
    }

    @PutMapping("/inmuebles/{id}") 
    public ResponseEntity<BasicResponse> actualizarEstado(@PathVariable int id, @RequestBody EstadoInmuebleRequest req, Principal principal)
    {
        UsernamePasswordAuthenticationToken uat = (UsernamePasswordAuthenticationToken) principal;
        User ud = (User)uat.getPrincipal();
        String userName = ud.getUsername();
        Usuario u = usuarioService.buscarPorUsername(userName);

        if (!u.getTipoUsuario().equals("inmobiliaria")){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN); 
        }
        
        BasicResponse r = new BasicResponse();
        int inmuebleModificadoId = inmuebleService.actualizarEstado(id, req.estado);

        r.isOk = true;
        r.message = "El estado del inmueble ha sido cambiado!!!";
        r.id = inmuebleModificadoId;
        return ResponseEntity.ok(r);
    }

    @GetMapping("/locatarios")
    public ResponseEntity<List<Locatario>> GetLocatarios(Authentication authentication, Principal principal)  {
        
        UsernamePasswordAuthenticationToken uat = (UsernamePasswordAuthenticationToken) principal;
        User ud = (User)uat.getPrincipal();
        String userName = ud.getUsername();
        Usuario u = usuarioService.buscarPorUsername(userName);

        if (!u.getTipoUsuario().equals("inmobiliaria")){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN); 
        }

        List<Locatario> lo = locatarioService.getLocatarios();
        return ResponseEntity.ok(lo);
            
    }
}