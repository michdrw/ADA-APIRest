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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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

    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "locatario", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Reserva> reservas = new ArrayList<Reserva>();

    public Locatario() {
    }

    public Integer getLocatarioId() {
        return locatarioId;
    }

    public void setLocatarioId(Integer locatarioId) {
        this.locatarioId = locatarioId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    
}