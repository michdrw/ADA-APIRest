package ar.com.ada.api.moverest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.moverest.repositories.VentaRepository;

/**
 * VentaService
 */
@Service
public class VentaService {

    @Autowired
    VentaRepository repoVenta;
}