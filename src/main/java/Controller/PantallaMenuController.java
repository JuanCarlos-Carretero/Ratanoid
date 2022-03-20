package Controller;

import com.example.ratanoid.Ratanoid;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
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
            if(!nombre.equals("")){
                main.startGame(0, 0);
            }else{
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Error");
                a.setHeaderText("0xc0000005");
                a.setContentText("Introduce un nombre!");
                a.show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void skins() {
        nombre = enterName.getText();
        try {
            if(!nombre.equals("")) {
                main.skins();
            }else{
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Error");
                a.setHeaderText("0xc0000005");
                a.setContentText("Introduce un nombre!");
                a.show();
            }
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