package KlauserJava.ReadModifyWrite;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class UDPServers {
    public static  int p = 10;
    public static void main(String[] args) {
        try(DatagramSocket datagramSocket = new DatagramSocket(777)){
            ByteBuffer receiveBuffer = ByteBuffer.allocate(1024);
            receiveBuffer.order(ByteOrder.BIG_ENDIAN);
            DatagramPacket receivePacket = new DatagramPacket(
                    receiveBuffer.array(),receiveBuffer.array().length);
            datagramSocket.receive(receivePacket);
            ByteBuffer sendBuffer = ByteBuffer.allocate(1024);
            sendBuffer.order(ByteOrder.BIG_ENDIAN);
            int i = receiveBuffer.getInt();
            if((i == 1) && p > 0){
                sendBuffer.putInt(1);
                p--;
            }else{
                sendBuffer.putInt(-1);
            }
            DatagramPacket sendPacket = new DatagramPacket(
                    sendBuffer.array(),
                    sendBuffer.array().length,
                    InetAddress.getLocalHost(),666);
            datagramSocket.send(sendPacket);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
