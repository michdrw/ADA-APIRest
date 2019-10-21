package ar.com.ada.api.moverest.services;

import java.util.List;
import java.util.Optional;

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

    public int crearInmueble(int locadorId, String ubicacion, String direccion, int ambientes,String amenities, String instalaciones, double superficie, double precio, String moneda, String tipoInmueble, String estado)
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
        i.setEstado(estado);
        
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

        return i.getInmuebleId();
    }

    public List<Inmueble> getInmuebles() {

        return repoInmueble.findAll();
    }

    public Inmueble buscarPorId(int inmuebleId)
    {
        Optional<Inmueble> i = repoInmueble.findById(inmuebleId);

        if (i.isPresent()) {
            return i.get();
        }
        return null;
    }

    public int actualizarEstado(int inmuebleId, String estado)
    {
        Inmueble i = buscarPorId(inmuebleId);
        i.setEstado(estado);

        repoInmueble.save(i);
        
        return inmuebleId;
    }



    
}