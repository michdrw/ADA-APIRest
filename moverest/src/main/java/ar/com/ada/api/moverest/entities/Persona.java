package ar.com.ada.api.moverest.entities;

import javax.persistence.*;

/**
 * Persona
 */
@Entity
@Table(name ="persona")
public class Persona {
    @Id
    @Column(name = "persona_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer personaId;
    private String nombre;
    private int edad;
    private String tipoIdentificacion;
    private int nroIdentificacion;
    private String contactoEmail;

    @OneToOne( mappedBy = "persona", cascade = CascadeType.ALL)
    private Usuario usuario;

    public Integer getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Integer personaId) {
        this.personaId = personaId;
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

    public String getContactoEmail() {
        return contactoEmail;
    }

    public void setContactoEmail(String contactoEmail) {
        this.contactoEmail = contactoEmail;
    }

    public Persona() {
    }

    public int getNroIdentificacion() {
        return nroIdentificacion;
    }

    public void setNroIdentificacion(int nroIdentificacion) {
        this.nroIdentificacion = nroIdentificacion;
    }
    
    
}