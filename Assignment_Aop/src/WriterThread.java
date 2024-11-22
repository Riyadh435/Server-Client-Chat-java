import java.io.PrintWriter;
import java.util.Scanner;

public class WriterThread extends Thread {
    private PrintWriter writer;

    public WriterThread(PrintWriter writer) {
        this.writer = writer;
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String message = scanner.nextLine();
                writer.println(message);
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}
