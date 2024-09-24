package KlauserJava.TCP_Parking;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ParkingTCP {
    public static int platz = 10;
   public static void main(String[] args){
       try(ServerSocket serverSocket = new ServerSocket(666)){
           while (true){
               try (Socket socket = serverSocket.accept()){
                   OutputStream ops = socket.getOutputStream();
                   ObjectOutputStream oos = new ObjectOutputStream(ops);

                   InputStream ips = socket.getInputStream();
                   ObjectInputStream ois = new ObjectInputStream(ips);

                   String beantragen = (String) ois.readObject();
                   if(beantragen.equals("Beantragen") && platz > 0){
                       oos.writeObject(platz);
                       oos.flush();
                       platz--;
                       System.out.println("Erfolg beantragen, noch " + platz + " Platz");
                   }else{
                       System.out.println("keine mehr Platz");
                       oos.writeObject(-1);
                       oos.flush();
                   }
               }catch (Exception e){
                   e.printStackTrace();
               }

           }
       }catch (Exception e){
           e.printStackTrace();
       }
   }
}
