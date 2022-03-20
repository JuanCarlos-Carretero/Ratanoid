package Controller;

import Cliente.ClienteRatanoid;
import Niveles.Niveles;
import Servidor.Jugador;
import com.example.ratanoid.Ratanoid;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class GameOverController implements Initializable {

    private Ratanoid main;
    private List<Jugador> jugadores;

    @FXML
    Label score1, score2, score3, score4, score5, tuScore;
    List<Jugador> scoreCopia;
    List<Jugador> scoreOrdenado = new ArrayList<>();
    Jugador scoreGuard;

    int cont;

    public GameOverController(){

    }

    public void exit() {
        System.exit(0);
    }

    public void setMain(Ratanoid mainApp) {
        this.main = mainApp;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cont = 1;
        ClienteRatanoid clientObjLlista = new ClienteRatanoid("localhost", 5557);
        clientObjLlista.LlamarServidor(PantallaMenuController.nombre, Niveles.score * 10);
        clientObjLlista.start();

        tuScore.setFont(Font.font("Times New Roman", 25));
        tuScore.setTextFill(Color.web("White"));
        tuScore.setAlignment(Pos.CENTER);
        tuScore.setText(PantallaMenuController.nombre + "    " + Niveles.score * 10);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        jugadores = clientObjLlista.getListado();

        //OrdenatScore
        scoreCopia = jugadores;
        for (int j = 0; j < jugadores.size(); j++) {
            if (!scoreCopia.isEmpty()) scoreGuard = scoreCopia.get(0);
            else break;
            for (int i = 1; i < scoreCopia.size(); i++) {
                if (scoreGuard.getPuntuacion() <= scoreCopia.get(i).getPuntuacion()) {
                    scoreGuard = scoreCopia.get(i);
                    System.out.println(scoreCopia.get(i).getPuntuacion() +  " " + scoreCopia.get(i).getApodo());
                }
            }
            scoreOrdenado.add(scoreGuard);
            scoreCopia.remove(scoreGuard);
        }

        for (Jugador jugador: scoreOrdenado) {
            if (cont == 6){
                break;
            } else if (cont == 1){
                score1.setFont(Font.font("Times New Roman", 25));
                score1.setTextFill(Color.web("White"));
                score1.setAlignment(Pos.CENTER);
                score1.setText(jugador.getApodo() + "    " + jugador.getPuntuacion());
            } else if(cont == 2){
                score2.setFont(Font.font("Times New Roman", 25));
                score2.setTextFill(Color.web("White"));
                score2.setAlignment(Pos.CENTER);
                score2.setText(jugador.getApodo() + "    " + jugador.getPuntuacion());
            } else if (cont == 3){
                score3.setFont(Font.font("Times New Roman", 25));
                score3.setTextFill(Color.web("White"));
                score3.setAlignment(Pos.CENTER);
                score3.setText(jugador.getApodo() + "    " + jugador.getPuntuacion());
            } else if(cont == 4){
                score4.setFont(Font.font("Times New Roman", 25));
                score4.setTextFill(Color.web("White"));
                score4.setAlignment(Pos.CENTER);
                score4.setText(jugador.getApodo() + "    " + jugador.getPuntuacion());
            } else if(cont == 5){
                score5.setFont(Font.font("Times New Roman", 25));
                score5.setTextFill(Color.web("White"));
                score5.setAlignment(Pos.CENTER);
                score5.setText(jugador.getApodo() + "    " + jugador.getPuntuacion());
            }
            cont++;
        }
    }
}
