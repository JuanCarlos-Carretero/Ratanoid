package Controller;

import com.example.ratanoid.Ratanoid;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
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

    @FXML
    private TextField enterName;

    public static String nombre;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fondo.setImage(new Image(Ratanoid.class.getResource("drawable/PantallaMenu.png").toExternalForm()));
    }

    public void startGame() {
        nombre = enterName.getText();
        try {
            main.startGame(0, 0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void skins() {
        nombre = enterName.getText();
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