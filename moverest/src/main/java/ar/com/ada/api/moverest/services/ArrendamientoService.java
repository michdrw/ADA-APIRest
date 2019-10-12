package ar.com.ada.api.moverest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.moverest.repositories.ArrendamientoRepository;

/**
 * ArrendamientoService
 */
@Service
public class ArrendamientoService {

    @Autowired
    ArrendamientoRepository repoArrendamiento;


}