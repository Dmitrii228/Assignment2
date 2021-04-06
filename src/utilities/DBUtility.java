package utilities;

import models.Vehicle;

import java.util.ArrayList;

public class DBUtility {
    public static ArrayList<Vehicle> getStudentsFromDB()
    {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("Toyota","Camry",2012,72000,14000));
        vehicles.add(new Vehicle("Lexus","IS 350",2019,24800,30600));
        vehicles.add(new Vehicle("BMW","3 Series",2009,140670,9300));
        return vehicles;
    }
}
