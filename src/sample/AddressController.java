package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddressController implements Initializable {

    public TextField idTf;
    public TextField nameTf;
    public TextField surnameTf;
    public TextField addressTf;
    public TextField houseNumberTf;
    public TextField postalAddressTf;
    public TextField cityTf;
    public CheckBox haveCompanyCheckBox;
    public TextField companyTf;
    public Label companyLabel;
    public Button addBtn;
    public Button closeBtn;

    @FXML
    public void btnCancel(ActionEvent event) {
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void btnAdd(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Error in adding data");

            if (idTf.getText().trim().isEmpty()) {
                alert.setContentText("There is an error in ID field.");
            } else if (nameTf.getText().trim().isEmpty()) {
                alert.setContentText("There is an error in Name field.");
            } else if (surnameTf.getText().trim().isEmpty()) {
                alert.setContentText("There is an error in Surname field.");
            } else if (addressTf.getText().trim().isEmpty()) {
                alert.setContentText("There is an error in Address field.");
            } else if (houseNumberTf.getText().trim().isEmpty()) {
                alert.setContentText("There is an error in House Number field.");
            } else if (postalAddressTf.getText().trim().isEmpty()) {
                alert.setContentText("There is an error in Postal Address field.");
            } else if (cityTf.getText().trim().isEmpty()) {
                alert.setContentText("There is an error in City field.");
            } else if (haveCompanyCheckBox.isSelected() && companyTf.getText().trim().isEmpty()) {
                alert.setContentText("There is an error in Company field.");
            }

            else {

                alert.setHeaderText("Adding data succesful.");

            }
                alert.showAndWait();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        // Visibility of Company text field and its label
        companyLabel.visibleProperty().bind(haveCompanyCheckBox.selectedProperty());
        companyTf.visibleProperty().bind(haveCompanyCheckBox.selectedProperty());

    }
}
