package ar.com.ada.api.moverest.entities;

/**
 * Servicio
 */

public abstract class Servicio {
    private double costo;

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Servicio() {
    }

    public Servicio(double costo) {
        this.costo = costo;
    }
}