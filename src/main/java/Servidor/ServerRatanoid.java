package Servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerRatanoid {

    private int port;
    /*private SecretNum ns;
    private Tauler t;*/

    private SrvTcpRatanoid(int port ) {
        this.port = port;
        /*ns = new SecretNum(100);
        t = new Tauler();*/
    }

    private void listen() {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            while(true) { //esperar connexió del client i llançar thread
                clientSocket = serverSocket.accept();
                //Llançar Thread per establir la comunicació
                //sumem 1 al numero de jugadors
                t.addNUmPlayers();
                ThreadSevidorAdivina_Obj FilServidor = new ThreadSevidorAdivina_Obj(clientSocket, ns, t);
                Thread client = new Thread(FilServidor);
                client.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(SrvTcpAdivina_Obj.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        SrvTcpAdivina_Obj srv = new SrvTcpAdivina_Obj(5558);
        srv.listen();
    }
}
