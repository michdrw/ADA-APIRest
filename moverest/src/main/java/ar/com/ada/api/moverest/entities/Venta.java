package ar.com.ada.api.moverest.entities;

import javax.persistence.*;

/**
 * Venta
 */
@Entity
@Table(name ="venta")
public class Venta extends Servicio {
    @Id
    @Column(name = "venta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ventaId;
    
}