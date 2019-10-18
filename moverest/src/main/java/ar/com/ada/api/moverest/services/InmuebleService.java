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

    public Inmueble save(Inmueble i) {
        return repoInmueble.save(i);
        
    }

    public void crearInmueble(String ubicacion, String direccion, int ambientes,String amenities, String instalaciones, double superficie, double precio, String moneda, String tipoInmueble)
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

        Locador l = new Locador();


        repoInmueble.save(i);
    }

    
}