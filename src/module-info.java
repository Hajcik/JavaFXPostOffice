module JavaFXPostOffice {
    requires javafx.fxml;
    requires javafx.controls;
    requires json.simple;

    opens sample;

    exports sample;
}