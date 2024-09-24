package KlauserJava.TCP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static void main(String[] args) {
        List<String> answer = new ArrayList<>(List.of("南非","进入世界杯了","哈哈...问题真逗"));

        try(ServerSocket serverSocket = new ServerSocket(666)){
            Socket socket = serverSocket.accept();
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());


            for(int i = 0; i < answer.size(); i++){
                String s = (String) ois.readObject();
                System.out.println(s);
                oos.writeObject(answer.get(i));
            }
        }catch (Exception e){

        }
    }
}
