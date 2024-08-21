import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {


    public static void main(String[] args) {

        try (Socket clientSocket = new Socket("localhost", Server.PORT);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            writer.out.println("Hello fro Juliana!");
            System.out.println("Сервер мне говорит: " + reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
