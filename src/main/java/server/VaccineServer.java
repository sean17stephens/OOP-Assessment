package server;

import org.example.client.CAOClient;
import org.example.server.CAOClientHandler;
import org.example.core.DTOs.Course;
import org.example.server.Exceptions.DaoException;
import org.example.core.DTOs.Student;
import org.example.server.DAOs.CourseDaoInterface;
import org.example.server.DAOs.MySqlCourseDao;
import org.example.server.DAOs.MySqlStudentDao;
import org.example.server.DAOs.StudentDaoInterface;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;


/* The server package should contain all code to run the server. The server uses TCP sockets and thread per client.
 The server should connect to a MySql database to register clients, allow them to login and choose courses
 The server should listen for connections and once a connection is accepted it should spawn a new CAOClientHandler thread to deal with that connection. The server then returns to listening
 */
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
                Socket socket = ss.accept();  // wait for client to connect, and open a socket with the client
                //open a new socket to connect with client.
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
