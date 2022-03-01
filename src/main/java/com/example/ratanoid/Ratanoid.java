package com.example.ratanoid;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Ratanoid extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Ratanoid.class.getResource("PantallaMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Ratanoid");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void amigo(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Ratanoid.class.getResource("startGame.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Ratanoid");
        stage.setScene(scene);
        stage.show();
    }
}