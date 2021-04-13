package utilities;

import models.Vehicle;

import java.sql.*;
import java.util.ArrayList;

public class DBUtility {
    private static String user = "car";
    private static String password = "car";
    private static String connString = "jdbc:mysql://localhost:3306/Assignment2";

    /**
     * adding cars to the database
     * @param newVehicle
     * @return
     * @throws SQLException
     */
    public static int addCarIntoDB(Vehicle newVehicle) throws SQLException {

        int vehicleNum = -1;
        //connect to the DB
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{

            conn = DriverManager.getConnection(connString,user,password);

            // inserts information in the sql database
            statement = conn.prepareStatement("INSERT INTO cars (make, model, year, mileage,price) VALUES " +
                    "(?,?,?,?,?)", new String[]{"vehicleNum"});


            statement.setString(1, newVehicle.getMake());
            statement.setString(2, newVehicle.getModel());
            statement.setInt(3, newVehicle.getYear());
            statement.setInt(4, newVehicle.getMileage());
            statement.setDouble(5, newVehicle.getPrice());

            statement.executeUpdate();


            resultSet = statement.getGeneratedKeys();

            while (resultSet.next())
                vehicleNum = resultSet.getInt(1);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            if (conn != null)
                conn.close();
            if (statement != null)
                statement.close();
            if (resultSet != null)
                resultSet.close();
            return vehicleNum;
        }
    }

    /**
     * gets the cars from the database
     * @return
     * @throws SQLException
     */
    public static ArrayList<Vehicle> getVehiclesFromDB() throws SQLException {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        //connecting to the DB
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            //connect to the Database
            conn = DriverManager.getConnection(connString, user, password);

            statement = conn.createStatement();

            //run the query on the DB
            resultSet = statement.executeQuery("SELECT * FROM cars");

            //loop over the resultset and create Vehicle objects
            while (resultSet.next()){
                String make = resultSet.getString("make");
                Vehicle newVehicle = new Vehicle(resultSet.getString("make"),
                        resultSet.getString("model"),
                        resultSet.getInt("year"),
                        resultSet.getInt("mileage"),
                        resultSet.getDouble("price"));
                vehicles.add(newVehicle);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            if (conn != null)
                conn.close();
            if (statement != null)
                statement.close();
            if (resultSet != null)
                resultSet.close();
        }
        return vehicles;
    }

}
