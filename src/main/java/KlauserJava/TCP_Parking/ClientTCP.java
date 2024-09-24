package KlauserJava.TCP_Parking;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientTCP {
    public static void main(String[] args) {
        for(int i = 0; i < 12; i++){
            client();
        }
    }

    public static void client(){
        try(Socket socket = new Socket(InetAddress.getLocalHost(),666)){
            OutputStream ops = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(ops);
            InputStream ips = socket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(ips);


            oos.writeObject("Beantragen");
            oos.flush();

            int platz = (int)ois.readObject();
            if(platz > 0){
                System.out.println("Platz Anzahl: " + platz);
            }else{
                System.out.println("Keine mehr Platz");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
