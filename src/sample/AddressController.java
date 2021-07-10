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
import main.resources.Person;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
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
        JSONParser parser = new JSONParser();
        Person person = new Person();

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

                try {
                    JSONArray peopleJSON = (JSONArray) parser.parse(new FileReader("src/main/resources/addresses.json"));

                        alert.setHeaderText("Address adding successful");
                        person.setId(idTf.getText());
                        person.setName(nameTf.getText());
                        person.setSurname(surnameTf.getText());
                        person.setAddress(addressTf.getText());
                        person.setHouseNumber(houseNumberTf.getText());
                        person.setPostalAddress(postalAddressTf.getText());
                        person.setCity(cityTf.getText());
                        person.setHasCompany(haveCompanyCheckBox.isSelected());
                        person.setCompanyName(companyTf.getText());
                        alert.setHeaderText("Adding data succesful.");

                        peopleJSON.add(person);

                        FileWriter file = new FileWriter("src/main/resources/addresses.json");
                        file.write(peopleJSON.toJSONString());
                        file.flush();
                        file.close();

                        System.out.println(person.toString());


                } catch (Exception e) {
                    e.printStackTrace();
                }

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
