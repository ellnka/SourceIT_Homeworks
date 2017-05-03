package homeworks.lecture15;

import homeworks.lecture15.model.User;

import java.sql.*;

import static homeworks.lecture15.constants.JdbcConstants.*;

public class UpdateUserExample {
    public static void main(String[] args) {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(CONNECTION_URL);
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

            if (updateRandomUserAllAttributesById(connection) > 0) {
                connection.commit();
            } else {
                connection.rollback();
            }

            if (updateRandomUserNameByLogin(connection) > 0) {
                connection.commit();
            } else {
                connection.rollback();
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException rollbackException) { /* NOP */  }
            }
        }
    }



    private static int updateRandomUserAllAttributesById(Connection con) throws SQLException {
        User user = RandomUser.getRandomUserFromDB();
        user = RandomUser.updateRandomUser(user);
        if (user == null) {
            return 0;
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
        return  quantity;
    }


    private static int updateRandomUserNameByLogin(Connection con) throws SQLException {
        User user = RandomUser.getRandomUserFromDB();
        if (user == null) {
            return 0;
        }
        user.setName("Lisa");
        user.setLastName("Simpson");

        PreparedStatement stmt = con.prepareStatement(UPDATE_USER_NAME_BY_LOGIN_SQL);
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getLastName());
        stmt.setString(3, user.getLogin());
        int quantity = stmt.executeUpdate(); // login is unique, will always be 0 or 1

        System.out.println(quantity + " user with login= '" + user.getLogin() + "' has been updated");
        return quantity;
    }





}
