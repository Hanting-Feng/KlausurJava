package KlauserJava.ReadModifyWrite;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Random;

public class UDPClient {

    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        try(DatagramSocket datagramSocket = new DatagramSocket(666)){
            ByteBuffer receiveBuffer = ByteBuffer.allocate(1024);
            receiveBuffer.order(ByteOrder.BIG_ENDIAN);
            ByteBuffer sendBuffer = ByteBuffer.allocate(1024);
            sendBuffer.order(ByteOrder.BIG_ENDIAN);
            sendBuffer.putInt(1);
            DatagramPacket sendPacket = new DatagramPacket(
                    sendBuffer.array(),sendBuffer.array().length,
                    InetAddress.getLocalHost(),777);
            datagramSocket.send(sendPacket);
            DatagramPacket receivePacket = new DatagramPacket(
                    receiveBuffer.array(),
                    receiveBuffer.array().length);
            datagramSocket.receive(receivePacket);
            int p = receiveBuffer.getInt();
            if(p == 1){
                System.out.println("Erfolg");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
