package ar.com.ada.api.moverest.entities;

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

    @OneToMany
    @JoinColumn(name = "inmueble_id", referencedColumnName = "inmueble_id")
    private Inmueble inmueble;


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


    /*public void declararInmueble(Inmueble inmueble) {
        inmueble.setLocador(this);
        inmuebles.add(inmueble);
    }*/

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    
}