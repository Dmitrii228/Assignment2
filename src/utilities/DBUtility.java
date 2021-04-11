package utilities;

import java.sql.*;

public class DBUtility {
    private static String user = "root";
    private static String password = "root";
    private static String connString = "jdbc:mysql://localhost:3306/Assignment2";
    /**
     * get the make as a string from DB
     * @return
     * @throws SQLException
     */
    public static String getMakeFromDB() throws SQLException {
        //connect to the DB
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String make = "";
        try{
            //connect to the Database
            conn = DriverManager.getConnection(connString, user, password);

            statement = conn.createStatement();

            //run the query on the DB
            resultSet = statement.executeQuery("SELECT make FROM cars");

          make = resultSet.getString("make");
        } catch (SQLException e)
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
        return make;
    }

    /**
     * get the model as a string from DB
     * @return
     * @throws SQLException
     */
    public static String getModelFromDB() throws SQLException {
        //connect to the DB
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String model = "";
        try{
            //connect to the Database
            conn = DriverManager.getConnection(connString, user, password);

            statement = conn.createStatement();

            //run the query on the DB
            resultSet = statement.executeQuery("SELECT model FROM cars");

            model = resultSet.getString("model");
        } catch (SQLException e)
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
        return model;
    }
    /**
     * get the year as a int from DB
     * @return
     * @throws SQLException
     */
    public static int getYearFromDB() throws SQLException {
        //connect to the DB
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        int year = 0;
        try{
            //connect to the Database
            conn = DriverManager.getConnection(connString, user, password);

            statement = conn.createStatement();

            //run the query on the DB
            resultSet = statement.executeQuery("SELECT year FROM cars");

            year = resultSet.getInt("year");
        } catch (SQLException e)
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
        return year;
    }
    /**
     * get the mileage as a int from DB
     * @return
     * @throws SQLException
     */
    public static int getMileageFromDB() throws SQLException {
        //connect to the DB
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        int mileage = 0;
        try{
            //connect to the Database
            conn = DriverManager.getConnection(connString, user, password);

            statement = conn.createStatement();

            //run the query on the DB
            resultSet = statement.executeQuery("SELECT mileage FROM cars");

            mileage = resultSet.getInt("mileage");
        } catch (SQLException e)
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
        return mileage;
    }
    /**
     * get the price as a double from DB
     * @return
     * @throws SQLException
     */
    public static double getPriceFromDB() throws SQLException {
        //connect to the DB
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        double price = 0;
        try{
            //connect to the Database
            conn = DriverManager.getConnection(connString, user, password);

            statement = conn.createStatement();

            //run the query on the DB
            resultSet = statement.executeQuery("SELECT price FROM cars");

            price = resultSet.getDouble("price");
        } catch (SQLException e)
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
        return price;
    }
    /**
     * get the amount of cars in the inventory as a int from DB
     * @return
     * @throws SQLException
     */
    public static int getCarsInInventoryLabel() throws SQLException {
        //connect to the DB
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        int amountOFCars = 0;
        try{
            //connect to the Database
            conn = DriverManager.getConnection(connString, user, password);

            statement = conn.createStatement();

            //run the query on the DB
            resultSet = statement.executeQuery("SELECT COUNT(*) FROM cars;");

            amountOFCars = resultSet.getInt(1);
        } catch (SQLException e)
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
        return amountOFCars;
    }
}
