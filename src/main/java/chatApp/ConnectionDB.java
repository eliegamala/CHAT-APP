package chatApp;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
    private static Connection con;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb?useSSL=false", "root", "Elie@8468467");
            System.out.println("Connection successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
