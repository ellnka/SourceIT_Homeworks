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


    /**
     * Creates a new instance of User.
     * New User will have all attributes populated with random values except "id".
     * "id" will be a default int = 0
     *
     * @throws NullPointerException if User Role is null
     * @return new User object
     */
    public static User createRandomUser() {
        UserRole userRole = randomUserRole();
        if (userRole == null) {
            throw new NullPointerException("User role cannot be null. Role is mandatory for users.");
        }

        User user = new User( randomString(), randomString(), randomString(), randomString(), randomString(), userRole);
        return user;
    }

    /**
     * Updates existing instance of User.
     * User will have all attributes updated except id.
     * All other attributes will be populated with new random values.
     *
     * @throws NullPointerException if User Role is null
     * @param user point to User object which needs to be updated
     * @return updated User object
     */
    public static User updateRandomUser(User user) {
        UserRole userRole = randomUserRole();
        if (userRole == null) {
            throw new NullPointerException("User role cannot be null. Role is mandatory for users.");
        }
        if (user != null) {
            user.setName(randomString());
            user.setLastName(randomString());
            user.setLogin(randomString());
            user.setPassword(randomString());
            user.setEmail(randomString());
            user.setUserRole(userRole);
        }
        return user;
    }


    /**
     * Generates random string.
     * String has a random length from 3 to 7 chars
     * String includes randomly generated A - Z, a - z letters
     * @return random string
     */
    private static String randomString() {
        Random random = new Random();
        int length = random.nextInt(5) + 3;
        char[] result = new char[length];
        for (int i = 0; i < length; i++) {
            result[i] = (char) ((random.nextInt(26) + 65) + (random.nextInt(2) * 32)) ;
        }
        return String.valueOf(result);
    }

    /**
     *  Gets all available User Roles from a database,
     *  takes random User Role from a list and returns it.
     *  @return randomly taken User Role or null if there are no roles in a database.
     */
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

    /**
     *  Gets all available Users from a database to a list,
     *  takes random User from the list and returns it.
     *  This method can be enhanced.
     *  Current logic assumes that database doesn't contain a big amount of user records (e.g. less than 1 thousand)
     *
     * @return randomly taken User or null if there are no users in a database.
     */
    public static User getRandomUserFromDB() {
        ArrayList<User> userArrayList = SelectAllUsersExample.selectAllUsersInArrayList();
        if (userArrayList.size() > 0) {
            Random random = new Random();
            return userArrayList.get(random.nextInt(userArrayList.size()));
        } else {
            return null;
        }
    }

}
