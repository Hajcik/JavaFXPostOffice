package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public ListView listViewPeople;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }

    private void populateJSONData()
    {
        // Populate ListView with people from JSON data in ArrayList
        listViewPeople.getItems();
    }
}
