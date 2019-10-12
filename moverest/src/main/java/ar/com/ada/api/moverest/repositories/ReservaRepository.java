package ar.com.ada.api.moverest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ada.api.moverest.entities.Reserva;

/**
 * ReservaRepository
 */
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    
}