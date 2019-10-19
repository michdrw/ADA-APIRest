package ar.com.ada.api.moverest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.moverest.entities.Locador;
import ar.com.ada.api.moverest.repositories.LocadorRepository;

/**
 * LocadorService
 */
@Service
public class LocadorService {

    @Autowired
    LocadorRepository repoLocador;
    
    public Locador buscarPorId(int locadorId)
    {
        Optional<Locador> l = repoLocador.findById(locadorId);

        if (l.isPresent()) {
            return l.get();
        }
        return null;
    }
}