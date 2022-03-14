package Modelo;

import Niveles.Lvl1;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public abstract class Pelota extends Sprite {
    private Image image;
    private double velX, velY;
    private int dirX, dirY;
    List<Ladrillo> ladrilloAEliminar = new ArrayList<>();

    public Pelota(Image image) {
        super(image);
        setX(Math.random() * WindowsSetting.WIDTH);
        setY(350);
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
            if (getY() >= WindowsSetting.HEIGHT - getHeight()) dirY = (-1) * dirY;
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
                /*System.out.println("intersecepta");
                System.out.println("ladrillo: "+ ladrillo.getX()+ " " + ladrillo.getY() + "\n" + getX() + " " + getY());*/
                ladrillo.clear(Lvl1.gc);
                ladrilloAEliminar.add(ladrillo);
            }
        }
        for (Ladrillo ladrillo : ladrilloAEliminar) {
            Lvl1.ladrillos.remove(ladrillo);
        }
        ladrilloAEliminar.clear();

        if (Lvl1.barra.getBoundary().intersects(getBoundary())) {
            /*dirX = (-1) * dirX;*/
            setX(getX() + velX);
            dirY = (-1) * dirY;
            setY(getY() + velY);
        }
    }
}