package ar.com.ada.api.moverest.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

    @ManyToOne
    @JoinColumn(name = "locatario_id", referencedColumnName = "locatario_id")
    private Locatario locatario;

    @OneToOne(mappedBy = "reserva", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Inmueble inmueble;


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

    public Locatario getLocatario() {
        return locatario;
    }

    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }
    
}