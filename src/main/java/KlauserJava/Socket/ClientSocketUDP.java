package KlauserJava.Socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ClientSocketUDP {
    public static void main(String[] args) {
        try(DatagramSocket datagramSocket = new DatagramSocket(777)){
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
            DatagramPacket datagramPacket = new DatagramPacket(byteBuffer.array(), byteBuffer.array().length);

            ByteBuffer byteBuffer1 = ByteBuffer.allocate(1024);
            byteBuffer1.order(ByteOrder.BIG_ENDIAN);
            int r = 0;
            byteBuffer1.putInt(r);
            DatagramPacket datagramPacket1 = new DatagramPacket(byteBuffer1.array(),byteBuffer1.array().length,InetAddress.getLocalHost(),666);
            int a = 0;
            while (a <= 10){
                datagramSocket.send(datagramPacket1);
                datagramSocket.receive(datagramPacket);
                try {
                    a = byteBuffer.getInt();
                    if(a < 10){
                        System.out.println(a);
                    }
                    a += 1;
                    byteBuffer1.putInt(a);
                }catch (Exception e){
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
