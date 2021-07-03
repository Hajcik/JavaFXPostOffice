package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.resources.Person;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
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

                //System.out.println(Id + Name + Surname + hasCompany + CompanyName + Address + HouseNumber + PostalAddress + City);



                // Setting person object to its values
                personObj.setId(Id);
                personObj.setId(Name);
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
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
        launch(args);
    }
}
