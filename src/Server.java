import javax.sound.sampled.Port;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.System.in;
import static java.lang.System.out;

public class Server {
    public static final Integer PORT = 8080;

    public static void main(String[] args) throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            out.println("Сервер стартовал");
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    String infoFromClient = bufferReader.readLine();
                    out.printf("Новое подключение принято. Информация: %s, порт: %d%n", infoFromClient, clientSocket.getPort());
                    final String name = in.readLine();
                    out.println(String.format("Привет из России! Твой порт %d%n", clientSocket.getPort()));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
