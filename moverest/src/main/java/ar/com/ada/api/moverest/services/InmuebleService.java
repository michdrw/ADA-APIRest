package ar.com.ada.api.moverest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.moverest.entities.Inmueble;
import ar.com.ada.api.moverest.entities.Locador;
import ar.com.ada.api.moverest.repositories.InmuebleRepository;

/**
 * InmuebleService
 */
@Service
public class InmuebleService {

    @Autowired
    InmuebleRepository repoInmueble;
    @Autowired
    LocadorService locadorService;

    public Inmueble save(Inmueble i) {
        return repoInmueble.save(i);
        
    }

    public void crearInmueble(int locadorId, String ubicacion, String direccion, int ambientes,String amenities, String instalaciones, double superficie, double precio, String moneda, String tipoInmueble)
    {
        Inmueble i = new Inmueble();
        i.setUbicacion(ubicacion);
        i.setDireccion(direccion);
        i.setAmbientes(ambientes);
        i.setAmenities(amenities);
        i.setInstalaciones(instalaciones);
        i.setSuperficie(superficie);
        i.setPrecio(precio);
        i.setMoneda(moneda);
        i.setTipoInmueble(tipoInmueble);
        repoInmueble.save(i);

        Locador lo = locadorService.buscarPorId(locadorId);
        if (lo == null)
        {
            Locador l = new Locador();
            l.declararInmueble(i);
            i.setLocador(l);
        }
        else 
        {
            lo.declararInmueble(i);
            i.setLocador(lo);
        }

        repoInmueble.save(i);
    }

    public void asignarLocador(int locadorId)
    {
        
    }


    
}