package KlauserJava.Socket;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
public class ServerSocketUDP {
    public static void main(String[] args)  {
        try(DatagramSocket datagramSocket = new DatagramSocket(666)){
            ByteBuffer byteBuffer1 = ByteBuffer.allocate(1024);
            byteBuffer1.order(ByteOrder.BIG_ENDIAN);
            DatagramPacket datagramPacket1 = new DatagramPacket(byteBuffer1.array(),byteBuffer1.array().length);
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.order(ByteOrder.BIG_ENDIAN);

            DatagramPacket datagramPacket = new DatagramPacket(byteBuffer.array(),byteBuffer.array().length,InetAddress.getLocalHost(),777);
            int a = 0;
            while (a < 10){
                datagramSocket.receive(datagramPacket1);
                try {
                    a = byteBuffer1.getInt();
                    System.out.println(a);
                    a += 1;
                    byteBuffer.putInt(a);
                }catch (Exception e){
                }
                datagramSocket.send(datagramPacket);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
