import java.io.*;
import java.net.*;

class TCPServer {
  public static void main(String argv[]) throws Exception
  {
    String clientSentence;
    String capitalizedSentence;
    ServerSocket TCPSocket = new ServerSocket(6789);
    while(true)
    {
      Socket connectionSocket = TCPSocket.accept();
      BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
      clientSentence = inFromClient.readLine();
    }
  }
}