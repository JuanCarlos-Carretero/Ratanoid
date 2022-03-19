package Controller;

import com.example.ratanoid.Ratanoid;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class GameOverController {

    private Ratanoid main;

    @FXML
    ImageView imvBgd1;


    public void exit() {
        System.exit(0);
    }

    public void returnMenu(){
        try {
            main.pantallaMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setMain(Ratanoid mainApp) {
        this.main = mainApp;
    }

}
