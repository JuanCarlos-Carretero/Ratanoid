package Pruebas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author wing
 * @date 2012/7/26
 */

public class BrickBlock extends Application {
    /*public static final int WIDTH = 800;
    public static final int HEIGHT = 600;*/
    public static final int WIDTH = 1920;
    public static final int HEIGHT = 1080;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GameScene  root = new GameScene(WIDTH, HEIGHT);
        primaryStage.setTitle("BrickBlock");
        primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
        primaryStage.show();
    }
}