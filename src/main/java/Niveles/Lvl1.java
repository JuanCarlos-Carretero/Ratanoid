package Niveles;

import Controller.StartGameController;
import Modelo.Barra;
import Modelo.Ladrillo;

import Modelo.Pelota;
import Modelo.Pelotas;
import com.example.ratanoid.Ratanoid;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Lvl1 {
    static public List<Ladrillo> ladrillos = new ArrayList<>();
    Image image;
    Image imageBarra;
    public static Barra barra;
    public static Pelotas pelotas;
    Pelota pelota;
    public static GraphicsContext gc;
    Scene scene;
    public static boolean start;
    public static int vidas;
    Ratanoid main;

    public Lvl1(GraphicsContext gc, Scene scene, Label scoreText, ImageView vida, Ratanoid main) {
        this.gc = gc;
        this.scene = scene;
        start = false;
        vidas = 3;
        this.main = main;
        pelotas = new Pelotas();

        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j <= 10; j++) {
                image = new Image(Ratanoid.class.getResource("drawable/ladrillo.png").toExternalForm());
                ladrillos.add(new Ladrillo(image, j * 42, i * 75) {
                    @Override
                    public void move(String toString) {
                    }
                });
                gc.drawImage(image, j * 42, i * 75);
            }
        }

        if (barra == null){
            imageBarra = new Image(Ratanoid.class.getResource("drawable/barraBuena.png").toExternalForm());
            barra = new Barra(imageBarra);
            barra.render(gc);
        }

        if (pelota == null){
            pelota = new Pelota(new Image(Ratanoid.class.getResource("drawable/bolablanca.png").toExternalForm())) {
                @Override
                public void move(String toString) {

                }
            };
            pelotas.getPelotas().add(pelota);

            for (Pelota pelota : pelotas.getPelotas()) {
                pelota.setGc(gc);
            }
        }

        pelota.setScore(scoreText);
        pelota.setVida(vida);
        pelota.setMain(main);


        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                barra.clear(gc);
                barra.move(keyEvent.getCode().toString());
                barra.render(gc);
                if (keyEvent.getCode().toString().equals("SPACE")) {
                    start = true;
                }
            }
        });

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    /**
     * Opció 2: TimeLine
     * Controlem la velocitat de refresc amb KeyFrame.
     * Aquesta opció és molt més flexible que l'AnimationTimer
     */
    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.0057), new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            pelota.clear(gc);
            pelota.move();
            for (Ladrillo ladrillo : ladrillos) {
                if (ladrillo.getBoundary().intersects(pelota.getBoundary())) {
                    ladrillo.clear(gc);
                }
            }
            pelota.render(gc);

            if (pelota.getBoundary().intersects(Lvl1.barra.getBoundary())) {
                pelota.setDirY(pelota.getDirY() * (-1));
            }

//            if(pelota.gameOver){
//                try {
//                    main.gameOver();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    })
    );


}