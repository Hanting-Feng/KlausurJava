package KlauserJava;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ClienUDP {
    public static void main(String[] args) throws IOException {

        DatagramSocket datagramSocket = new DatagramSocket();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        byteBuffer.putInt(1);
        byteBuffer.putDouble(4.5);
        byteBuffer.putChar('F');
        String message = "Hello";
        byte[] messageBytes = message.getBytes();
        byteBuffer.putInt(messageBytes.length);
        byteBuffer.put(messageBytes);
        DatagramPacket datagramPacket = new DatagramPacket(byteBuffer.array(),byteBuffer.array().length, InetAddress.getLocalHost(),77);
        datagramSocket.send(datagramPacket);

    }
}
