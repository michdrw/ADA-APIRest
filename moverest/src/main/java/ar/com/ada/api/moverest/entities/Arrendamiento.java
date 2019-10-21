package ar.com.ada.api.moverest.entities;

import java.util.List;

import javax.persistence.*;

/**
 * Arrendamiento
 */
@Entity
@Table(name = "arrendamiento")
public class Arrendamiento extends Servicio {
    @Id
    @Column(name = "arrendamiento_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer arrendamientoId;

    @OneToOne
    @JoinColumn(name = "inmueble_id", referencedColumnName = "inmueble_id")
    private Inmueble inmueble;

    public double getCosto() { 
        return super.getCosto();
    }
 
    public void setCosto(double costo) {
        super.setCosto(costo);
    }

    public Arrendamiento() {
    }

    public Arrendamiento(double costo, Integer arrendamientoId) {
        super(costo);
        this.arrendamientoId = arrendamientoId;
    }

    public Integer getArrendamientoId() {
        return arrendamientoId;
    }

    public void setArrendamientoId(Integer arrendamientoId) {
        this.arrendamientoId = arrendamientoId;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }
    
}