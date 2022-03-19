package Modelo;

import javafx.scene.image.Image;

public class Barra extends Sprite{

    Image image;

    public Barra(Image image){
        super(image);
        this.image = image;
        setX(210);
        setY(580);
    }

    public void move(String direction) {
        switch (direction) {
            case "RIGHT":
                setX(getX() + 10);
                break;
            case "LEFT":
                setX(getX() - 10);
                break;
            case "D":
                setX(getX() + 10);
                break;
            case "A":
                setX(getX() - 10);
                break;
            case "4":
                setX(getX() + 10);
                break;
            case "6":
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