package homeworks.lecture15;

import homeworks.lecture15.model.User;
import homeworks.lecture15.model.UserRole;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

import static homeworks.lecture15.constants.JdbcConstants.CONNECTION_URL;
import static homeworks.lecture15.constants.JdbcConstants.SELECT_ALL_ROLES_SQL;

/**
 * Created by Elena Y on 4/27/2017.
 */
public class RandomUser {

    public static User createRandomUser() {
        User user = new User();
        user.setName(randomString());
        user.setLastName(randomString());
        user.setLogin(randomString());
        user.setPassword(randomString());
        user.setEmail(randomString());
        user.setUserRole(randomUserRole());
        return user;
    }

    public static User updateRandomUser(User user) {
        user.setName(randomString());
        user.setLastName(randomString());
        user.setLogin(randomString());
        user.setPassword(randomString());
        user.setEmail(randomString());
        user.setUserRole(randomUserRole());
        return user;
    }

    private static String randomString() {
        Random random = new Random();
        int length = random.nextInt(5) + 3;
        char[] result = new char[length];
        for (int i = 0; i < length; i++) {
            result[i] = (char) ((random.nextInt(26) + 65) + (random.nextInt(2) * 32)) ;
        }
        return String.valueOf(result);
    }

    private static UserRole randomUserRole() {
        ArrayList<UserRole> userRoleArrayList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(CONNECTION_URL)) {
            PreparedStatement stmt = con.prepareStatement(SELECT_ALL_ROLES_SQL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                userRoleArrayList.add(new UserRole(rs.getLong("ID"),
                        rs.getString("ROLE")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (userRoleArrayList.size() > 0) {
            Random random = new Random();
            int randomIndex = random.nextInt(userRoleArrayList.size());
            return userRoleArrayList.get(randomIndex);
        } else {
            return null;
        }
    }

    public static User getRandomUser() {
        ArrayList<User> userArrayList = SelectAllUsersExample.selectAllUsersInArrayList();
        if (userArrayList.size() > 0) {
            Random random = new Random();
            return userArrayList.get(random.nextInt(userArrayList.size()));
        } else {
            return null;
        }
    }

}
