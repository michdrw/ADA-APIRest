package ar.com.ada.api.moverest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.moverest.entities.Inmobiliaria;
import ar.com.ada.api.moverest.entities.Persona;
import ar.com.ada.api.moverest.repositories.InmobiliariaRepository;

/**
 * InmobiliariaService
 */
@Service
public class InmobiliariaService {

    @Autowired
    InmobiliariaRepository repoInmobiliaria;
    

    public void save(Inmobiliaria mr) {
        repoInmobiliaria.save(mr);
       
   }
    
}