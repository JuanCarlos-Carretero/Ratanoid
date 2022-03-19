package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Pelotas {
    List<Pelota> pelotas = new ArrayList<>();

    public List<Pelota> getPelotas() {
        return pelotas;
    }

    public void setPelotas(List<Pelota> pelotas) {
        this.pelotas = pelotas;
    }

    public void addPelota(Pelota pelota){
        pelotas.add(pelota);
    }

}
