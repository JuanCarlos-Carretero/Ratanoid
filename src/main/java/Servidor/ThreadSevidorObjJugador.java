package Servidor;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ThreadSevidorObjJugador implements Runnable{

    private Socket socket;
    private OutputStream os;
    private ObjectOutputStream output;
    private InputStream is;
    private ObjectInputStream input;
    private boolean acabat = false;
    Archivo archivo;

    List<Jugador> jugadores = new ArrayList<>();


    public ThreadSevidorObjJugador(Socket clientSocket) {
        this.socket = clientSocket;
        archivo = new Archivo();
        try {
            is = clientSocket.getInputStream();
            input = new ObjectInputStream(is);
            os = clientSocket.getOutputStream();
            output = new ObjectOutputStream(os);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        File file = new File("/home/jkarka/IdeaProjects/Ratanoid/src/main/java/Servidor/src/Score.csv");
        try {
            while (!acabat) {
                jugadores = archivo.Leer(file);
                //LLegim l'objecte Jugador del stream input
                Jugador jugador = (Jugador) input.readObject();
                jugadores.add(jugador);

                //comprobamos lo que recibe el servidor
                System.out.println(jugador.apodo + " " + jugador.puntuacion);

                archivo.Escribir(jugadores, file);

                //tornem la llista al client per l'output
                output.writeObject(archivo.Leer(file));
                output.flush();

                acabat = true;
            }
        }catch (ClassNotFoundException | IOException e) {
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
}