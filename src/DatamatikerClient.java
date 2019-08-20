import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class DatamatikerClient {
    public static void main(String[] args) {

        String host = "192.168.86.23";
        int port = 8000;
        DataInputStream in;
        DataOutputStream out;
        Socket socket;
        double number = 0.0;

        {
            try {
                socket = new Socket(host, port);

                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());


                Scanner sc = new Scanner(System.in);

                while (true) {
                    System.out.println("Skriv et tal som sendes til serveren: ");
                    number = sc.nextDouble();

                    out.writeDouble(number);
                    System.out.println("Areal tilbage fra server = " + in.readDouble());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
