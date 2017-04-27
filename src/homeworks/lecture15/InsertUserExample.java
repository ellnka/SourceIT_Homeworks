package homeworks.lecture15;

import homeworks.lecture15.model.User;
import homeworks.lecture15.model.UserRole;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

import static homeworks.lecture15.constants.JdbcConstants.*;

public class InsertUserExample {
    public static void main(String[] args) {
        User user = RandomUser.createRandomUser();
        try (Connection con = DriverManager.getConnection(CONNECTION_URL)) {
            con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            PreparedStatement stmt = con.prepareStatement(INSERT_USER_SQL);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getLogin());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, user.getEmail());
            stmt.setLong(6, user.getUserRole().getId());
            int quantity = stmt.executeUpdate();
            //con.commit();
            System.out.println(quantity + " user(s) were inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
