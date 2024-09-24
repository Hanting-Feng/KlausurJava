package KlauserJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Datenbank {
    public static void main(String[] args) throws Exception {

        Connection connection = DriverManager.getConnection("jdbc:sqlite:dbname");

        // 删除表（如果存在）
        try (PreparedStatement pstmt = connection.prepareStatement("DROP TABLE IF EXISTS application")) {
            pstmt.execute();
        }

        // 创建表
        try (PreparedStatement pstmt = connection.prepareStatement(
                "CREATE TABLE application (id INTEGER PRIMARY KEY, name String, postwort INT)")) {
            pstmt.execute();
        }

        // 插入数据
        try (PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO application (name, postwort) VALUES (?, ?)")) {
            pstmt.setString(1, "Feng");
            pstmt.setInt(2, 123456);
            pstmt.executeUpdate();

            pstmt.setString(1, "Hanting");
            pstmt.setInt(2, 77777);
            pstmt.executeUpdate();

            pstmt.setString(1, "Wang");
            pstmt.setInt(2, 666666);
            pstmt.executeUpdate();
        }

        // 删除数据
        try (PreparedStatement pstmt = connection.prepareStatement(
                "DELETE FROM application WHERE name = ?")) {
            pstmt.setString(1, "Feng");
            pstmt.executeUpdate();
        }

        // 更新数据
        try (PreparedStatement pstmt = connection.prepareStatement(
                "UPDATE application SET name = ? WHERE postwort = ?")) {
            pstmt.setString(1, "Feng");
            pstmt.setInt(2, 77777);
            pstmt.executeUpdate();
        }

        // 查询数据
        List<String> list = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(
                "SELECT id, name, postwort FROM application")) {
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                String a = "id: %s, name: %s, postwort: %s";
                System.out.println(String.format(a, resultSet.getString("id"), resultSet.getString("name"), resultSet.getString("postwort")));
                list.add(String.format(a, resultSet.getString("id"), resultSet.getString("name"), resultSet.getString("postwort")));
                list.add("\n");
            }
        }

        System.out.println(list);
        // 关闭数据库连接
        connection.close();
    }
}

