package models;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Vehicle> carInventory;

    /**
     * Constructor for Inventory class
     */
    public Inventory(ArrayList<Vehicle> inventory){
        this.carInventory = inventory;
    }

    public ArrayList<Vehicle> getCarInventory() {
        return carInventory;
    }

    /**
     * adding a car to the array list
     * @param car
     */
    public void addVehicle(Vehicle car){
        carInventory.add(car);
    }

    public double getInventoryValue() {
        double totalPrice = 0;
        for (Vehicle car : carInventory) {
            totalPrice += car.getPrice();
        }
        return totalPrice;
    }
    public int getAmountOfCars(){
        return carInventory.size();
    }
}
