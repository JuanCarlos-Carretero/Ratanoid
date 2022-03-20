package Modelo;

import javafx.scene.image.Image;

public abstract class Ladrillo extends Sprite {
    int vida;
    int id;
    int x, y;

    Image image;

    public Ladrillo(Image image, int x, int y, int vida, int id) {
        super(image);
        this.image = image;
        this.x = x;
        this.y = y;
        setX(x);
        setY(y);
        this.vida = vida;
        this.id = id;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getId() {
        return id;
    }

    public Image getImage() {
        return image;
    }
}
