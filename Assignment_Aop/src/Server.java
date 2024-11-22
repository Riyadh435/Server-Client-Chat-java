import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    private static final int PORT = 8080;
    public static List<ClientHandler> clients = new ArrayList<>();
    private static int clientCount = 0;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);

            System.out.println("Server started successfully :)");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client "+clientCount+" join the chat.");
                ClientHandler clientHandler = new ClientHandler(clientSocket, clientCount++);
                clients.add(clientHandler);
                clientHandler.start();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                int newcount=clientCount-1;
                out.println("You are client " + newcount + " :");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
