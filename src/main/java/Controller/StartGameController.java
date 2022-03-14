package Controller;

import Modelo.WindowsSetting;
import Niveles.Lvl1;
import com.example.ratanoid.Ratanoid;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class
StartGameController implements Initializable {

    Ratanoid main;
    private Scene scene;
    private GraphicsContext gc;
    private Lvl1 nivel;
    private Image fons;

    @FXML
    private ImageView imvBgd1;

    @FXML
    Canvas mainCanvas;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(url);

        fons = new Image(Ratanoid.class.getResource("drawable/PantallaJuego.png").toExternalForm());
        imvBgd1.setImage(fons);

        mainCanvas.setHeight(WindowsSetting.HEIGHT);
        mainCanvas.setWidth(WindowsSetting.WIDTH);
    }

    public void setScene(Scene sc) {
        scene = sc;
        gc = mainCanvas.getGraphicsContext2D();
        nivel = new Lvl1(gc, scene);
    }

    public void setMain(Ratanoid mainApp) {
        this.main = mainApp;
    }
}