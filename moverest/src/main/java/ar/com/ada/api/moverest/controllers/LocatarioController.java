package ar.com.ada.api.moverest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.moverest.models.requests.ReservaRequest;
import ar.com.ada.api.moverest.models.requests.ServicioRequest;
import ar.com.ada.api.moverest.models.responses.BasicResponse;
import ar.com.ada.api.moverest.services.LocatarioService;


/**
 * LocatarioController
 */
@RestController
public class LocatarioController {

    @Autowired
    LocatarioService locatarioService;

    @PostMapping("/reservas")
    public BasicResponse postReserva(@RequestBody ReservaRequest req) {
    
        BasicResponse b = new BasicResponse();
        int reservaId = locatarioService.crearReserva(req.locatarioId, req.inmuebleId, req.costo);

        b.isOk = true;
        b.message = "Reserva creada con exito";
        b.id = reservaId;
        return b;
    }

    @PostMapping("/arrendamientos")
    public BasicResponse postArrendamiento(@RequestBody ServicioRequest req) {
    
        BasicResponse b = new BasicResponse();
        int arrendamientoId = locatarioService.crearContratoArrendamiento(req.locatarioId, req.inmuebleId);

        b.isOk = true;
        b.message = "Contrato alquiler iniciado con exito";
        b.id = arrendamientoId;
        return b;
    }
    
    @PostMapping("/ventas")
    public BasicResponse postVenta(@RequestBody ServicioRequest req) {
    
        BasicResponse b = new BasicResponse();
        int ventaId = locatarioService.crearContratoVenta(req.locatarioId, req.inmuebleId);

        b.isOk = true;
        b.message = "Proceso de venta iniciado con exito";
        b.id = ventaId;
        return b;
    }
    
}