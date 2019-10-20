package ar.com.ada.api.moverest.entities;

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
 * Inmueble
 */
@Entity
@Table(name ="inmueble")
public class Inmueble {
    @Id
    @Column(name = "inmueble_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer inmuebleId;
    private String direccion;
    private String ubicacion;
    private int ambientes;
    private String amenities;
    private String instalaciones;
    private double superficie;
    private double precio;
    private String moneda;
    @Column(name = "tipo_inmueble")
    private String tipoInmueble;
    private String estado;

    @OneToOne(mappedBy = "inmueble", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Reserva reserva;

    @OneToOne(mappedBy = "inmueble", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Arrendamiento arrendamiento;

    @OneToOne(mappedBy = "inmueble", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Venta venta;

    @OneToOne(mappedBy = "inmueble", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Locador locador;

    @ManyToOne
    @JoinColumn(name = "inmobiliaria_id", referencedColumnName = "inmobiliaria_id")
    private Inmobiliaria inmobiliaria;


    public Inmueble() {
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getAmbientes() {
        return ambientes;
    }

    public void setAmbientes(int ambientes) {
        this.ambientes = ambientes;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public String getInstalaciones() {
        return instalaciones;
    }

    public void setInstalaciones(String instalaciones) {
        this.instalaciones = instalaciones;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getTipoInmueble() {
        return tipoInmueble;
    }

    public void setTipoInmueble(String tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getInmuebleId() {
        return inmuebleId;
    }

    public void setInmuebleId(Integer inmuebleId) {
        this.inmuebleId = inmuebleId;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Arrendamiento getArrendamiento() {
        return arrendamiento;
    }

    public void setArrendamiento(Arrendamiento arrendamiento) {
        this.arrendamiento = arrendamiento;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Locador getLocador() {
        return locador;
    }

    public void setLocador(Locador locador) {
        this.locador = locador;
    }

    public Inmobiliaria getInmobiliaria() {
        return inmobiliaria;
    }

    public void setInmobiliaria(Inmobiliaria inmobiliaria) {
        this.inmobiliaria = inmobiliaria;
    }

    
}