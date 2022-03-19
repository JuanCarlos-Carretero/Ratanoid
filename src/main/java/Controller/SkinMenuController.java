package Controller;

import com.example.ratanoid.Ratanoid;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SkinMenuController implements Initializable {
    private Ratanoid main;

    @FXML
    private ImageView fondo;
    @FXML
    private ImageView elegirBarra;
    @FXML
    private ImageView elegirBola;

    public void setMain(Ratanoid mainApp) {
        this.main = mainApp;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fondo.setImage(new Image(Objects.requireNonNull(Ratanoid.class.getResource("drawable/PantallaMenu.png")).toExternalForm()));
        elegirBarra.setImage(new Image(Objects.requireNonNull(Ratanoid.class.getResource("drawable/barraBuena.png")).toExternalForm()));
        elegirBola.setImage(new Image(Objects.requireNonNull(Ratanoid.class.getResource("drawable/bolablanca.png")).toExternalForm()));

    }

    public void volver() {
        try {
            main.pantallaMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startGame() {
        try {
            main.startGame();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
