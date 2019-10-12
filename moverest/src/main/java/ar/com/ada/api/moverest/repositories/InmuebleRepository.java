package ar.com.ada.api.moverest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ada.api.moverest.entities.Inmueble;

/**
 * InmuebleRepository
 */
public interface InmuebleRepository extends JpaRepository<Inmueble, Integer>{

    
}