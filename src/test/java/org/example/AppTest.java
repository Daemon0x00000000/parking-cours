package org.example;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void parkingPlein_AutoriseEntreesPuisEntrer_RefuserEntree() {
        //Arranger
        Parking parking = new Parking(1);
        Vehicule vehicule1 = new Vehicule("AA-123-AA");
        Vehicule vehicule2 = new Vehicule("BB-123-BB");
        parking.autoriserVehicule(vehicule1);
        parking.autoriserVehicule(vehicule2);
        parking.entrer(vehicule1);
        //Agir
        parking.entrer(vehicule2);

        //Assert
        assertTrue(parking.estPlein());
    }

    @Test
    public void vehiculesAutorisesVide_ajouterMemePlaqueAutorisee_VehiculePasDansLaListe() {
        //Arranger
        Parking parking = new Parking(10);
        Vehicule vehicule = new Vehicule("AA-123-AA");

        //Agir
        parking.autoriserVehicule(vehicule);

        //Assert
        assertFalse(parking.estAutorise(new Vehicule("AA-123-AA")));

    }

    @Test
    public void vehiculesAutorisesVide_ajouterVehiculeAutorise_VehiculePasDansLaListe() {
        //Arranger
        Parking parking = new Parking(10);
        Vehicule vehicule = new Vehicule("AA-123-AA");

        //Agir
        parking.autoriserVehicule(vehicule);

        //Assert
        assertFalse(parking.estAutorise(new Vehicule("BB-123-BB")));

    }

    @Test
    public void vehiculesAutorisesVide_ajouterVehiculeAutorise_VehiculeDansLaListe() {
        //Arranger
        Parking parking = new Parking(10);
        Vehicule vehicule = new Vehicule("AA-123-AA");
        //Agir
        parking.autoriserVehicule(vehicule);
        //Assert
        assertTrue(parking.estAutorise(vehicule));

    }

}
