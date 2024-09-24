package KlauserJava.UDPSocketDatenbank;

import KlauserJava.Clone;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

public class ClientUDP {
    public static void main(String[] args) throws Exception{
        DatagramSocket datagramSocket = new DatagramSocket(666);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        DatagramPacket datagramPacket = new DatagramPacket(byteBuffer.array(),byteBuffer.array().length);
        datagramSocket.receive(datagramPacket);
        int size;
        List<String> list = new ArrayList<>();
        String a = "";
        while ((size = byteBuffer.get()) != 0){
            a += (char) size;
            list.add(a);
        }
        System.out.println(a);
    }
}
