package client;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ReceiveThread extends Thread {

  private final Socket socket;
  private String receiveString;

  public ReceiveThread(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    try {
      DataInputStream tmpbuf = new DataInputStream(socket.getInputStream());
      while (true) {
        receiveString = tmpbuf.readUTF();
        if (receiveString == null) {
          System.out.println("���� ������ ����Ǿ����ϴ�.");
        } else {
          System.out.println("���� : " + receiveString);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}