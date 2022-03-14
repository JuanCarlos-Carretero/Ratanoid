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
        try {
            while (!acabat) {
                //LLegim l'objecte LLista del stream input
                Jugador llista = (Jugador) input.readObject();

                //ordenem la llista i eliminem duplicats
                printLlista(llista);

                //tornem la llista al client per l'output
                output.writeObject(llista);
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

    private void printLlista(Jugador llista) {
        System.out.println(llista.apodo + " " + llista.puntuacion);
    }
}