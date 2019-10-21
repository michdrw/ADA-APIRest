package ar.com.ada.api.moverest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.moverest.entities.Inmobiliaria;
import ar.com.ada.api.moverest.entities.Locador;
import ar.com.ada.api.moverest.repositories.InmobiliariaRepository;

/**
 * InmobiliariaService
 */
@Service
public class InmobiliariaService {

    @Autowired
    InmobiliariaRepository repoInmobiliaria;
    @Autowired
    LocadorService locadorService;
    

    public void save(Inmobiliaria mr) 
    {
        repoInmobiliaria.save(mr);
    }

   public int crearLocador(String nombre, int edad, String tipoIdentificacion, int nroIdentificacion)
   {
       Locador l = new Locador();
        l.setNombre(nombre);
        l.setTipoIdentificacion(tipoIdentificacion);
        l.setNroIdentificacion(nroIdentificacion);
        l.setEdad(edad);

        locadorService.save(l);
        return l.getLocadorId();
   }
    
}