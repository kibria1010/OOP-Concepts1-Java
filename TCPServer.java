package networing;

import java.io.*;
import java.net.*;

public class TCPServer {
    
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Server is listening on port 5000");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                // Create input and output streams for client communication
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);

                String message = reader.readLine();
                System.out.println("Received from client: " + message);

                writer.println("Hello Client, I received your message: " + message);

                socket.close(); // Close the connection
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




/*
Networking in Java allows applications to communicate over a network, enabling them to share data, resources, or services across different machines. 
Java provides a comprehensive networking API within the java.net package, which includes classes and interfaces for network communication using TCP/IP protocols. 
The main elements of Java networking include sockets, server sockets, and URLs.

Key Components of Networking in Java
IP Address: A unique identifier for each machine on a network.
Port Number: A 16-bit identifier for processes, used to differentiate multiple services running on the same machine.
Socket: An endpoint for communication between two machines.
Protocol: Defines the rules for data exchange. The two most commonly used protocols are:
TCP (Transmission Control Protocol): A reliable, connection-oriented protocol.
UDP (User Datagram Protocol): A faster, connectionless protocol.

Common Networking Classes in Java
Java networking relies on the following key classes within the java.net package:

Socket: Provides the client-side mechanism to establish a connection to a server.
ServerSocket: Provides the server-side mechanism to listen for incoming client requests.
InetAddress: Represents an IP address.
DatagramSocket and DatagramPacket: Used for UDP communication.
URL and URLConnection: Used for HTTP communication.

1. Establishing a Client-Server Communication Using TCP
TCP is connection-oriented and reliable, ensuring data is received in order without any loss. TCP communication in Java involves a client and a server.
Server Side Code:
The server listens for incoming connections on a specified port using ServerSocket. Once a connection is accepted, the server can read and write data using input/output streams.
Client Side Code:
The client initiates the connection to the server by creating a Socket object. It also uses input/output streams to send and receive data.
*/