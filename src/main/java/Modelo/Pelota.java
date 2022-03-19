package Modelo;

import Controller.StartGameController;
import Niveles.Lvl1;
import com.example.ratanoid.Ratanoid;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Pelota extends Sprite {

    private double velX, velY;
    Label scoreText;
    ImageView vidas;

    public int getDirY() {
        return dirY;
    }

    public void setDirY(int dirY) {
        this.dirY = dirY;
    }

    int punto = 0;
    Ratanoid main;
    GraphicsContext gc;

    private int dirX, dirY;
    List<Ladrillo> ladrilloAEliminar = new ArrayList<>();

    public Pelota(Image image) {
        super(image);
        setX(240);
        setY(563);
        this.velX = 1.0f;
        this.velY = 1.0f;
        this.dirX = 1;
        this.dirY = 1;
    }

    /**
     * El moviment de la pilota és gestionat per la mateixa pilota
     * En aquest exemple només cal generalitzar les mides per on es
     * pot moure.
     */
    public void move() {

        if (Lvl1.start) {
            //Paredes
            if (dirX == 1) {
                setX(getX() + velX);
                if (getX() >= WindowsSetting.WIDTH - getWidth()) dirX = (-1) * dirX;
            } else {
                setX(getX() - velX);
                if (getX() <= 0) dirX = (-1) * dirX;
            }
            if (dirY == 1) {
                setY(getY() + velY);
                if (getY() >= 600) {

                    if (!Lvl1.gameover) {
                        Lvl1.vidas--;
                        setVida(vidas);

                        setX(240);
                        setY(563);

                        Lvl1.barra.clear(Lvl1.gc);
                        Lvl1.barra.setX(210);
                        Lvl1.barra.render(Lvl1.gc);

                        Lvl1.start = false;
                    }

                }
            } else {
                setY(getY() - velY);
                if (getY() <= 0) dirY = (-1) * dirY;
            }

            //Ladrillos
            for (Ladrillo ladrillo : Lvl1.ladrillos) {
                if (ladrillo.getBoundary().intersects(getBoundary())) {
                    setX(getX() + velX);
                    setY(getY() + velY);
                    dirY = (-1) * dirY;
                    ladrillo.clear(Lvl1.gc);
                    ladrilloAEliminar.add(ladrillo);
                    punto++;
                    setScore(scoreText);
                }
            }

            for (Ladrillo ladrillo : ladrilloAEliminar) {
                Lvl1.ladrillos.remove(ladrillo);
            }
            ladrilloAEliminar.clear();
        }
    }

    public void setScore(Label scoreText) {
        this.scoreText = scoreText;
        scoreText.setFont(Font.font("Times New Roman", 25));
        scoreText.setTextFill(Color.web("White"));
        scoreText.setText("Puntos: " + 100 * punto);
    }

    public void setVida(ImageView vida) {
        this.vidas = vida;
        switch (Lvl1.vidas) {
            case 3:
                vidas.setImage(new Image(Ratanoid.class.getResource("drawable/3vidas.png").toExternalForm()));
                break;
            case 2:
                vidas.setImage(new Image(Ratanoid.class.getResource("drawable/2vidas.png").toExternalForm()));
                break;
            case 1:
                vidas.setImage(new Image(Ratanoid.class.getResource("drawable/1vidas.png").toExternalForm()));
                break;
            case 0:
                try {
                    main.gameOver();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
    public void setMain(Ratanoid main){
        this.main = main;
    }
    public void setGc(GraphicsContext gc){
        this.gc = gc;
    }
}