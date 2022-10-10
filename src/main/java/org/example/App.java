package org.example;

public class App {
    
    public static void main(String[] args) {
        Vehicule clio = new Vehicule("AA-123-BC");
        Parking parking = new Parking(10);
        parking.autoriserVehicule(clio);
        parking.entrer(clio);
        System.out.println(parking);

    }
    
}
