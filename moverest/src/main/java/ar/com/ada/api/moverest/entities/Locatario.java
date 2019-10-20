package ar.com.ada.api.moverest.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

    @OneToMany (mappedBy = "locatario", cascade = CascadeType.ALL)
    private Reserva reserva;

    @OneToOne( mappedBy = "locatario", cascade = CascadeType.ALL)
    private Usuario usuario;

    public Locatario() {
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