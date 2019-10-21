package ar.com.ada.api.moverest.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ada.api.moverest.entities.Usuario;

/**
 * UsuarioRepository
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findById(Integer id);
}