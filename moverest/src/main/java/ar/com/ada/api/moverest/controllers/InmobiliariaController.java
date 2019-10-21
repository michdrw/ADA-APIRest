package ar.com.ada.api.moverest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.moverest.models.requests.PersonaRequest;
import ar.com.ada.api.moverest.models.requests.PublicacionRequest;
import ar.com.ada.api.moverest.models.responses.BasicResponse;
import ar.com.ada.api.moverest.services.InmobiliariaService;
import ar.com.ada.api.moverest.services.InmuebleService;

/**
 * InmobiliariaController
 */
@RestController
public class InmobiliariaController {

    @Autowired
    InmobiliariaService inmobiliariaService;

    @Autowired
    InmuebleService inmuebleService;


     @PostMapping("/locadores")
    public BasicResponse postNewLocador(@RequestBody PersonaRequest req)
    {
        BasicResponse r = new BasicResponse();
        int locadorCreadoId = inmobiliariaService.crearLocador(req.nombre, req.edad, req.tipoIdentificacion, req.nroIdentificacion);

        r.isOk = true;
        r.message = "Locador creado con exito";
        r.id = locadorCreadoId;

        return r;
    }

    @PostMapping("/inmuebles")
    public BasicResponse postNewInmueble(@RequestBody PublicacionRequest req){

        BasicResponse r = new BasicResponse();
        int inmuebleCreadoId = inmuebleService.crearInmueble(req.locadorId, req.ubicacion, req.direccion, req.ambientes, req.amenities, req.instalaciones, req.superficie, req.precio, req.moneda, req.tipoInmueble);

        r.isOk = true;
        r.message = "Inmueble publicado con exito";
        r.id = inmuebleCreadoId;
        
        return r;

    }

    
}