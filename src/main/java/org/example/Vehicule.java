package org.example;

public class Vehicule {
    private String immatriculation;

    public Vehicule(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String toString() {
        return "Vehicule " + immatriculation;
    }
}
