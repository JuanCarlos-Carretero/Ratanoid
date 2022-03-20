package Controller;

import Modelo.WindowsSetting;
import Niveles.Niveles;
import com.example.ratanoid.Ratanoid;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class StartGameController implements Initializable {

    Ratanoid main;
    private Scene scene;
    private GraphicsContext gc;
    private Niveles nivel;
    private Image fons;

    int barraSkin;
    int pelotaSkin;

    @FXML
    private ImageView ImagenFondo;

    @FXML
    Canvas mainCanvas;

    @FXML
    public ImageView vidas;

    @FXML
    Label scoreText, lvlText;

    private Image barra,pelota;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(url);

        fons = new Image(Ratanoid.class.getResource("drawable/PantallaJuego.png").toExternalForm());
        ImagenFondo.setImage(fons);

        mainCanvas.setHeight(WindowsSetting.HEIGHT);
        mainCanvas.setWidth(WindowsSetting.WIDTH);
    }

    public void setScene(Scene sc) {
        scene = sc;
        gc = mainCanvas.getGraphicsContext2D();
        nivel = new Niveles(gc, scene, scoreText, vidas, main, barra ,pelota, ImagenFondo, lvlText);
    }

    public void setMain(Ratanoid mainApp) {
        this.main = mainApp;
    }

    public void setSkins(int barraSkin, int pelotaSkin){
        this.barraSkin = barraSkin;
        this.pelotaSkin = pelotaSkin;

        switch (barraSkin) {
            case 0:
                barra = new Image(Ratanoid.class.getResource("drawable/barraBuena.png").toExternalForm());
                break;
            case 1:
                barra = new Image(Ratanoid.class.getResource("drawable/barraBuena2.png").toExternalForm());
                break;
            case 2:
                barra = new Image(Ratanoid.class.getResource("drawable/barraBuena3.png").toExternalForm());
                break;
            case 3:
                barra = new Image(Ratanoid.class.getResource("drawable/barraBuena4.png").toExternalForm());
                break;
        }

        switch (pelotaSkin) {
            case 0:
                pelota = new Image(Ratanoid.class.getResource("drawable/bolablanca.png").toExternalForm());
                break;
            case 1:
                pelota = new Image(Ratanoid.class.getResource("drawable/bolaazul.png").toExternalForm());
                break;
            case 2:
                pelota = new Image(Ratanoid.class.getResource("drawable/bolaamarilla.png").toExternalForm());
                break;
            case 3:
                pelota = new Image(Ratanoid.class.getResource("drawable/bolaroja.png").toExternalForm());
                break;
        }
    }
}