package KlauserJava.SocketDatenbank;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.PublicKey;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Datenbank {
    public static void main(String[] args) throws Exception {

        Connection connections = DriverManager.getConnection("jdbc:sqlite:dbname");
        Statement statement = connections.createStatement(); // 获取操作数据库的命令对象
        statement.setQueryTimeout(30);
        statement.execute("drop table if exists application");
        statement.execute("create table application (id integer primary key,name String,postwort int)");

        // 创建表格
        statement.executeUpdate("insert into application (name,postwort) values ( 'Feng',123456)");
        statement.executeUpdate("insert into application (name,postwort) values ('Hanting',77777)");
        statement.executeUpdate("insert into application (name,postwort) values ('Wang',666666)");
        statement.executeUpdate("delete from application where name = 'Feng'");
        statement.executeUpdate("update application set name = 'Feng' where postwort = 77777");
        //增删改查
        List<String> list = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery("SELECT id,name,postwort FROM application");
        while (resultSet.next()){
            String a = "id: %s, name: %s, postwort: %s";
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String postwort = resultSet.getString("12345");
            System.out.println(String.format(a,id,name,postwort));
            System.out.println(String.format("id:%s,name:%s,postwort:%s",resultSet.getString("id"),resultSet.getString("name"),resultSet.getString("postwort")));
            list.add(String.format(resultSet.getString("id"), resultSet.getString("name"),resultSet.getString("postwort")));
            list.add("\n");
        }

        System.out.println(list);
        // 查询数据库

        connections.close(); // 关闭数据库连接
        ServerSocket serverSocket = new ServerSocket(777);
        Socket socket = serverSocket.accept();
        OutputStream ops = socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(ops);
        oos.writeObject(list);
    }

}
