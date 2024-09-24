package KlauserJava;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.sql.ResultSet;

public class ServerUDP {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(77);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        DatagramPacket datagramPacket = new DatagramPacket(byteBuffer.array(),byteBuffer.array().length);
        datagramSocket.receive(datagramPacket);
        int a = byteBuffer.getInt();
        double b = byteBuffer.getDouble();
        boolean c = false;
        char d = byteBuffer.getChar();
        if(a == 1){
            c = true;
        }
        // 字符串
        int length = byteBuffer.getInt();
        byte[] messageBytes = new byte[length];
        byteBuffer.get(messageBytes);
        String message = new String(messageBytes);
        System.out.println(message);
        System.out.println(c);
        System.out.println(b);
        System.out.println(d);
    }
}
