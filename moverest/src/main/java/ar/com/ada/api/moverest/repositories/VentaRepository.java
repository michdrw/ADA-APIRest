package ar.com.ada.api.moverest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ada.api.moverest.entities.Venta;

/**
 * VentaRepository
 */
public interface VentaRepository extends JpaRepository<Venta, Integer> {

    
}