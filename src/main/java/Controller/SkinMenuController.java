package Controller;

import com.example.ratanoid.Ratanoid;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SkinMenuController implements Initializable {
    private Ratanoid main;

    @FXML
    private ImageView elegirBarra;
    @FXML
    private ImageView pelotaSkin;

    @FXML
    private ChoiceBox<String> elegirBarra;
    @FXML
    private ChoiceBox<String> elegirPelota;

    private String[] barra = {"Vegeta", "Hulk", "Mexicano", "SonGoku"};

    private String[] pelota = {"Blanca", "Azul", "Amarillo", "Rojo"};
    int cualBarra;
    int cualPelota;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        elegirBarra.getItems().addAll(barra);
        elegirPelota.getItems().addAll(pelota);


        elegirBarra.setOnAction(this::getSkinBarra);
        elegirPelota.setOnAction(this::getSkinBola);

    }

    public void getSkinBarra(ActionEvent event) {
        

        if (elegirBarra.getValue().equals("Hulk")) {
            cualBarra = 1;
        }else if (elegirBarra.getValue().equals("Mexicano")){
            cualBarra = 2;
        }else if (elegirBarra.getValue().equals("SonGoku")){
            cualBarra = 3;
        }else{
            cualBarra = 0;
        }


        switch (cualBarra) {
            case 0:
                barraSkin.setImage(new Image(Ratanoid.class.getResource("drawable/barraBuena.png").toExternalForm()));
                break;
            case 1:
                barraSkin.setImage(new Image(Ratanoid.class.getResource("drawable/barraBuena2.png").toExternalForm()));
                break;
            case 2:
                barraSkin.setImage(new Image(Ratanoid.class.getResource("drawable/barraBuena3.png").toExternalForm()));
                break;
            case 3:
                barraSkin.setImage(new Image(Ratanoid.class.getResource("drawable/barraBuena4.png").toExternalForm()));
                break;
        }
    }

    public void getSkinBola(ActionEvent event) {
       

        if (elegirPelota.getValue().equals("Azul")) {
            cualPelota = 1;
        }else if (elegirPelota.getValue().equals("Amarillo")){
            cualPelota = 2;
        }else if (elegirPelota.getValue().equals("Rojo")){
            cualPelota = 3;
        }else{
            cualPelota = 0;
        }
        switch (cualPelota) {
            case 0:
                pelotaSkin.setImage(new Image(Ratanoid.class.getResource("drawable/bolablanca.png").toExternalForm()));
                break;
            case 1:
                pelotaSkin.setImage(new Image(Ratanoid.class.getResource("drawable/bolaazul.png").toExternalForm()));
                break;
            case 2:
                pelotaSkin.setImage(new Image(Ratanoid.class.getResource("drawable/bolaamarilla.png").toExternalForm()));
                break;
            case 3:
                pelotaSkin.setImage(new Image(Ratanoid.class.getResource("drawable/bolaroja.png").toExternalForm()));
                break;
        }
    }

    public void volver() {
        try {
            main.pantallaMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startGame() {
        try {
            main.startGame(cualBarra, cualPelota);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startGame() {
        try {
            main.startGame();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
