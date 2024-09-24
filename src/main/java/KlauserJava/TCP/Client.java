package KlauserJava.TCP;

import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<String> mess = new ArrayList<>(List.of("2010 世界杯在哪举行？","巴西进入世界杯了吗","中国进入世界杯了吗"));
        try(Socket socket = new Socket(InetAddress.getLocalHost(),666)){
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());


            for(int i = 0; i < mess.size(); i++){
                oos.writeObject(mess.get(i));
                String s = (String) ois.readObject();
                System.out.println(s);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
