package com.example.ratanoid;

import Controller.PantallaMenuController;
import Controller.SkinMenuController;
import Controller.StartGameController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Ratanoid extends Application {

    private Stage primaryStage;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;
        primaryStage.setTitle("Ratanoid");

        pantallaMenu();
    }

    public void pantallaMenu() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Ratanoid.class.getResource("PantallaMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 600);
        PantallaMenuController controller = fxmlLoader.getController();
        controller.setMain(this);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void startGame() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Ratanoid.class.getResource("startGame.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 600);
        StartGameController controllerStart = fxmlLoader.getController();
        controllerStart.setMain(this);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void skins() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Ratanoid.class.getResource("skinMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 600);
        SkinMenuController controllerSkin = fxmlLoader.getController();
        controllerSkin.setMain(this);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}