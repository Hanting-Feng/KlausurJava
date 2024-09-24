package KlauserJava.TCP_Parking;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ServerUDP {
    public static int platze = 10;
    public static void main(String[] args) {
        try(DatagramSocket datagramSocket = new DatagramSocket(666)){
            ByteBuffer receiveBuffer = ByteBuffer.allocate(1024);
            receiveBuffer.order(ByteOrder.BIG_ENDIAN);
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer.array(),receiveBuffer.array().length);


            while (platze >= 0){
                ByteBuffer sendBuffer = ByteBuffer.allocate(1024);
                sendBuffer.order(ByteOrder.BIG_ENDIAN);
                receiveBuffer.clear();
                datagramSocket.receive(receivePacket);

                int length = receiveBuffer.getInt();
                byte[] messageBytes = new byte[length];
                receiveBuffer.get(messageBytes);
                String message = new String(messageBytes);

                if(message.equals("Beantragen") && platze > 0){
                    System.out.println("Erfolg Beantragen: " + platze);
                    sendBuffer.putInt(platze);
                    platze--;
                }else{
                    System.out.println("Nicht mehr Platze");
                    sendBuffer.putInt(-1);
                }
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer.array(),sendBuffer.array().length, InetAddress.getLocalHost(),777);
                datagramSocket.send(sendPacket);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
