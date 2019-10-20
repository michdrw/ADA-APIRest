package ar.com.ada.api.moverest.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Reserva
 */
@Entity
@Table(name ="reserva")
public class Reserva extends Servicio {
    @Id
    @Column(name = "reserva_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reservaId;
    private List <Inmueble> inmueblesReservados;

    @OneToOne
    @JoinColumn(name = "inmueble_id", referencedColumnName = "inmueble_id")
    private Inmueble inmueble;

    @ManyToOne
    @JoinColumn(name = "locatario_id", referencedColumnName = "locatario_id")
    private Locatario locatario;


    public Integer getReservaId() {
        return reservaId;
    }

    public void setReservaId(Integer reservaId) {
        this.reservaId = reservaId;
    }

    public List<Inmueble> getInmueblesReservados() {
        return inmueblesReservados;
    }

    public void setInmueblesReservados(List<Inmueble> inmueblesReservados) {
        this.inmueblesReservados = inmueblesReservados;
    }

    public Reserva() {
    }

    public Reserva(double costo, Integer reservaId) {
        super(costo);
        this.reservaId = reservaId;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public Locatario getLocatario() {
        return locatario;
    }

    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }

}