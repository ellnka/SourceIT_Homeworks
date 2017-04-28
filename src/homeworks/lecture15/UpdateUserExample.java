package homeworks.lecture15;

import homeworks.lecture15.model.User;

import java.sql.*;

import static homeworks.lecture15.constants.JdbcConstants.*;

public class UpdateUserExample {
    public static void main(String[] args) {


        try (Connection con = DriverManager.getConnection(CONNECTION_URL)) {
            con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            updateUserAllAttributesById(con);
            System.out.println("");
            updateUserNameByLogin(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    private static void updateUserAllAttributesById (Connection con) throws SQLException {
        User user = RandomUser.getRandomUserFromDB();
        System.out.println("User before updating all attributes: ");
        System.out.println(user);
        user = RandomUser.updateRandomUser(user);
        System.out.println("New random attributes: ");
        System.out.println(user);
        if (user == null) {
            return;
        }
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


    private static void updateUserNameByLogin (Connection con) throws SQLException {
        User user = RandomUser.getRandomUserFromDB();
        System.out.println("User before updating a name: ");
        System.out.println(user);
        if (user == null) {
            return;
        }
        user.setName("Lisa");
        user.setLastName("Simpson");

        PreparedStatement stmt = con.prepareStatement(UPDATE_USER_NAME_BY_LOGIN_SQL);
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getLastName());
        stmt.setString(3, user.getLogin());
        int quantity = stmt.executeUpdate(); // login is unique, will always be 0 or 1

        System.out.println(user);
        System.out.println(quantity + " user with login= '" + user.getLogin() + "' has been updated");
    }





}
