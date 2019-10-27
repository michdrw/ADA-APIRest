package ar.com.ada.api.moverest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.moverest.entities.Inmueble;
import ar.com.ada.api.moverest.entities.Locatario;
import ar.com.ada.api.moverest.models.requests.EstadoInmuebleRequest;
import ar.com.ada.api.moverest.models.requests.PersonaRequest;
import ar.com.ada.api.moverest.models.requests.InmuebleRequest;
import ar.com.ada.api.moverest.models.responses.BasicResponse;
import ar.com.ada.api.moverest.services.InmobiliariaService;
import ar.com.ada.api.moverest.services.InmuebleService;
import ar.com.ada.api.moverest.services.LocatarioService;

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
    

    @PostMapping("/locadores")
    public BasicResponse postNewLocador(@RequestBody PersonaRequest req)
    {
        BasicResponse r = new BasicResponse();
        int locadorCreadoId = inmobiliariaService.crearLocador(req.nombre, req.tipoIdentificacion, req.nroIdentificacion, req.edad, req.juricidad, req.inmobiliariaId);

        r.isOk = true;
        r.message = "Locador creado con exito";
        r.id = locadorCreadoId;

        return r;
    }

    @PostMapping("/inmuebles")
    public BasicResponse postNewInmueble(@RequestBody InmuebleRequest req){

        BasicResponse r = new BasicResponse();
        int inmuebleCreadoId = inmuebleService.crearInmueble(req.locadorId, req.ubicacion, req.direccion, req.ambientes, req.amenities, req.instalaciones, req.superficie, req.precio, req.moneda, req.tipoInmueble, req.estado);

        r.isOk = true;
        r.message = "Inmueble publicado con exito";
        r.id = inmuebleCreadoId;
        
        return r;
    }

    @GetMapping("/inmuebles")
    public List<Inmueble> GetInmuebles() {
        List<Inmueble> li = inmuebleService.getInmuebles();

        return li;
    }

    @PutMapping("/inmuebles/{id}") 
    public BasicResponse actualizarEstado(@PathVariable int id, @RequestBody EstadoInmuebleRequest req)
    {
        BasicResponse r = new BasicResponse();
        int inmuebleModificadoId = inmuebleService.actualizarEstado(id, req.estado);

        r.isOk = true;
        r.message = "El estado del inmueble ha sido cambiado";
        r.id = inmuebleModificadoId;
        return r;
    }

    @GetMapping("/locatarios")
    public List<Locatario> GetLocatarios() {
        List<Locatario> lo = locatarioService.getLocatarios();

        return lo;
    }

    
}