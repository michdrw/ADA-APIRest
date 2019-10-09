package ar.com.ada.api.moverest.entities;

/**
 * Servicio
 */

public abstract class Servicio {
    private String costo;
    private String nombreServicio;

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public Servicio() {
    }

    public Servicio(String costo, String nombreServicio) {
        this.costo = costo;
        this.nombreServicio = nombreServicio;
    }
}