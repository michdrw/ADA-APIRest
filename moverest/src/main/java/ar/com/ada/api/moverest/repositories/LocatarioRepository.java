package ar.com.ada.api.moverest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ada.api.moverest.entities.Locatario;

/**
 * LocatarioRepository
 */
public interface LocatarioRepository extends JpaRepository<Locatario, Integer> {

    
}