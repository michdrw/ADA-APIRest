package ar.com.ada.api.moverest.entities;

import javax.persistence.*;

/**
 * Inmobiliaria
 */
@Entity
@Table(name ="inmobiliaria")
public class Inmobiliaria {
    @Id
    @Column(name = "inmobiliaria_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer inmobiliariaId;
    
}