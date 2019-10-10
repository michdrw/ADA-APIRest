package ar.com.ada.api.moverest.entities;

import java.util.List;

import javax.persistence.*;

/**
 * Venta
 */
@Entity
@Table(name = "venta")
public class Venta extends Servicio {
    @Id
    @Column(name = "venta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ventaId;
    private List <Inmueble> inmueblesDeVenta;

    public Venta(String costo, Integer ventaId) {
        super(costo);
        this.ventaId = ventaId;
    }

    public Venta() {
    }

    public Integer getVentaId() {
        return ventaId;
    }

    public void setVentaId(Integer ventaId) {
        this.ventaId = ventaId;
    }

    @Override
    public String getCosto() {
        return super.getCosto();
    }

    @Override
    public void setCosto(String costo) {
        super.setCosto(costo);
    }

    public List<Inmueble> getInmueblesDeVenta() {
        return inmueblesDeVenta;
    }

    public void setInmueblesDeVenta(List<Inmueble> inmueblesDeVenta) {
        this.inmueblesDeVenta = inmueblesDeVenta;
    }
    
}