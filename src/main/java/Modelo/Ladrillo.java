package Modelo;

import javafx.scene.image.Image;

public class Ladrillo extends Sprite {
    private Image image;
    private double velX, velY;
    private int dirX, dirY;

    @Override
    public void move() {

    }

    public Ladrillo(Image image) {
        super(image);
        setX(Math.random() * WindowsSetting.WIDTH);
        setY(Math.random() * WindowsSetting.HEIGHT);

    }
}
