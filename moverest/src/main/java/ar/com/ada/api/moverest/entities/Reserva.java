package ar.com.ada.api.moverest.entities;

import javax.persistence.*;

/**
 * Reserva
 */
@Entity
@Table(name ="reserva")
public class Reserva extends Servicio {
    @Id
    @Column(name = "reserva_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reservaId;
    
}