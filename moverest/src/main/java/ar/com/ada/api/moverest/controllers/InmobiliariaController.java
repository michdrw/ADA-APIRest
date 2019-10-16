package ar.com.ada.api.moverest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.moverest.models.requests.PublicacionRequest;
import ar.com.ada.api.moverest.models.responses.PublicacionResponse;
import ar.com.ada.api.moverest.services.InmobiliariaService;

/**
 * InmobiliariaController
 */
@RestController
public class InmobiliariaController {

    @Autowired
    InmobiliariaService inmobiliariaService;

    @PostMapping("publicacion")
    public PublicacionResponse postRegisterUser(@RequestBody PublicacionRequest req){

        PublicacionResponse pr = new PublicacionResponse();
        inmobiliariaService.crearPublicacion(req.ubicacion, req.direccion, req.ambientes, req.amenities, req.instalaciones, req.superficie, req.precio, req.moneda, req.tipoInmueble);

        pr.isOk = true;
        pr.message = "Inmueble publicado con exito";

        return pr;

    }
}