import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DatamatikerServer {
    public static void main(String[] args) {

        int port = 8000;
        DataInputStream in;
        DataOutputStream out;
        ServerSocket server;
        Socket socket;
        double number = 0.0;
        double resultat;

        try {
            server = new ServerSocket(port);
            System.out.println("Serveren virker!");
            socket = server.accept();

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            while (true) {
                number = in.readDouble();
                System.out.println(number);
                resultat = Math.pow(number, 2) * Math.PI;
                out.writeDouble(resultat);
                if (number == 0.0) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
