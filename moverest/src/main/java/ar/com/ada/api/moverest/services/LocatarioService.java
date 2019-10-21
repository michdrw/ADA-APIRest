package ar.com.ada.api.moverest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.moverest.entities.Arrendamiento;
import ar.com.ada.api.moverest.entities.Inmueble;
import ar.com.ada.api.moverest.entities.Locatario;
import ar.com.ada.api.moverest.entities.Reserva;
import ar.com.ada.api.moverest.entities.Venta;
import ar.com.ada.api.moverest.repositories.LocatarioRepository;

/**
 * LocatarioService
 */
@Service
public class LocatarioService {

    @Autowired
    LocatarioRepository repoLocatario;

    @Autowired
    InmuebleService inmuebleService;

    @Autowired
    ReservaService reservaService;

    @Autowired
    ArrendamientoService arrendamientoService;

    @Autowired
    VentaService ventaService;


    public void save(Locatario l) {
        repoLocatario.save(l);
       
   }

   public Locatario buscarPorId(int locatarioId)
    {
        Optional<Locatario> l = repoLocatario.findById(locatarioId);

        if (l.isPresent()) {
            return l.get();
        }
        return null;
    }

   public List<Locatario> getLocatarios() {

        return repoLocatario.findAll();
    }

    public int crearReserva(int locatarioId, int inmuebleId, double costo)
    {
        Inmueble i = inmuebleService.buscarPorId(inmuebleId);
        Locatario l = buscarPorId(locatarioId);
        Reserva r = new Reserva();
        r.setCosto(costo);
        r.setInmueble(i);
        r.setLocatario(l);
        
        reservaService.save(r);

        return r.getReservaId();   
    }

    public int crearContratoArrendamiento(int locatarioId, int inmuebleId)
    {
        Inmueble i = inmuebleService.buscarPorId(inmuebleId);
        Locatario l = buscarPorId(locatarioId);
        Arrendamiento a = new Arrendamiento();
        a.setInmueble(i);
        a.setLocatario(l);
        a.setCosto(i.getPrecio());

        arrendamientoService.save(a);

        return a.getArrendamientoId();
    }

    public int crearContratoVenta(int locatarioId, int inmuebleId)
    {
        Inmueble i = inmuebleService.buscarPorId(inmuebleId);
        Locatario l = buscarPorId(locatarioId);
        Venta v = new Venta();
        v.setInmueble(i);
        v.setLocatario(l);
        v.setCosto(i.getPrecio());

        ventaService.save(v);
        
        return v.getVentaId();
    }
}