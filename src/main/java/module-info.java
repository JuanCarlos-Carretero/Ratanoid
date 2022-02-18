module com.example.ratanoid {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ratanoid to javafx.fxml;
    exports com.example.ratanoid;
    exports Pruebas;
}