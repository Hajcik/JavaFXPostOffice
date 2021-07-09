package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Pair;
import main.resources.Person;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    // TextFields for Alert Add Addresses
    public TextField NameTf;
    public TextField SurnameTf;

    public ListView listViewPeople;
    public Button aboutBtn;
    public Button addAddressBtn;

    // Dialog "Add Address"
    public void onOpenDialog(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addAddress.fxml"));
        Parent parent = fxmlLoader.load();

        // there should be code for new controller, but i'm sticking with
        // one Controller code for learning

        Scene scene = new Scene(parent, 300, 400);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setTitle("Add Address");
        stage.showAndWait();
    }

    public void loadJSONData()
    {
        // Array of people loaded in to program
        ArrayList<Person> people = new ArrayList<Person>();

        // Load JSON data from .json file
        JSONParser parser = new JSONParser();

        try {
            // Load data into JSONArray
            JSONArray peopleJSON = (JSONArray) parser.parse(new FileReader("src/main/resources/addresses.json"));

            for (Object obj : peopleJSON)
            {
                Person personObj = new Person();
                JSONObject person = (JSONObject) obj;

                String Id = (String) person.get("Id");
                String Name = (String) person.get("Name");
                String Surname = (String) person.get("Surname");
                boolean hasCompany = (boolean) person.get("hasCompany");
                String CompanyName = (String) person.get("CompanyName");
                String Address = (String) person.get("Address");
                String HouseNumber = (String) person.get("HouseNumber");
                String PostalAddress = (String) person.get("PostalAddress");
                String City = (String) person.get("City");

                // Testing if the data is being read from file
                //System.out.println(Id + Name + Surname + hasCompany + CompanyName + Address + HouseNumber + PostalAddress + City);

                // Setting person object to its values
                personObj.setId(Id);
                personObj.setName(Name);
                personObj.setSurname(Surname);
                personObj.setHasCompany(hasCompany);
                personObj.setCompanyName(CompanyName);
                personObj.setAddress(Address);
                personObj.setHouseNumber(HouseNumber);
                personObj.setPostalAddress(PostalAddress);
                personObj.setCity(City);

                // Adding person to people array to use in application
                people.add(personObj);
            }
            // Add items from array list to observable list
            ObservableList<Person> people_obs = FXCollections.observableArrayList(people);

            for(Person person : people_obs)
            {
                // to do: make listview display only name's and address,
                // if has company, display it too
            //    listViewPeople.setItems(people_obs.forEach());

            }

            listViewPeople.setItems(people_obs);

        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public void setAboutBtn()
    {
        Alert about = new Alert(Alert.AlertType.INFORMATION);
        about.setTitle("About");
        about.setHeaderText("About the application");
        about.setContentText("Author: Mariusz Jędrzejewski\n" +
                "About: Application provides help with getting and setting addresses for a" +
                "a small Post Office.");

        about.showAndWait();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        loadJSONData();





    }

}
