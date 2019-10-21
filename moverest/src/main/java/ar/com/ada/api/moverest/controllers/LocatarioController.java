package ar.com.ada.api.moverest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.moverest.models.requests.ServicioRequest;
import ar.com.ada.api.moverest.models.responses.BasicResponse;
import ar.com.ada.api.moverest.services.LocatarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * LocatarioController
 */
@RestController
public class LocatarioController {

    @Autowired
    LocatarioService locatarioService;

    @PostMapping("/reservas")
    public BasicResponse postReserva(@RequestBody ServicioRequest req) {
    
        BasicResponse b = new BasicResponse();
        int reservaId = locatarioService.crearReserva(req.locatarioId, req.inmuebleId, req.costo);

        b.isOk = true;
        b.message = "Reserva creada con exito";
        b.id = reservaId;
        return b;
    }
    
    
}