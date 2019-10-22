package ar.com.ada.api.moverest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.moverest.entities.Venta;
import ar.com.ada.api.moverest.repositories.VentaRepository;

/**
 * VentaService
 */
@Service
public class VentaService {

    @Autowired
    VentaRepository repoVenta;

    public void save(Venta v) {
        repoVenta.save(v);
       
   }
}