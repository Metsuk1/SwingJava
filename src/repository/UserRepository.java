package repository;

import data.interfaces.IDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
    private final IDB db;

    public UserRepository(IDB db) {
        this.db = db;
    }


    public boolean registerUser(String username, String password) {
        String sql = "INSERT INTO users(username,password) VALUES (?,?)";


        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            System.out.println("error inserting user: " + e.getMessage());
            return false;
        }
    }

    public boolean loginUser(String username, String password) {
        String sql = "SELECT username,password FROM users WHERE username = ? AND password = ?";

        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){

             stmt.setString(1, username);
             stmt.setString(2, password);

             ResultSet rs = stmt.executeQuery();

             return rs.next();

        } catch (SQLException e) {
            System.out.println("error login user: " + e.getMessage());
            return false;
        }
    }

}
