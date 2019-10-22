package ar.com.ada.api.moverest.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

    @OneToOne
    @JoinColumn(name = "locatario_id", referencedColumnName = "locatario_id")
    private Locatario locatario;

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

    public Locatario getLocatario() {
        return locatario;
    }

    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }
    
}