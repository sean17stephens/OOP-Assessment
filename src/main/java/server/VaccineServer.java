//Sean Stephens D00211442
package server;

import exceptions.DaoException;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class VaccineServer {

    public VaccineServer() throws DaoException {
    }

    public static void main(String[] args) throws DaoException {

        VaccineServer server = new VaccineServer();
        server.start();
    }

    public void start()  {
        try {
            ServerSocket ss = new ServerSocket(50000);

            System.out.println("Server Message: Sean Server started. Listening for connections on port 50000...");
            int clientNumber = 0;

            while (true) // Continuous loop to accept new clients.
            {
                Socket socket = ss.accept();
                clientNumber++;

                System.out.println("Server: Client " + clientNumber + " has connected.");

                System.out.println("Server: Port# of remote client: " + socket.getPort());
                System.out.println("Server: Port# of this server: " + socket.getLocalPort());

                Thread t = new Thread(new VaccineClientHandler(socket, clientNumber)); //create a new clienthandler
                t.start();

                System.out.println("Server: ClientHandler started in thread for client :" + clientNumber + ".");
                System.out.println("Server: Listening for further connections.....");

            }
        } catch (IOException e) {
            System.out.println("Server Message: IOException: " + e);
        }
        System.out.println("Server: Server exiting, Goodbye!");
    }
}
