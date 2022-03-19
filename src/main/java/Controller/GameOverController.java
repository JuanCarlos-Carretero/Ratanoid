package Controller;

import Modelo.Pelota;
import Modelo.Pelotas;
import Niveles.Lvl1;
import com.example.ratanoid.Ratanoid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameOverController {


    private Ratanoid main;
    List<Pelota> pelotasABorrar = new ArrayList<>();

    public GameOverController(){

    }

    public void exit() {
        System.exit(0);
    }

    public void returnMenu(){
        try {
           /* for (Pelota pelota: Lvl1.pelotas.getPelotas()){
                pelotasABorrar.add(pelota);
            }
            for (Pelota pelota: pelotasABorrar){
                Lvl1.pelotas.getPelotas().remove(pelota);
            }*/
            //main.pantallaMenu(new PantallaMenuController());
            //Lvl1.start(new StartGameController());
            main.restart();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setMain(Ratanoid mainApp) {
        this.main = mainApp;
    }
}
