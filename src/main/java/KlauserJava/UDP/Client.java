package KlauserJava.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) throws Exception{
        for(int i = 0; i <= 12 ; i++){
            client();
        }
    }
    public static void client() throws Exception{
        DatagramSocket datagramSocket = new DatagramSocket();
        byte[] sendBuffer;
        byte[] receiveBuffer = new byte[1024];

        String message = "Hello, UDP Server!";
        sendBuffer = message.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendBuffer,sendBuffer.length, InetAddress.getLocalHost(),666);

        datagramSocket.send(sendPacket);
        DatagramPacket receivePacket = new DatagramPacket(receiveBuffer,receiveBuffer.length);
        datagramSocket.receive(receivePacket);
        String receiveMessage = new String(receivePacket.getData(),0,receivePacket.getLength());
        System.out.println(receiveMessage);

        datagramSocket.close();
    }
}
