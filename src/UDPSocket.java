import java.io.*;
import java.net.*;

class UDPSocket {
  public static void main(String argv[]) throws Exception
  {
    String clientSentence;
    String capitalizedSentence;
    DatagramSocket UDP_Socket = new DatagramSocket(9876);
    while(true)
    {
      byte[] receiveData = new byte[1024];
      byte[] sendData = new byte[1024];

      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
      UDP_Socket.receive(receivePacket);
      clientSentence = new String(receivePacket.getData());

    }
  }
}