package Modelo;

import Niveles.Niveles;
import com.example.ratanoid.Ratanoid;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.io.IOException;

public abstract class Pelota extends Sprite {
    private double velX, velY;
    ImageView vidas;

    public int getDirY() {
        return dirY;
    }

    public void setDirY(int dirY) {
        this.dirY = dirY;
    }

    Ratanoid main;
    public boolean gameOver;

    private int dirX, dirY;

    public Pelota(Image image) {
        super(image);
        setX(240);
        setY(563);
        this.velX = 1.0f;
        this.velY = 1.0f;
        this.dirX = 1;
        this.dirY = 1;
        gameOver = false;
    }

    /**
     * El moviment de la pilota és gestionat per la mateixa pilota
     * En aquest exemple només cal generalitzar les mides per on es
     * pot moure.
     */
    public void move() {

        if (Niveles.start) {
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
                        Niveles.vidas--;
                        setVida(vidas);

                        setX(240);
                        setY(563);

                        Niveles.barra.clear(Niveles.gc);
                        Niveles.barra.setX(210);
                        Niveles.barra.render(Niveles.gc);

                        Niveles.start = false;
                }
            } else {
                setY(getY() - velY);
                if (getY() <= 0) dirY = (-1) * dirY;
            }
        }
    }

    public void setVida(ImageView vida) {
        this.vidas = vida;
        switch (Niveles.vidas) {
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
    public void cambiarDireccion(){
        setX(getX() + velX);
        setY(getY() + velY);
        dirY = (-1) * dirY;
    }
    public void setMain(Ratanoid main){
        this.main = main;
    }
}