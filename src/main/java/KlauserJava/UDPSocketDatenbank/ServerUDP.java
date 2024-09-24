package KlauserJava.UDPSocketDatenbank;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ServerUDP {
    public static void main(String[] args) throws Exception{
        Connection connections = DriverManager.getConnection("jdbc:sqlite:dbname");
        Statement statement = connections.createStatement(); // 获取操作数据库的命令对象
        statement.setQueryTimeout(30);
        statement.execute("DROP TABLE IF EXISTS application");

        statement.execute("CREATE TABLE application (id INTEGER PRIMARY KEY, name STRING, postwort STRING)");
        // 创建表格
        String name1 = "Feng";
        statement.executeUpdate("INSERT INTO application (name,postwort) VALUES ( '"+ name1 +"', '123456FF')");
        statement.executeUpdate("insert into application (name,postwort) values ('Hanting','FFFFFFF')");
        statement.executeUpdate("INSERT INTO application (name,postwort) VALUES ( 'Feng', '77777')");
        statement.executeUpdate("insert into application (name,postwort) values ('Feng','99999')");
        statement.executeUpdate("INSERT INTO application (name,postwort) VALUES ( 'LiLi', '18786')");
        statement.executeUpdate("insert into application (name,postwort) values ('Hanting','66666')");
        statement.executeUpdate("INSERT INTO application (name,postwort) VALUES ( 'Guang', '123')");
        statement.executeUpdate("insert into application (name,postwort) values ('Ting','33333')");
        statement.executeUpdate("delete from application where name = 'Guang'");
        statement.executeUpdate("update application set name = 'Feng', name = 'Yang' where postwort = '66666'");
        //增删改查
        ResultSet resultSet = statement.executeQuery("SELECT id,name,postwort FROM application");
        List<String> list = new ArrayList<>();
        while (resultSet.next()){
            String a = "id: %d, name: %s, postwort: %s";
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String postwort = resultSet.getString("postwort");
            list.add(String.format(a,id,name,postwort ));
            list.add("\n");
        }
        connections.close();



        DatagramSocket datagramSocket = new DatagramSocket();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        for(String a : list){
            byte[] list1 = a.getBytes();
            byteBuffer.put(list1);
        }
        DatagramPacket datagramPacket = new DatagramPacket(byteBuffer.array(),byteBuffer.array().length, InetAddress.getLocalHost(),666);
        datagramSocket.send(datagramPacket);
    }

}
