package Modelo;

import javafx.fxml.FXML;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Pelota extends Sprite {
    private Image image;
    private double velX, velY;
    private int dirX, dirY;

    public Pelota(Image image) {
        super(image);
        setX(Math.random() * WindowsSetting.WIDTH);
        setY(Math.random() * WindowsSetting.HEIGHT);
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
    @Override
    public void move() {
        if(dirX == 1) {
            setX(getX() + velX);
            if(getX() >= WindowsSetting.WIDTH - getWidth()) dirX = (-1)*dirX;
        }else {
            setX(getX() - velX);
            if(getX() <= 0) dirX = (-1)*dirX;
        }
        if(dirY == 1){
            setY(getY() + velY);
            if(getY() >= WindowsSetting.HEIGHT - getHeight()) dirY = (-1)*dirY;
        }
        else {
            setY(getY() - velY);
            if(getY() <= 0) dirY = (-1)*dirY;
        }
    }

    public void changeDir() {
        double t = Math.random();
        if(0.33 > t) dirX = dirX*(-1);
        if(0.33 < t && 0.66 > t) dirY = dirY*(-1);
        if(0.66 < t) {
            dirY = dirY*(-1);
            dirX = dirX*(-1);
        }

    }

    public void setDirection(String direction) {
        switch (direction) {
            case "RIGHT":
                dirX = 1;
                break;
            case "LEFT":
                dirX = -1;
                break;
            case "DOWN":
                dirY = 1;
                break;
            case "UP":
                dirY = -1;
                break;
        }
    }



}