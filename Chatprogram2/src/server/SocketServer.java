package server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

  public static void main(String[] args) throws IOException {
    int port = 5555;
    ServerSocket socketServer = new ServerSocket(port);
    while(true) {
      Socket sock = socketServer.accept();
      System.out.println("ip : " + sock.getInetAddress() + " �� ����Ǿ����ϴ�.");
      ReceiveThread receiveThread = new ReceiveThread(sock);
      receiveThread.start();
      SendThead sendThead = new SendThead(sock);
      sendThead.start();
    }
  }
}