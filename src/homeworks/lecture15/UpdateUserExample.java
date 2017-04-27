package homeworks.lecture15;

import homeworks.lecture15.model.User;
import homeworks.lecture15.model.UserRole;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

import static homeworks.lecture15.constants.JdbcConstants.*;

public class UpdateUserExample {
    public static void main(String[] args) {
        User user = RandomUser.getRandomUser();
        System.out.println("User before update: ");
        System.out.println(user);

        try (Connection con = DriverManager.getConnection(CONNECTION_URL)) {
            con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            updateUserAllAttributesById(user, con);

            updateUserNameByLogin(user, con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static void updateUserAllAttributesById (User user, Connection con) throws SQLException {
        user = RandomUser.updateRandomUser(user);
        System.out.println("User after update: ");
        System.out.println(user);

        PreparedStatement stmt = con.prepareStatement(UPDATE_USER_ALL_ATTR_BY_ID_SQL);
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getLastName());
        stmt.setString(3, user.getLogin());
        stmt.setString(4, user.getPassword());
        stmt.setString(5, user.getEmail());
        stmt.setLong(6, user.getUserRole().getId());
        stmt.setLong(7, user.getId());
        int quantity = stmt.executeUpdate();
        System.out.println(quantity + " user#" + user.getId() + " has been updated");
    }


    private static void updateUserNameByLogin (User user, Connection con) throws SQLException {
        user.setName("Lisa");
        user.setLastName("Simpson");

        PreparedStatement stmt = con.prepareStatement(UPDATE_USER_NAME_BY_LOGIN_SQL);
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getLastName());
        stmt.setString(3, user.getLogin());
        int quantity = stmt.executeUpdate();
        System.out.println(user);
        System.out.println(quantity + " user#" + user.getId() + " has been updated");
    }





}
