package KlauserJava.Socket;

import KlauserJava.Serialisieren.PersonSerialisieren;
import KlauserJava.SocketDatenbank.Datenbank;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientSocketTCP {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Socket socket = new Socket("127.0.0.1",77);
        InputStream ips = socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(ips);
        String list = (String) ois.readObject();
        System.out.println(list);
    }
}
