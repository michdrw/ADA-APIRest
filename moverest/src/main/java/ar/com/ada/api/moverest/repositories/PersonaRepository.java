package ar.com.ada.api.moverest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ada.api.moverest.entities.Persona;

/**
 * PersonaRepository
 */
public interface PersonaRepository extends JpaRepository<Persona, Integer>{

    
}
