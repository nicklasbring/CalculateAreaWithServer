import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LocalServer {
    public static void main(String[] args) {

        int port = 1;
        int cirkelEllerFirkant;
        DataInputStream in;
        DataOutputStream out;
        ServerSocket server;
        Socket socket;
        double radius, bredde, hoejde, resultat;

        try {
            server = new ServerSocket(port);
            System.out.println("Serveren virker!");
            socket = server.accept();

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            cirkelEllerFirkant = in.readInt();

            if (cirkelEllerFirkant == 1) {
                radius = in.readDouble();
                resultat = Math.pow(radius, 2) * Math.PI;
                out.writeDouble(resultat);
            } else if (cirkelEllerFirkant == 2) {
                bredde = in.readDouble();
                hoejde = in.readDouble();

                resultat = bredde * hoejde;
                out.writeDouble(resultat);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
