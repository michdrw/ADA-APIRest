package ar.com.ada.api.moverest.entities;

import java.util.List;

import javax.persistence.*;

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

    public Reserva(String costo, Integer reservaId) {
        super(costo);
        this.reservaId = reservaId;
    }
    
}