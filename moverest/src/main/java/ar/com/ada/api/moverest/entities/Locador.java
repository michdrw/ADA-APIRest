package ar.com.ada.api.moverest.entities;

import java.util.List;

import javax.persistence.*;

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

    public String getContactoEmail() {
        return super.getContactoEmail();
    }

    public String getEdad() {
        return super.getEdad();
    }

    public String getNombre() {
        return super.getNombre();
    }

    public String getTipoDeIdentificacion() {
        return super.getTipoDeIdentificacion();
    }

    public void setContactoEmail(String contactoEmail) {
        super.setContactoEmail(contactoEmail);
    }

    public void setEdad(String edad) {
        super.setEdad(edad);
    }

    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    public void setTipoDeIdentificacion(String tipoDeIdentificacion) {
        super.setTipoDeIdentificacion(tipoDeIdentificacion);
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