package KlauserJava.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static int plate = 10;

    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket(666);
        byte[] receiveBuffer = new byte[1024];
        byte[] sendBuffer;

        while (plate > 0){
            // 接收数据包
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            socket.receive(receivePacket);
            String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            if(receivedMessage.equals("Hello, UDP Server!") && plate > 0){
                String message = "Wir haben noch" + plate + "Platze";
                plate --;
                sendBuffer = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, receivePacket.getAddress(), receivePacket.getPort());
                socket.send(sendPacket);
                System.out.println("Erfolg Beantragen, noch" + plate + "Platze");
            }else{
                String m = "Nicht mehr Platze";
                sendBuffer = m.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, receivePacket.getAddress(), receivePacket.getPort());
                socket.send(sendPacket);
            }

        }
        socket.close();
        System.out.println("Keine Platze mehr verfügbar, Server wird geschlossen.");

    }
}
