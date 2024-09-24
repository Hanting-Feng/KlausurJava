package KlauserJava.Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ServerSocketTCP {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TCP: 面向连接
        ServerSocket serverSocket = new ServerSocket(77);
        Socket socket = serverSocket.accept();
        OutputStream ops = socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(ops);
        oos.writeObject("Hallo");
        // 写数据发给客户端
    }
}
