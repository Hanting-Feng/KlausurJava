package KlauserJava.SocketDatenbank;

import java.io.*;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class ClientTCP {
    public static void main(String[] args) throws IOException, ClassNotFoundException,SQLException {
        Socket socket = new Socket("127.0.0.1",777);
        InputStream ips = socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(ips);
        List<String> list = (List<String>) ois.readObject();

        System.out.println(list);

    }
    // 读服务器发过来的数据
}
