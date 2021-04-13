package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import models.Vehicle;
import utilities.DBUtility;
import utilities.SceneChanger;

import java.io.IOException;
import java.sql.SQLException;

public class CreateCarViewControllers {

    @FXML
    private TextField makeTextField;

    @FXML
    private TextField modelTextField;

    @FXML
    private TextField yearTextField;

    @FXML
    private TextField mileageTextField;

    @FXML
    private TextField priceTextField;

    /**
     * Retrieves information from the user and add it to the database
     */
    @FXML
    void addCar() {
        if (fieldsAreNotEmpty()) {
            try {

                Vehicle newVehicle = new Vehicle(makeTextField.getText(),
                        modelTextField.getText(),
                        Integer.valueOf(yearTextField.anchorProperty().getValue()),
                        Integer.valueOf(mileageTextField.getText()),
                        Integer.valueOf(priceTextField.getText()));
                int vehicleNum = DBUtility.addCarIntoDB(newVehicle);
                newVehicle.setVehicleNum(vehicleNum);
            } catch (Exception e) {
                e.printStackTrace();
                throw new IllegalArgumentException("Something went wrong!");
            }
        }
    }

    /**
     * checks if the field are empty
     * @return
     */
    private boolean fieldsAreNotEmpty() {
        String errMsg = "The following fields are empty: ";
        if (makeTextField.getText().isEmpty())
            errMsg += "make, ";

        if (modelTextField.getText().isEmpty())
            errMsg += "model, ";

        if (yearTextField.getText().isEmpty())
            errMsg += "year, ";

        if (mileageTextField.getText().isEmpty())
            errMsg += "mileage, ";

        if (priceTextField.getText().isEmpty())
            errMsg += "price, ";

        if (errMsg.equals("The following fields are empty: "))
            return true;

        return false;
    }

    /**
     * if the button pressed return to the inventory page
     * @param event
     * @throws IOException
     */
    @FXML
    void returnToInventory(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "../views/inventoryView.fxml", "Inventory");
    }
}