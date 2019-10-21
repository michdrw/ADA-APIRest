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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Inmobiliaria
 */
@Entity
@Table(name ="inmobiliaria")
public class Inmobiliaria {
    @Id
    @Column(name = "inmobiliaria_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer inmobiliariaId;
    
    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "inmobiliaria", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Inmueble> inmuebles = new ArrayList<Inmueble>();

    public Inmobiliaria() {
    }


    public Integer getInmobiliariaId() {
        return inmobiliariaId;
    }

    public void setInmobiliariaId(Integer inmobiliariaId) {
        this.inmobiliariaId = inmobiliariaId;
    }

    
    public void agregarInmueble(Inmueble i) {
        i.setInmobiliaria(this);
        inmuebles.add(i);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Inmueble> getInmuebles() {
        return inmuebles;
    }

    public void setInmuebles(List<Inmueble> inmuebles) {
        this.inmuebles = inmuebles;
    }


}