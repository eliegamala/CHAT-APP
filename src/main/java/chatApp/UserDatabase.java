package chatApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDatabase {
    private Connection con;

    public UserDatabase(Connection con) {
        this.con = con;
    }

    public boolean saveUser(User user) {
        boolean set = false;
        try {
            String query = "INSERT INTO usertb(username, email, password) VALUES (?, ?, ?)";
            PreparedStatement insertUser = this.con.prepareStatement(query);
            insertUser.setString(1, user.getUsername());
            insertUser.setString(2, user.getEmail());
            insertUser.setString(3, user.getPassword());

            int rowsAffected = insertUser.executeUpdate();
            if (rowsAffected > 0) {
                set = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return set;
    }

    public User loginUser(String email, String password) {
        User user = null;
        try {
            String query = "SELECT * FROM usertb WHERE email=? AND password=?";
            PreparedStatement logUser = this.con.prepareStatement(query);
            logUser.setString(1, email);
            logUser.setString(2, password);

            ResultSet rs = logUser.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setID(rs.getInt("ID"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
