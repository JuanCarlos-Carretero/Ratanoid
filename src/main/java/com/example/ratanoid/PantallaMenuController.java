package com.example.ratanoid;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class PantallaMenuController implements Initializable {

    @FXML
    private ImageView fondo;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fondo.setImage(new Image(Ratanoid.class.getResource("drawable/PantallaMenu.png").toExternalForm()));
    }
}