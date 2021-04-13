package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import models.Inventory;
import models.Vehicle;
import utilities.DBUtility;
import utilities.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class InventoryViewControllers implements Initializable {



    @FXML
    private Label carsInInventoryLabel;

    @FXML
    private Label inventoryValueLabel;

    @FXML
    private ListView<Vehicle> vehicleListView;

    private Inventory inventory;

    /**
     * gets the information from db and shows it on the screen
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            inventory = new Inventory(DBUtility.getVehiclesFromDB());
            vehicleListView.getItems().addAll(inventory.getCarInventory());
            inventoryValueLabel.setText(String.format ("Cars in inventory value: $%.2f",inventory.getInventoryValue()));
            carsInInventoryLabel.setText(String.format("Number of cars: %d", inventory.getAmountOfCars()));
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    /**
     * Opens a new stage
     * @param event
     */
    public void addCar(ActionEvent event) {
        try {
            SceneChanger.changeScenes(event,"../views/createCarView.fxml","Create new car" );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * sells car
     * @param event
     * @throws SQLException
     */
    @FXML
    void sellCar(ActionEvent event) throws SQLException {
        int selectedIdx = vehicleListView.getSelectionModel().getSelectedIndex();
        Vehicle vehicle = vehicleListView.getItems().remove(selectedIdx);
    }
}