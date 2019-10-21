package ar.com.ada.api.moverest.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * Locador
 */
@Entity
@Table(name = "locador")
public class Locador {
    @Id
    @Column(name = "locador_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer locadorId;
    private String nombre;
    private int edad;
    @Column(name = "tipo_identificacion")
    private String tipoIdentificacion;
    @Column(name = "nro_identificacion")
    private int nroIdentificacion;
    private String juricidad;

    @OneToMany(mappedBy = "locador", cascade = CascadeType.ALL)
    private List<Inmueble> inmuebles = new ArrayList<Inmueble>();

    @OneToOne
    @JoinColumn(name = "inmobiliaria_id", referencedColumnName = "inmobiliaria_id")
    private Inmobiliaria inmobiliaria;


    public Locador() {
    }
    
    public Locador(Integer locadorId) {
        this.locadorId = locadorId;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public int getNroIdentificacion() {
        return nroIdentificacion;
    }

    public void setNroIdentificacion(int nroIdentificacion) {
        this.nroIdentificacion = nroIdentificacion;
    }

    public String getJuricidad() {
        return juricidad;
    }

    public void setJuricidad(String juricidad) {
        this.juricidad = juricidad;
    }

    public Inmobiliaria getInmobiliaria() {
        return inmobiliaria;
    }

    public void setInmobiliaria(Inmobiliaria inmobiliaria) {
        this.inmobiliaria = inmobiliaria;
    }
    
}