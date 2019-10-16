package ar.com.ada.api.moverest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.moverest.repositories.InmobiliariaRepository;

/**
 * InmobiliariaService
 */
@Service
public class InmobiliariaService {

    @Autowired
    InmobiliariaRepository repoInmobiliaria;

    public void crearPublicacion(String ubicacion, String direccion, int ambientes,String amenities, String instalaciones, double superficie, double precio, String moneda, String tipoInmueble) {
        
    }
    
}