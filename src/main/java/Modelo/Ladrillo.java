package Modelo;

import javafx.scene.image.Image;

public abstract class Ladrillo extends Sprite {

    public Ladrillo(Image image, int x, int y) {
        super(image);
        setX(x);
        setY(y);
    }
}
