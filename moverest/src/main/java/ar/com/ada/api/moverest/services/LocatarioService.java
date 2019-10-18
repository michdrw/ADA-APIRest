package ar.com.ada.api.moverest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.moverest.entities.Locatario;
import ar.com.ada.api.moverest.repositories.LocatarioRepository;

/**
 * LocatarioService
 */
@Service
public class LocatarioService {

    @Autowired
    LocatarioRepository repoLocatario;

    public void save(Locatario l) {
        repoLocatario.save(l);
       
   }
}