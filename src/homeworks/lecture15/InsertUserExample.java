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
        if (user == null) {
            return;
        }

        Connection connection = null;
        try  {
            connection = DriverManager.getConnection(CONNECTION_URL);
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

            PreparedStatement stmt = connection.prepareStatement(INSERT_USER_SQL);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getLogin());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, user.getEmail());
            stmt.setLong(6, user.getUserRole().getId());

            int quantity = stmt.executeUpdate();
            if (quantity > 0) {
                connection.commit();
            } else {
                connection.rollback();
            }
            System.out.println(quantity + " user(s) were inserted");
        } catch (SQLException exception) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException rollbackException) {/* NOP */  }
            }
            exception.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException exception) { /* NOP */}
            }
        }
    }


}
