package Servidor;

public class Jugador {
    int puntuacion;
    String apodo;

    Jugador(String apodo, int puntuacion){
        this.apodo = apodo;
        this.puntuacion = puntuacion;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }
}
