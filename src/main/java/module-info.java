module com.example.ratanoid {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires com.opencsv;


    opens com.example.ratanoid to javafx.fxml;
    exports com.example.ratanoid;
    exports Controller;
    opens Controller to javafx.fxml;
    exports Modelo;
    opens Modelo to javafx.fxml;
}