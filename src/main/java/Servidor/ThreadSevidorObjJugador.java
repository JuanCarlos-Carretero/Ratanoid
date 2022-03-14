package Servidor;

import java.io.*;
import java.net.Socket;

public class ThreadSevidorObjJugador implements Runnable{

    private Socket clientSocket;
    private OutputStream os;
    private ObjectOutputStream output;
    private InputStream is;
    private ObjectInputStream input;
    private boolean acabat = false;
    Archivo archivo;


    public ThreadSevidorObjJugador(Socket clientSocket) {
        this.clientSocket = clientSocket;
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
                //LLegim l'objecte Jugador del stream input
                Jugador jugador = (Jugador) input.readObject();

                //comprobamos lo que recibe el servidor
                System.out.println(jugador.apodo + " " + jugador.puntuacion);

                archivo.Escribir(jugador, file);

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