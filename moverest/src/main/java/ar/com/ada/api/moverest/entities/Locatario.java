package ar.com.ada.api.moverest.entities;

import java.util.List;

import javax.persistence.*;

/**
 * Locatario
 */
@Entity
@Table(name ="locatario")
public class Locatario extends Persona {
    @Id
    @Column(name = "locatario_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer locatarioId;
    private List <Reserva> inmueblesReservados;
    private List <Inmueble> inmueblesVendidosOAlquilados;

    public Locatario() {
    }

    public Locatario(Integer locatarioId) {
        this.locatarioId = locatarioId;
    }
    
    public String getContactoEmail() {
        return super.getContactoEmail();
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

    public void setContactoEmail(String contactoEmail) {
        super.setContactoEmail(contactoEmail);
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

    public Integer getLocatarioId() {
        return locatarioId;
    }

    public void setLocatarioId(Integer locatarioId) {
        this.locatarioId = locatarioId;
    }

    public List<Reserva> getInmueblesReservados() {
        return inmueblesReservados;
    }

    public void setInmueblesReservados(List<Reserva> inmueblesReservados) {
        this.inmueblesReservados = inmueblesReservados;
    }

    public List<Inmueble> getInmueblesVendidosOAlquilados() {
        return inmueblesVendidosOAlquilados;
    }

    public void setInmueblesVendidosOAlquilados(List<Inmueble> inmueblesVendidosOAlquilados) {
        this.inmueblesVendidosOAlquilados = inmueblesVendidosOAlquilados;
    }

    
}