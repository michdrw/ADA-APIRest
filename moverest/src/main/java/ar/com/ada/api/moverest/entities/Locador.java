package ar.com.ada.api.moverest.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Locador
 */
@Entity
@Table(name = "locador")
public class Locador extends Persona {
    @Id
    @Column(name = "locador_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer locadorId;

    @OneToMany(mappedBy = "locador", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Inmueble> inmuebles = new ArrayList<Inmueble>();
    
    public Locador() {
    }
    
    public Locador(Integer locadorId) {
        this.locadorId = locadorId;
    }

    public int getEdad() {
        return super.getEdad();
    }

    public String getNombre() {
        return super.getNombre();
    }

    public String getTipoIdentificacion() {
        return super.getTipoIdentificacion();
    }

    public void setEdad(int edad) {
        super.setEdad(edad);
    }

    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        super.setTipoIdentificacion(tipoIdentificacion);
    }

    public Integer getLocadorId() {
        return locadorId;
    }

    public void setLocadorId(Integer locadorId) {
        this.locadorId = locadorId;
    }

    public List<Inmueble> getInmuebles() {
        return inmuebles;
    }

    public void setInmuebles(List<Inmueble> inmuebles) {
        this.inmuebles = inmuebles;
    }

    public void declararInmueble(Inmueble inmueble) {
        inmueble.setLocador(this);
        inmuebles.add(inmueble);
    }

    
}