package Niveles;

import Modelo.Barra;
import Modelo.Ladrillo;

import Modelo.Pelota;
import com.example.ratanoid.Ratanoid;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class Lvl1 {
    static public List<Ladrillo> ladrillos = new ArrayList<>();
    Image image;
    Image imageBarra;
    public static Barra barra;
    Pelota pilota;
    public static GraphicsContext gc;
    Scene scene;

    public Lvl1(GraphicsContext gc, Scene scene) {
        this.gc = gc;
        this.scene = scene;

       for (int i = 1; i <= 2; i++) {
            for (int j = 1; j <= 10; j++) {
                image = new Image((Ratanoid.class.getResource("drawable/ladrillorojo.png").toExternalForm()));
                ladrillos.add(new Ladrillo(image, j * 42, i * 75) {
                    @Override
                    public void move(String toString) {
                    }
                });
                gc.drawImage(image, j * 42, i * 75);
            }
        }

        pilota = new Pelota(new Image(Ratanoid.class.getResource("drawable/bb.png").toExternalForm())) {
            @Override
            public void move(String toString) {

            }
        };

        imageBarra = new Image(Ratanoid.class.getResource("drawable/barraBuena.png").toExternalForm());
        barra = new Barra(imageBarra);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                barra.clear(gc);
                barra.move(keyEvent.getCode().toString());
                barra.render(gc);
                System.out.println(keyEvent.getCode().toString());
            }
        });

        // Opció 1
        //animationTimer.start();

        // Opció 2
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    /**
     * Opció 2: TimeLine
     * Controlem la velocitat de refresc amb KeyFrame.
     * Aquesta opció és molt més flexible que l'AnimationTimer
     */
    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.0057), new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            pilota.clear(gc);
            pilota.move();
            for (Ladrillo ladrillo: ladrillos) {
                if(ladrillo.getBoundary().intersects(pilota.getBoundary())) {
                    ladrillo.clear(gc);
                }
            }
            pilota.render(gc);
        }
    })
    );
}