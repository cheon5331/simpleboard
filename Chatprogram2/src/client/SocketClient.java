package client;
import java.io.IOException;
import java.net.Socket;

public class SocketClient {

  public static void main(String[] args) throws IOException {
    Socket sock = new Socket("192.168.0.2", 7777);
    System.out.println("서버와 접속되었습니다.");
    ReceiveThread receiveThread = new ReceiveThread(sock);
    receiveThread.start();
    SendThread sendThead = new SendThread(sock);
    sendThead.start();
  }
}