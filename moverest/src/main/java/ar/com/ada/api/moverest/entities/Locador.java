package ar.com.ada.api.moverest.entities;

import javax.persistence.*;

/**
 * Locador
 */
@Entity
@Table(name ="locador")
public class Locador extends Persona {
    @Id
    @Column(name = "locador_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer locadorId;
    
}