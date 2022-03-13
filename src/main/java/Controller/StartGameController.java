package Controller;

import Modelo.Pelota;
import Modelo.WindowsSetting;
import com.example.ratanoid.Ratanoid;
import javafx.animation.*;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class StartGameController implements Initializable {

    Ratanoid main;
    private Scene scene;
    private GraphicsContext gc;
    private Pelota pilota;
    private Image fons;

    @FXML
    private ImageView imvBgd1;


    private int BACKGROUND_WIDTH = 1500;
    private ParallelTransition parallelTransition;

    /**
     * Opció 1: Animationtimer
     * Controlar la velocitat de moviment no és tant fàcil
     */
    private AnimationTimer animationTimer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            pilota.clear(gc);
            pilota.move();
            pilota.render(gc);
        }
    };

    /**
     * Opció 2: TimeLine
     * Controlem la velocitat de refresc amb KeyFrame.
     * Aquesta opció és molt més flexible que l'AnimationTimer
     */
    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.0057), new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            pilota.clear(gc);
            //gc.drawImage(fons, 0,0,600,400);
            pilota.move();
            pilota.render(gc);

        }
    })
    );

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

        /*parallelTransition = new ParallelTransition(translateTransition);
        parallelTransition.setCycleCount(Animation.INDEFINITE);
        parallelTransition.play();*/

        pilota = new Pelota(new Image(Ratanoid.class.getResource("drawable/bb.png").toExternalForm()));
        mainCanvas.setHeight(WindowsSetting.HEIGHT);
        mainCanvas.setWidth(WindowsSetting.WIDTH);
        gc = mainCanvas.getGraphicsContext2D();

        // Opció 1
        //animationTimer.start();

        // Opció 2
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

//        TranslateTransition trans = new TranslateTransition(Duration.seconds(2),lblInfo);
//        trans.setFromX(WindowsSetting.WIDTH);
//        trans.setToX(-1.0 * lblInfo.getLayoutBounds().getWidth());
//        trans.setCycleCount(TranslateTransition.INDEFINITE);
//        trans.play();

    }

    public void setScene(Scene sc) {
        scene = sc;
        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Point2D point = new Point2D(mouseEvent.getX(),mouseEvent.getY());
                if(pilota.isClicked(point)) pilota.changeDir();
                System.out.println("click");
            }
        });

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                System.out.println(keyEvent.getCode().toString());
                pilota.setDirection(keyEvent.getCode().toString());

            }
        });

    }

    public void setMain(Ratanoid mainApp) {
        this.main = mainApp;
    }
}