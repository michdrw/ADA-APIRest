package ar.com.ada.api.moverest.entities;

import javax.persistence.*;

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
    private String tipoDeInmueble;
    private String estado;

    @ManyToOne 
    @JoinColumn(name = "inmobiliaria_id", referencedColumnName = "inmobiliaria_id") 
    private Inmobiliaria inmobiliaria;

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

    public String getTipoDeInmueble() {
        return tipoDeInmueble;
    }

    public void setTipoDeInmueble(String tipoDeInmueble) {
        this.tipoDeInmueble = tipoDeInmueble;
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

    public Inmueble() {
    }

    
    
}