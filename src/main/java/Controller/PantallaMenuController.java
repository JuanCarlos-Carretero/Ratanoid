package Controller;

import com.example.ratanoid.Ratanoid;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PantallaMenuController implements Initializable {
    private Ratanoid main;

    @FXML
    private ImageView fondo;

    @FXML
    private ImageView logo;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fondo.setImage(new Image(Ratanoid.class.getResource("drawable/PantallaMenu.png").toExternalForm()));
    }

    public void startGame() {
        try {
            main.startGame();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void skins() {
        try {
            main.skins();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exit() {
        System.exit(0);
    }

    public void setMain(Ratanoid mainApp) {
        this.main = mainApp;
    }
}