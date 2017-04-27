package homeworks.lecture15;


import homeworks.lecture15.model.User;
import homeworks.lecture15.model.UserRole;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

import static homeworks.lecture15.constants.JdbcConstants.*;
import static homeworks.lecture15.constants.JdbcConstants.SELECT_ALL_NEW_USERS_SQL;

public class SelectAllUsersExample {

    public static void main(String[] args) {
        ArrayList<User> userArrayList = selectAllUsersInArrayList();
        for (User user: userArrayList) {
            System.out.println(user);
        }
    }

    public static ArrayList<User> selectAllUsersInArrayList() {
        ArrayList<User> userArrayList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(CONNECTION_URL)){
            PreparedStatement stmt = con.prepareStatement(SELECT_ALL_NEW_USERS_SQL);
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
                userArrayList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userArrayList;

    }
}
