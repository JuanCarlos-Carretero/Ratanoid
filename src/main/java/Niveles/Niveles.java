package Niveles;

import Modelo.Barra;
import Modelo.Ladrillo;

import Modelo.Pelota;
import com.example.ratanoid.Ratanoid;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Niveles {
    static public List<Ladrillo> ladrillosLvl1 = new ArrayList<>();
    static public List<Ladrillo> ladrillosLvl2 = new ArrayList<>();
    static public List<Ladrillo> ladrillosLvl3 = new ArrayList<>();


    List<Ladrillo> ladrilloAEliminar = new ArrayList<>();

    Image imagenLadrillo;
    Image imageBarra;
    Image imagePelota;
    public static Barra barra;
    Pelota pelota;
    public static GraphicsContext gc;
    Scene scene;
    public static boolean start;
    public static int vidas;
    public static boolean gameover;

    Label scoreText;
    Label lvlText;

    ImageView vida;
    Ratanoid main;

    int lvlEjecutado;

    public static int score = 0;
    int random;

    ImageView fondo;


    public Niveles(GraphicsContext gc, Scene scene, Label scoreText, ImageView vida, Ratanoid main, Image imageBarra, Image imagePelota, ImageView fondo, Label lvlText) {
        this.gc = gc;
        this.scene = scene;
        gameover = false;
        start = false;
        vidas = 3;
        this.imageBarra = imageBarra;
        this.imagePelota = imagePelota;

        this.scoreText = scoreText;
        this.vida = vida;
        this.main = main;
        this.fondo = fondo;
        this.lvlText = lvlText;

        Lvl1();
    }

    public void Lvl1(){
        lvlEjecutado = 1;
        setTextLvl("LVL1");
        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j <= 10; j++) {
                random = (int) (Math.random() * 100 + 1);
                // 65% de probabilidad de que salga ladrillo basico
                if (random >= 1 && random < 65){
                    imagenLadrillo = new Image((Ratanoid.class.getResource("drawable/ladrillo.png").toExternalForm()));
                    ladrillosLvl1.add(new Ladrillo(imagenLadrillo, j * 42, i * 75, 1, 0) {
                        @Override
                        public void move(String toString) {
                        }
                    });
                    gc.drawImage(imagenLadrillo, j * 42, i * 75);
                }

                // 30% de probabilidad de que salga ladrillo verde
                if (random >= 65 && random < 95){
                    imagenLadrillo = new Image((Ratanoid.class.getResource("drawable/ladrilloverde.png").toExternalForm()));
                    ladrillosLvl1.add(new Ladrillo(imagenLadrillo, j * 42, i * 75, 2 , 1) {
                        @Override
                        public void move(String toString) {
                        }
                    });
                    gc.drawImage(imagenLadrillo, j * 42, i * 75);
                }
                // 5% de probabilidad de que salga ladrillo rojo
                if (random >= 95 && random < 99){
                    imagenLadrillo = new Image((Ratanoid.class.getResource("drawable/ladrillorojo.png").toExternalForm()));
                    ladrillosLvl1.add(new Ladrillo(imagenLadrillo, j * 42, i * 75, 3, 2) {
                        @Override
                        public void move(String toString) {
                        }
                    });
                    gc.drawImage(imagenLadrillo, j * 42, i * 75);
                }
                // 1% de probabilidad de que salga ladrillo lila
                if (random == 99 || random == 100){
                    imagenLadrillo = new Image((Ratanoid.class.getResource("drawable/ladrillolila.png").toExternalForm()));
                    ladrillosLvl1.add(new Ladrillo(imagenLadrillo, j * 42, i * 75, 4, 3) {
                        @Override
                        public void move(String toString) {
                        }
                    });
                    gc.drawImage(imagenLadrillo, j * 42, i * 75);
                }

            }
        }

        barra = new Barra(imageBarra);
        barra.render(gc);

        pelota = new Pelota(imagePelota) {
            @Override
            public void move(String toString) {

            }
        };
        setScore();
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

    public void Lvl2(){
        lvlEjecutado = 2;
        setTextLvl("LVL2");
        fondo.setImage(new Image((Ratanoid.class.getResource("drawable/PantallaJuego3.png").toExternalForm())));

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 10; j++) {
                random = (int) (Math.random() * 100 + 1);
                // 20% de probabilidad de que salga ladrillo basico
                if (random >= 1 && random < 20){
                    imagenLadrillo = new Image((Ratanoid.class.getResource("drawable/ladrillo.png").toExternalForm()));
                    ladrillosLvl2.add(new Ladrillo(imagenLadrillo, j * 42, i * 75, 1, 0) {
                        @Override
                        public void move(String toString) {
                        }
                    });
                    gc.drawImage(imagenLadrillo, j * 42, i * 75);
                }

                // 25% de probabilidad de que salga ladrillo verde
                if (random >= 20 && random < 45){
                    imagenLadrillo = new Image((Ratanoid.class.getResource("drawable/ladrilloverde.png").toExternalForm()));
                    ladrillosLvl2.add(new Ladrillo(imagenLadrillo, j * 42, i * 75, 2 , 1) {
                        @Override
                        public void move(String toString) {
                        }
                    });
                    gc.drawImage(imagenLadrillo, j * 42, i * 75);
                }
                // 40% de probabilidad de que salga ladrillo rojo
                if (random >= 45 && random < 85){
                    imagenLadrillo = new Image((Ratanoid.class.getResource("drawable/ladrillorojo.png").toExternalForm()));
                    ladrillosLvl2.add(new Ladrillo(imagenLadrillo, j * 42, i * 75, 3, 2) {
                        @Override
                        public void move(String toString) {
                        }
                    });
                    gc.drawImage(imagenLadrillo, j * 42, i * 75);
                }
                // 15% de probabilidad de que salga ladrillo lila
                if (random >=85 && random <= 100){
                    imagenLadrillo = new Image((Ratanoid.class.getResource("drawable/ladrillolila.png").toExternalForm()));
                    ladrillosLvl2.add(new Ladrillo(imagenLadrillo, j * 42, i * 75, 4, 3) {
                        @Override
                        public void move(String toString) {
                        }
                    });
                    gc.drawImage(imagenLadrillo, j * 42, i * 75);
                }

            }
        }
        barra.clear(gc);
        barra = new Barra(imageBarra);
        barra.render(gc);

        pelota.clear(gc);
        pelota = new Pelota(imagePelota) {
            @Override
            public void move(String toString) {

            }
        };
        setScore();
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

    public void Lvl3(){
        lvlEjecutado = 3;
        setTextLvl("LVL3");
        fondo.setImage(new Image((Ratanoid.class.getResource("drawable/PantallaJuego4.png").toExternalForm())));

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 10; j++) {
                random = (int) (Math.random() * 100 + 1);
                // 5% de probabilidad de que salga ladrillo basico
                if (random >= 1 && random < 5){
                    imagenLadrillo = new Image((Ratanoid.class.getResource("drawable/ladrillo.png").toExternalForm()));
                    ladrillosLvl3.add(new Ladrillo(imagenLadrillo, j * 42, i * 75, 1, 0) {
                        @Override
                        public void move(String toString) {
                        }
                    });
                    gc.drawImage(imagenLadrillo, j * 42, i * 75);
                }

                // 10% de probabilidad de que salga ladrillo verde
                if (random >= 5 && random < 15){
                    imagenLadrillo = new Image((Ratanoid.class.getResource("drawable/ladrilloverde.png").toExternalForm()));
                    ladrillosLvl3.add(new Ladrillo(imagenLadrillo, j * 42, i * 75, 2 , 1) {
                        @Override
                        public void move(String toString) {
                        }
                    });
                    gc.drawImage(imagenLadrillo, j * 42, i * 75);
                }
                // 35% de probabilidad de que salga ladrillo basico
                if (random >= 15 && random < 50){
                    imagenLadrillo = new Image((Ratanoid.class.getResource("drawable/ladrillorojo.png").toExternalForm()));
                    ladrillosLvl3.add(new Ladrillo(imagenLadrillo, j * 42, i * 75, 3, 2) {
                        @Override
                        public void move(String toString) {
                        }
                    });
                    gc.drawImage(imagenLadrillo, j * 42, i * 75);
                }
                // 50% de probabilidad de que salga ladrillo basico
                if (random >=50 && random <= 100){
                    imagenLadrillo = new Image((Ratanoid.class.getResource("drawable/ladrillolila.png").toExternalForm()));
                    ladrillosLvl3.add(new Ladrillo(imagenLadrillo, j * 42, i * 75, 4, 3) {
                        @Override
                        public void move(String toString) {
                        }
                    });
                    gc.drawImage(imagenLadrillo, j * 42, i * 75);
                }

            }
        }
        barra.clear(gc);
        barra = new Barra(imageBarra);
        barra.render(gc);

        pelota.clear(gc);
        pelota = new Pelota(imagePelota) {
            @Override
            public void move(String toString) {

            }
        };
        setScore();
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

            if(lvlEjecutado == 1){
                for (Ladrillo ladrillo : ladrillosLvl1) {
                    if (ladrillo.getBoundary().intersects(pelota.getBoundary())) {
                        pelota.cambiarDireccion();
                        ladrillo.setVida(ladrillo.getVida()-1);
                        score++;
                        setScore();

                        //Si al ladrillo no le quedan vidas
                        if (ladrillo.getVida() == 0){
                            ladrillo.clear(gc);
                            ladrilloAEliminar.add(ladrillo);
                        }

                        //Si el ladrillo es verde
                        if (ladrillo.getId() == 1){
                            if (ladrillo.getVida() == 1){
                                ladrillo.clear(gc);
                                ladrillo.setImage(new Image(Ratanoid.class.getResource("drawable/roturaverde.png").toExternalForm()));
                                ladrillo.render(gc);
                            }
                        }

                        //Si el ladrillo es rojo
                        if (ladrillo.getId() == 2){
                            if (ladrillo.getVida() == 2){
                                ladrillo.clear(gc);
                                ladrillo.setImage(new Image(Ratanoid.class.getResource("drawable/roturarojo1.png").toExternalForm()));
                                ladrillo.render(gc);
                            }else if (ladrillo.getVida() == 1){
                                ladrillo.clear(gc);
                                ladrillo.setImage(new Image(Ratanoid.class.getResource("drawable/roturarojo2.png").toExternalForm()));
                                ladrillo.render(gc);
                            }
                        }

                        //Si el ladrillo es lila
                        if (ladrillo.getId() == 3){
                            if (ladrillo.getVida() == 3){
                                ladrillo.clear(gc);
                                ladrillo.setImage(new Image(Ratanoid.class.getResource("drawable/roturalila1.png").toExternalForm()));
                                ladrillo.render(gc);
                            }else if (ladrillo.getVida() == 2){
                                ladrillo.clear(gc);
                                ladrillo.setImage(new Image(Ratanoid.class.getResource("drawable/roturalila2.png").toExternalForm()));
                                ladrillo.render(gc);
                            }else if (ladrillo.getVida() == 1){
                                ladrillo.clear(gc);
                                ladrillo.setImage(new Image(Ratanoid.class.getResource("drawable/roturalila3.png").toExternalForm()));
                                ladrillo.render(gc);
                            }
                        }
                    }
                }
            }

            if(lvlEjecutado == 2){
                for (Ladrillo ladrillo : ladrillosLvl2) {
                    if (ladrillo.getBoundary().intersects(pelota.getBoundary())) {
                        pelota.cambiarDireccion();
                        ladrillo.setVida(ladrillo.getVida()-1);
                        score++;
                        setScore();

                        //Si al ladrillo no le quedan vidas
                        if (ladrillo.getVida() == 0){
                            ladrillo.clear(gc);
                            ladrilloAEliminar.add(ladrillo);
                        }

                        //Si el ladrillo es verde
                        if (ladrillo.getId() == 1){
                            if (ladrillo.getVida() == 1){
                                ladrillo.clear(gc);
                                ladrillo.setImage(new Image(Ratanoid.class.getResource("drawable/roturaverde.png").toExternalForm()));
                                ladrillo.render(gc);
                            }
                        }

                        //Si el ladrillo es rojo
                        if (ladrillo.getId() == 2){
                            if (ladrillo.getVida() == 2){
                                ladrillo.clear(gc);
                                ladrillo.setImage(new Image(Ratanoid.class.getResource("drawable/roturarojo1.png").toExternalForm()));
                                ladrillo.render(gc);
                            }else if (ladrillo.getVida() == 1){
                                ladrillo.clear(gc);
                                ladrillo.setImage(new Image(Ratanoid.class.getResource("drawable/roturarojo2.png").toExternalForm()));
                                ladrillo.render(gc);
                            }
                        }

                        //Si el ladrillo es lila
                        if (ladrillo.getId() == 3){
                            if (ladrillo.getVida() == 3){
                                ladrillo.clear(gc);
                                ladrillo.setImage(new Image(Ratanoid.class.getResource("drawable/roturalila1.png").toExternalForm()));
                                ladrillo.render(gc);
                            }else if (ladrillo.getVida() == 2){
                                ladrillo.clear(gc);
                                ladrillo.setImage(new Image(Ratanoid.class.getResource("drawable/roturalila2.png").toExternalForm()));
                                ladrillo.render(gc);
                            }else if (ladrillo.getVida() == 1){
                                ladrillo.clear(gc);
                                ladrillo.setImage(new Image(Ratanoid.class.getResource("drawable/roturalila3.png").toExternalForm()));
                                ladrillo.render(gc);
                            }
                        }
                    }
                }
            }

            if(lvlEjecutado == 3){
                for (Ladrillo ladrillo : ladrillosLvl3) {
                    if (ladrillo.getBoundary().intersects(pelota.getBoundary())) {
                        pelota.cambiarDireccion();
                        ladrillo.setVida(ladrillo.getVida()-1);
                        score++;
                        setScore();

                        //Si al ladrillo no le quedan vidas
                        if (ladrillo.getVida() == 0){
                            ladrillo.clear(gc);
                            ladrilloAEliminar.add(ladrillo);
                        }

                        //Si el ladrillo es verde
                        if (ladrillo.getId() == 1){
                            if (ladrillo.getVida() == 1){
                                ladrillo.clear(gc);
                                ladrillo.setImage(new Image(Ratanoid.class.getResource("drawable/roturaverde.png").toExternalForm()));
                                ladrillo.render(gc);
                            }
                        }

                        //Si el ladrillo es rojo
                        if (ladrillo.getId() == 2){
                            if (ladrillo.getVida() == 2){
                                ladrillo.clear(gc);
                                ladrillo.setImage(new Image(Ratanoid.class.getResource("drawable/roturarojo1.png").toExternalForm()));
                                ladrillo.render(gc);
                            }else if (ladrillo.getVida() == 1){
                                ladrillo.clear(gc);
                                ladrillo.setImage(new Image(Ratanoid.class.getResource("drawable/roturarojo2.png").toExternalForm()));
                                ladrillo.render(gc);
                            }
                        }

                        //Si el ladrillo es lila
                        if (ladrillo.getId() == 3){
                            if (ladrillo.getVida() == 3){
                                ladrillo.clear(gc);
                                ladrillo.setImage(new Image(Ratanoid.class.getResource("drawable/roturalila1.png").toExternalForm()));
                                ladrillo.render(gc);
                            }else if (ladrillo.getVida() == 2){
                                ladrillo.clear(gc);
                                ladrillo.setImage(new Image(Ratanoid.class.getResource("drawable/roturalila2.png").toExternalForm()));
                                ladrillo.render(gc);
                            }else if (ladrillo.getVida() == 1){
                                ladrillo.clear(gc);
                                ladrillo.setImage(new Image(Ratanoid.class.getResource("drawable/roturalila3.png").toExternalForm()));
                                ladrillo.render(gc);
                            }
                        }
                    }
                }
            }

            for (Ladrillo ladrillo : ladrilloAEliminar) {
                if(lvlEjecutado == 1) {
                    Niveles.ladrillosLvl1.remove(ladrillo);
                }
                if(lvlEjecutado == 2) {
                    Niveles.ladrillosLvl2.remove(ladrillo);
                }
                if(lvlEjecutado == 3) {
                    Niveles.ladrillosLvl3.remove(ladrillo);
                }
            }

            ladrilloAEliminar.clear();

            pelota.render(gc);

            if (pelota.getBoundary().intersects(Niveles.barra.getBoundary())) {
                pelota.setDirY(pelota.getDirY() * (-1));
            }

            //Si ya no hay ladrillos en el lvl1 pon el lvl2
            if (ladrillosLvl1.size() == 0){
                if (lvlEjecutado == 1) {
                    start = false;
                    Lvl2();
                }
            }

            //Si ya no hay ladrillos en el lvl2 pon el lvl3
            if (ladrillosLvl2.size() == 0){
                if(lvlEjecutado == 2){
                    start = false;
                    Lvl3();
                }
            }

            //Si ya no hay ladrillos en el lvl3 pon pantalla win
            if (ladrillosLvl3.size() == 0){
                if(lvlEjecutado == 3){
                    try {
                        main.gameOver();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    })
    );
    private void setScore() {
        scoreText.setFont(Font.font("Times New Roman", 25));
        scoreText.setTextFill(Color.web("White"));
        scoreText.setText("Puntos: " + 10 * score);
    }
    private void setTextLvl(String lvl) {
        lvlText.setFont(Font.font("Times New Roman", 25));
        lvlText.setTextFill(Color.web("White"));
        lvlText.setAlignment(Pos.CENTER);
        lvlText.setText(lvl);
    }
}