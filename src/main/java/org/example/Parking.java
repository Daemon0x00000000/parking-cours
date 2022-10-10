package org.example;

import java.util.ArrayList;
import java.util.List;


public class Parking {

    private int capacite;
    private List<Vehicule> vehicules;
    private List<Vehicule> vehiculesAutorisees;

    public Parking(int capacite) {
        this.capacite = capacite;
        this.vehicules = new ArrayList<Vehicule>();
        this.vehiculesAutorisees = new ArrayList<Vehicule>();
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public List<Vehicule> getVehicules() {
        return vehicules;
    }


    /* estAutorise */
    public boolean estAutorise(Vehicule vehiculeAVerifier) {
        return vehiculesAutorisees.contains(vehiculeAVerifier);
    }

    public void entrer(Vehicule vehicule) {
        if (estAutorise(vehicule) && !estPlein()) {
            vehicules.add(vehicule);
        }

    }

    public void sortir(Vehicule vehicule) {
        if (vehicules.contains(vehicule)) {
            vehicules.remove(vehicule);
        }
    }

    public boolean estPlein() {
        return vehicules.size() == capacite;
    }

    public int nombreDeVehicules() {
        return vehicules.size();
    }

    public boolean plaqueImmatriculationAutorisee(String plaqueImmatriculationAVerifier) {
        for (Vehicule vehicule : vehiculesAutorisees) {
            if (vehicule.getImmatriculation().equals(plaqueImmatriculationAVerifier)) {
                return true;
            }
        }
        return false;
    }

    public void autoriserVehicule(Vehicule vehiculeAAutoriser) {
        if (!estAutorise(vehiculeAAutoriser) && !plaqueImmatriculationAutorisee(vehiculeAAutoriser.getImmatriculation())) {
            vehiculesAutorisees.add(vehiculeAAutoriser);
        }
    }

    public void nonAutoriserVehicule(Vehicule vehiculeASupprimer) {
        if (estAutorise(vehiculeASupprimer)) {
            vehiculesAutorisees.remove(vehiculeASupprimer);
        }
    }

    public boolean estSurParking(Vehicule vehicule) {
        return vehicules.contains(vehicule);
    }

    public void afficherVehiculesParking() {
        for (Vehicule vehicule : vehicules) {
            System.out.println(vehicule);
        }
    }

    public void afficherVehiculesAutorises() {
        for (Vehicule vehicule : vehiculesAutorisees) {
            System.out.println(vehicule);
        }
    }


    public double tauxRemplissage() {
        return (double) nombreDeVehicules() / capacite * 100;
    }

    public String toString() {
        return "Parking capacite : " + capacite + " \nVehicules autorises : " + vehiculesAutorisees + " \nVehicules parking : " + vehicules + " \nTaux de remplissage : " + tauxRemplissage() + "%";
    }



}
