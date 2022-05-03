import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException{

        int port = 8081;
        while (true){
            ServerSocket serverSocket = new ServerSocket(port);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.println("New connection accepted");
            out.println("Please, enter your name");
            final String name = in.readLine();
            out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
            out.println("How old are you");
            int age = Integer.parseInt(in.readLine());
            System.out.printf("User is %s years old \n", age);
            if (age >= 18){
                out.printf("%s, you have access to content for adults\n", name);
            }else{
                out.printf("%s, you have access to content for child\n", name);
            }
            System.out.println(in.readLine());
            out.println("Session is closes. Thank for your visit.");


            serverSocket.close();
        }
    }
}
