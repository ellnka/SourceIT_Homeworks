package homeworks.lecture15;

import homeworks.lecture15.model.User;
import homeworks.lecture15.model.UserRole;

import java.sql.*;
import static homeworks.lecture15.constants.JdbcConstants.CONNECTION_URL;
import static homeworks.lecture15.constants.JdbcConstants.SELECT_USER_BY_ID_SQL;

public class SelectUserByIDExample {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(CONNECTION_URL);
            PreparedStatement stmt = connection.prepareStatement(SELECT_USER_BY_ID_SQL);
            stmt.setLong(1, 3);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                User user = new User(
                        rs.getLong("ID"),
                        rs.getString("NAME"),
                        rs.getString("LASTNAME"),
                        rs.getString("LOGIN"),
                        rs.getString("PASSWORD"),
                        rs.getString("EMAIl"),
                        new UserRole(rs.getLong("USER_ROLE_ID"),
                                rs.getString("ROLE"))
                );
                System.out.println(user);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException exception) { /* NOP*/ }
            }
        }
    }

}
