package KlauserJava.TCP_Parking;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ClientUDP {
    public static void main(String[] args) {
        for(int i = 0; i <= 12; i++){
            client();
        }

    }
    public static void client(){
        try(DatagramSocket datagramSocket = new DatagramSocket(777)){
            ByteBuffer receiveBuffer = ByteBuffer.allocate(1024);
            receiveBuffer.order(ByteOrder.BIG_ENDIAN);
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer.array(), receiveBuffer.array().length);

            ByteBuffer sendBuffer = ByteBuffer.allocate(1024);
            sendBuffer.order(ByteOrder.BIG_ENDIAN);

            String message = "Beantragen";
            byte[] messageBytes = message.getBytes();
            sendBuffer.putInt(messageBytes.length);
            sendBuffer.put(messageBytes);
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer.array(),sendBuffer.array().length,InetAddress.getLocalHost(),666);


            datagramSocket.send(sendPacket);

            receiveBuffer.clear();
            datagramSocket.receive(receivePacket);

            int a = receiveBuffer.getInt();
            if(a > 0){
                System.out.println("Erfolge " + a);
            }else {
                System.out.println("nicht mehr Platze");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
