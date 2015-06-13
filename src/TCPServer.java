import java.io.*;
import java.net.*;
import java.nio.*;
import java.util.Date;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

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

      MongoClient mongo = new MongoClient("localhost", 27017);
      DB db = mongo.getDB("testdb");
      DBCollection table = db.getCollection("status_log");
      BasicDBObject document = new BasicDBObject();
      document.put("device", objectId);
      document.put("temperature", temperature);
      document.put("saved_at", new Date());
      table.insert(document);

    }
  }
}