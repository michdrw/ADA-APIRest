package ar.com.ada.api.moverest.entities;

import javax.persistence.*;

/**
 * Persona
 */
public abstract class Persona {
    
    private String nombre;
    private int edad;
    @Column(name = "tipo_identificacion")
    private String tipoIdentificacion;
    @Column(name = "nro_identificacion")
    private int nroIdentificacion;
    private Usuario usario; 


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

    public Persona() {
    }

    public int getNroIdentificacion() {
        return nroIdentificacion;
    }

    public void setNroIdentificacion(int nroIdentificacion) {
        this.nroIdentificacion = nroIdentificacion;
    }

    public Usuario getUsario() {
        return usario;
    }

    public void setUsario(Usuario usario) {
        this.usario = usario;
    }

}