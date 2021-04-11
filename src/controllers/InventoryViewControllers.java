package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import models.Inventory;
import models.Vehicle;
import utilities.DBUtility;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class InventoryViewControllers implements Initializable {

    @FXML
    private Label makeLabel;

    @FXML
    private Label modelLabel;

    @FXML
    private Label yearLabel;

    @FXML
    private Label mileageLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private Label carsInInventoryLabel;

    @FXML
    private Label inventoryValueLabel;

    private Inventory inventory;
    private Vehicle vehicle;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inventory = new Inventory();

        try {
            makeLabel.setText(String.format("Make: %d", DBUtility.getMakeFromDB()));
            modelLabel.setText(String.format("Model: %d", DBUtility.getModelFromDB()));
            yearLabel.setText(String.format("Year: %d", String.valueOf( DBUtility.getYearFromDB())));
            mileageLabel.setText(String.format("Mileage: %d",  String.valueOf(DBUtility.getMileageFromDB())));
            priceLabel.setText(String.format("Price: %d", DBUtility.getPriceFromDB()));
            carsInInventoryLabel.setText(String.format("Price: %d",  String.valueOf(DBUtility.getCarsInInventoryLabel())));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}