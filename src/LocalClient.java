import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class LocalClient {

    public static void main(String[] args) {

        String host = "localhost";
        int port = 1;
        int cirkelEllerFirkant;
        DataInputStream in;
        DataOutputStream out;
        Socket socket;
        double radius, bredde, hoejde;

        {
            try {
                socket = new Socket(host, port);

                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());

                Scanner sc = new Scanner(System.in);

                System.out.println("tast (1) for at regne areal af cirkel \ntast (2) for at regne areal af firkant");
                cirkelEllerFirkant = sc.nextInt();

                if (cirkelEllerFirkant == 1) {
                    out.writeInt(1);
                    System.out.println("Indtast radius");
                    radius = sc.nextDouble();
                    out.writeDouble(radius);

                    System.out.println("Areal udregnet af server = " + in.readDouble());
                } else if (cirkelEllerFirkant == 2) {
                    out.writeInt(2);
                    System.out.println("Indtast bredde");
                    bredde = sc.nextDouble();
                    out.writeDouble(bredde);

                    System.out.println("Indtast højde");
                    hoejde = sc.nextDouble();
                    out.writeDouble(hoejde);

                    System.out.println("Areal udregnet af server = " + in.readDouble());
                } else {
                    System.out.println("tast (1) for at regne areal af cirkel \ntast (2) for at regne areal af firkant");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
