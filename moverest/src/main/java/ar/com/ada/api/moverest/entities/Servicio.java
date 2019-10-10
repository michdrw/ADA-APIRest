package ar.com.ada.api.moverest.entities;

/**
 * Servicio
 */

public abstract class Servicio {
    private String costo;

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public Servicio() {
    }

    public Servicio(String costo) {
        this.costo = costo;
    }
}