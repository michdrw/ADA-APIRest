package ar.com.ada.api.moverest.entities;

import javax.persistence.*;

/**
 * Alquiler
 */
@Entity
@Table(name = "alquiler")
public class Alquiler extends Servicio {
    @Id
    @Column(name = "alquiler_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer alquilerId;

    public String getCosto() { 
        return super.getCosto();
    }

    public String getNombreServicio() {
        return super.getNombreServicio();
    }

    public void setCosto(String costo) {
        super.setCosto(costo);
    }

    public void setNombreServicio(String nombreServicio) {
        super.setNombreServicio(nombreServicio);
    }

    public Alquiler() {
    }

    public Alquiler(String costo, String nombreServicio, Integer alquilerId) {
        super(costo, nombreServicio);
        this.alquilerId = alquilerId;
    }
    

    
}