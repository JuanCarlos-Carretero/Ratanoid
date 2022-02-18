package Pruebas;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class GameScene extends Parent {
    private int width, height;
    private Rectangle background;
    private MainBrick mainBrick = new MainBrick();

    public GameScene(int width, int height){
        this.width = width;
        this.height = height;

        initGameObjects();
    }

    private void initGameObjects(){
        background = new Rectangle(0, 0, this.width, this.height);
        background.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mainBrick.onMouseMove(event);
            }
        });
        background.setFill(Color.BLACK);

        mainBrick.setX(0);
        mainBrick.setY(height - mainBrick.getHeight());

        getChildren().add(background);
        getChildren().add(mainBrick);
    }
}
