package models;

import java.awt.*;
import java.time.LocalDate;

public class Vehicle {
    private String make;
    private String model;
    private int year;
    private int mileage;
    private double price;



    private int vehicleNum;


    public Vehicle(String make, String model, int year, int mileage, double price,int vehicleNum) {

        setMake(make);
        setModel(model);
        setYear(year);
        setMileage(mileage);
        setPrice(price);
        setVehicleNum(vehicleNum);
    }
    public Vehicle(String make, String model, int year, int mileage, double price) {

        setMake(make);
        setModel(model);
        setYear(year);
        setMileage(mileage);
        setPrice(price);
    }
    public int getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(int vehicleNum) {
        if (vehicleNum>=1){
            this.vehicleNum = vehicleNum;
        }
        else
            throw new IllegalArgumentException("Vehicle number must be greater or equal to 1");

    }
    public String getMake() {
        return make;
    }

    /**
     * make needs to contain only letters and have more than 3 characters
     * @param make
     */
    public void setMake(String make) {
        make = make.trim();
        if (make.length()>=3){
            if (make.matches("[A-Z][a-z]*")){
                this.make = make;
            }
            else
                throw new IllegalArgumentException("Make must start with an upper case letter and only contain alphabetic characters");
        }
        else
            throw new IllegalArgumentException("Make of the vehicle must have at least 3 characters");

    }

    public String getModel() {
        return model;
    }

    /**
     * model needs to contain only letters and have more than 2 characters
     * @param model
     */
    public void setModel(String model) {
        model = model.trim();
        if (model.length()>=2){
                this.model = model;
        }
        else
            throw new IllegalArgumentException("Model of the vehicle must have at least 2 characters");


    }

    public int getYear() {
        return year;
    }

    /**
     * year must be less than 2021
     * @param year
     */
    public void setYear(int year) {
        if (year>LocalDate.now().getYear()){
            throw new IllegalArgumentException("Car cannot be built in the future");
        }
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    /**
     * mileage cannot be equal to 0 or be less than 0
     * @param mileage
     */
    public void setMileage(int mileage) {
        if (mileage>=0&&mileage<=250000){
            this.mileage=mileage;
        }
        else
            throw new IllegalArgumentException(mileage+" is not a valid mileage, should be between 0 and 250,000");
    }

    public double getPrice() {
        return price;
    }

    /**
     * price cannot be equal to 0 or be less than 0
     * @param price
     */
    public void setPrice(double price) {
        if (price<=0){
            throw new IllegalArgumentException("Price cannot be equal or less than 0!");
        }
        this.price = price;
    }

public String toString(){
        return String.format("Make: %s Model:%s Year:%s Price:$%s",make, model, year, price);
}


}
