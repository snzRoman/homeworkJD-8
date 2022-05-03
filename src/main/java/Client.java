import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8081;

        try(Socket clientSocket = new Socket(host, port)){
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.println(in.readLine());
            out.println("Roman");
            System.out.println(in.readLine());
            System.out.println(in.readLine());
            out.println(17);
            System.out.println(in.readLine());
            out.println("I see content...");
            Thread.sleep(2000);
            System.out.println(in.readLine());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
