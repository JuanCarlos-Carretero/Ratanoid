package Controller;

import Modelo.Barra;
import Modelo.Ladrillo;
import Modelo.Pelota;
import Modelo.WindowsSetting;
import Niveles.Lvl1;
import com.example.ratanoid.Ratanoid;
import javafx.animation.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class
StartGameController implements Initializable {

    Ratanoid main;
    private Scene scene;
    private GraphicsContext gc;
    private Lvl1 nivel;
    private Ladrillo ladrillo;
    private Image fons;

    @FXML
    private ImageView imvBgd1;

    private int BACKGROUND_WIDTH = 1500;
    private ParallelTransition parallelTransition;

    @FXML
    Label lblInfo;
    @FXML
    Canvas mainCanvas;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(url);

        fons = new Image(Ratanoid.class.getResource("drawable/PantallaJuego.png").toExternalForm());
        imvBgd1.setImage(fons);

        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(50000), imvBgd1);
        translateTransition.setFromX(0);
        translateTransition.setToX(-1 * BACKGROUND_WIDTH);
        translateTransition.setInterpolator(Interpolator.LINEAR);

        mainCanvas.setHeight(WindowsSetting.HEIGHT);
        mainCanvas.setWidth(WindowsSetting.WIDTH);

//        System.out.println(scene.getClass().toString());


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