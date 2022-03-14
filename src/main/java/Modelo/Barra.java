package Modelo;

import javafx.scene.image.Image;

public class Barra extends Sprite{

    Image image;
    private double width, height;

    public Barra(Image image){
        super(image);
        this.image = image;
        setX(250);
        setY(580);
    }

/*    public void setImage(Image image) {
        this.image = image;
        width = this.image.getWidth();
        height = this.image.getHeight();
    }*/

    public void move(String direction) {
        switch (direction) {
            case "RIGHT":
                setX(getX() + 10);
                break;
            case "LEFT":
                setX(getX() - 10);
                break;
        }
        if (getX() >= 500 - image.getWidth() ){
            setX(getX()-10);
        }
        if (getX() <= 0){
            setX(getX()+10);
        }
    }
}