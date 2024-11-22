import java.io.*;

public class MessagesStore {
    public static void storeMessagesToFile(String message, ClientHandler sender) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("messages_store.txt", true))) {
            for (ClientHandler client : Server.clients) {
                client.sendMessage(sender.getClientName() + ": " + message);
            }
            writer.write(sender.getClientName() + ": " + message + "\n");
        } catch (IOException e) {
            System.err.println("Error writing to file: ");
        }
    }


    public static void sendPreviousMessages(ClientHandler receiver) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("messages_store.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                receiver.sendMessage(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error to send prev messages");
        }
    }


}

