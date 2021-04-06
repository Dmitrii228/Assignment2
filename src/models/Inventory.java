package models;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Vehicle> carInventory;

    /**
     * Constructor for Inventory class
     */
    public Inventory(){
        this.carInventory = new ArrayList<>();
    }

    /**
     * adding a car to the array list
     * @param car
     */
    public void addVehicle(Vehicle car){
        carInventory.add(car);
    }
}
