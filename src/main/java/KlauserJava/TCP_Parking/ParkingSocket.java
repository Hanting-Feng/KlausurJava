package KlauserJava.TCP_Parking;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class ParkingSocket {
    private static int platz = 10;
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(666); // 创建一个监听端口666的服务器，用于接受来自客户端的连接
        Socket socket = serverSocket.accept(); // 等待客户端连接，一旦连接上，将返回一个Socket对象
        OutputStream ops = socket.getOutputStream(); // 获取输出流，供服务器端向客户端发送数据
        ObjectOutputStream oos = new ObjectOutputStream(ops); //封装输出流为对象输出流，以便发送Java对象
        oos.writeObject(platz);

        Socket socket1 = new Socket(InetAddress.getLocalHost(), 777); //创建一个客户端套接字，连接到本地IP地址的端口777
        InputStream ips = socket1.getInputStream(); //获取输入流，供客户端从服务器接收数据
        ObjectInputStream ois = new ObjectInputStream(ips); //封装输入流为对象输入流，以便接收Java对象
        String p = (String) ois.readObject();
        if (p.equals("Beantragen") && platz > 0) {
            System.out.println("Beantragen Erfolg" + " " + " " + --platz);
        }else{
            System.out.println("Beantragen nicht Erfolg");
        }
    }
}
