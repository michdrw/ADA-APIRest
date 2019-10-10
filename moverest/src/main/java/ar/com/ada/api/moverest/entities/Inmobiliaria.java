package ar.com.ada.api.moverest.entities;

import java.util.List;

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
    private String contactoEmail;
    private List <Inmueble> catalogoInmuebles; 
    private List <Locador> listaLocadores;
    private List <Locatario> listaLocatarios;

    public Inmobiliaria() {
    }

    public Integer getInmobiliariaId() {
        return inmobiliariaId;
    }

    public void setInmobiliariaId(Integer inmobiliariaId) {
        this.inmobiliariaId = inmobiliariaId;
    }

    public String getContactoEmail() {
        return contactoEmail;
    }

    public void setContactoEmail(String contactoEmail) {
        this.contactoEmail = contactoEmail;
    }

    public List<Inmueble> getCatalogoInmuebles() {
        return catalogoInmuebles;
    }

    public void setCatalogoInmuebles(List<Inmueble> catalogoInmuebles) {
        this.catalogoInmuebles = catalogoInmuebles;
    }

    public List<Locador> getListaLocadores() {
        return listaLocadores;
    }

    public void setListaLocadores(List<Locador> listaLocadores) {
        this.listaLocadores = listaLocadores;
    }

    public List<Locatario> getListaLocatarios() {
        return listaLocatarios;
    }

    public void setListaLocatarios(List<Locatario> listaLocatarios) {
        this.listaLocatarios = listaLocatarios;
    }
    
    
}