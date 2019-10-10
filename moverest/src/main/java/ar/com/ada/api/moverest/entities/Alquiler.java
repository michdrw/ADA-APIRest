package ar.com.ada.api.moverest.entities;

import java.util.List;

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
    private List <Inmueble> inmueblesDeAlquiler;

    public String getCosto() { 
        return super.getCosto();
    }
 
    public void setCosto(String costo) {
        super.setCosto(costo);
    }

    public Alquiler() {
    }

    public Alquiler(String costo, Integer alquilerId) {
        super(costo);
        this.alquilerId = alquilerId;
    }

    public Integer getAlquilerId() {
        return alquilerId;
    }

    public void setAlquilerId(Integer alquilerId) {
        this.alquilerId = alquilerId;
    }

    public List<Inmueble> getInmueblesDeAlquiler() {
        return inmueblesDeAlquiler;
    }

    public void setInmueblesDeAlquiler(List<Inmueble> inmueblesDeAlquiler) {
        this.inmueblesDeAlquiler = inmueblesDeAlquiler;
    }
    
}