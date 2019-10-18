package ar.com.ada.api.moverest.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private List <Inmueble> propiedades;

    
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

    public List<Inmueble> getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(List<Inmueble> propiedades) {
        this.propiedades = propiedades;
    }

    
}