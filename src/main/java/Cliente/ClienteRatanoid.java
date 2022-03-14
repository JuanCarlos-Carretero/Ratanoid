package Cliente;

import Servidor.Jugador;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClienteRatanoid extends Thread {

    private String hostname;
    private int port;
    private boolean acabat = false;
    private InputStream is;
    private OutputStream os;
    private ObjectOutputStream output;
    private ObjectInputStream input;

    List<Jugador> jugadores = new ArrayList<>();
    Jugador jugador;

    String nombre;
    int puntuacion;

    /**
     * Metodo constructor para crar la clase
     * @param hostname  variable que nos dara acceso al servidor ("localhost")
     * @param port  variable que nos dara acceso al servidor ("5557")
     */
    public ClienteRatanoid(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    /**
     * Este metodo es llamado para usar el tcp
     * @param nombre    esta variable sera el nombre del jugador
     * @param puntuacion    esta variable sera la puntuacion del jugador
     */
    public void LlamarServidor(String nombre, int puntuacion){
        this.nombre = nombre;
        this.puntuacion = puntuacion;
        /*ClienteRatanoid clientObjLlista = new ClienteRatanoid("localhost", 5557);*/
        ClienteRatanoid clientObjLlista = new ClienteRatanoid(hostname, port);
        clientObjLlista.start();
    }

    @Override
    public void run() {
        Socket socket;
        try {
            socket = new Socket(InetAddress.getByName(hostname), port);
            os = socket.getOutputStream();
            output = new ObjectOutputStream(os);
            is = socket.getInputStream();
            input = new ObjectInputStream(is);

            while (!acabat) {
                /*Jugador jugador = new Jugador("joel", 100);*/
                jugador = new Jugador(nombre, puntuacion);
                output.writeObject(jugador);
                output.flush();

                jugadores = (List<Jugador>) input.readObject();
                System.out.println(jugador.getApodo() + " " + jugador.getPuntuacion());
                acabat = true;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            output.close();
            input.close();
            is.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public static void main(String[] args) {
        ClienteRatanoid clientObjLlista = new ClienteRatanoid("localhost", 5557);
        clientObjLlista.start();
    }*/
}