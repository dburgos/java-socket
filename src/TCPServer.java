import java.io.*;
import java.net.*;
import java.nio.*;

class TCPServer {
  public static void main(String argv[]) throws Exception
  {
    String clientSentence;
    String capitalizedSentence;
    String objectId;
    String temperature;
    ServerSocket TCPSocket = new ServerSocket(6789);
    while(true)
    {
      Socket connectionSocket = TCPSocket.accept();
      BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
      clientSentence = inFromClient.readLine();

      ByteBuffer buffer = ByteBuffer.wrap(clientSentence.getBytes());
      buffer.order(ByteOrder.LITTLE_ENDIAN);
      objectId = new String(buffer.get(new byte[], 0, 16), Charset.forName("UTF-8"));
      temperature = new String(buffer.get(new byte[], 17, 2), Charset.forName("UTF-8"));

    }
  }
}