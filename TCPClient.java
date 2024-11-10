package networing;

import java.io.*;
import java.net.*;


public class TCPClient {
    
    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost", 5000)) {
            // Send data to the server
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            writer.println("Hello Server!");

            // Receive data from the server
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String response = reader.readLine();
            System.out.println("Server response: " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
