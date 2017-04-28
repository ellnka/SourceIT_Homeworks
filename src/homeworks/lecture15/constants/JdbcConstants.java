package homeworks.lecture15.constants;

public class JdbcConstants {
    public final static String CONNECTION_URL       = "jdbc:mysql://127.0.0.1:3306/SourceIt?" +
                                                        "autoReconnect=true&useSSL=false" +
                                                        "&user=root&password=12345";

    public final static String SELECT_USER_BY_ID_SQL = "SELECT \n" +
            "    U.ID,\n" +
            "    U.NAME,\n" +
            "    U.LASTNAME,\n" +
            "    U.LOGIN,\n" +
            "    U.PASSWORD,\n" +
            "    U.EMAIL,\n" +
            "    U.USER_ROLE_ID,\n" +
            "    UR.ROLE\n" +
            "FROM\n" +
            "    USERS U\n" +
            "        INNER JOIN\n" +
            "    USER_ROLES UR ON U.USER_ROLE_ID = UR.ID" +
            " WHERE U.ID = ?";


    public final static String INSERT_USER_SQL      = "INSERT INTO USERS (NAME, LASTNAME, LOGIN, PASSWORD, EMAIL, " +
                                                      "USER_ROLE_ID) VALUES (?, ?, ?, ?, ?, ?)";

    public final static String DELETE_USER_SQL      = "DELETE FROM USERS WHERE ID > ?";

    public final static String SELECT_ALL_NEW_USERS_SQL = "SELECT \n" +
            "    U.ID,\n" +
            "    U.NAME,\n" +
            "    U.LASTNAME,\n" +
            "    U.LOGIN,\n" +
            "    U.PASSWORD,\n" +
            "    U.EMAIL,\n" +
            "    U.USER_ROLE_ID,\n" +
            "    UR.ROLE\n" +
            "FROM\n" +
            "    USERS U\n" +
            "        INNER JOIN\n" +
            "    USER_ROLES UR ON U.USER_ROLE_ID = UR.ID;";

    public final static String SELECT_ALL_ROLES_SQL = "SELECT \n"+
            "    ID, ROLE\n"+
            "FROM\n"+
            "    USER_ROLES";

    public final static String UPDATE_USER_ALL_ATTR_BY_ID_SQL = "UPDATE USERS \n"+
            "SET \n"+
            "    NAME = ?,\n"+
            "    LASTNAME = ?,\n"+
            "    LOGIN = ?,\n"+
            "    PASSWORD = ?,\n"+
            "    EMAIL = ?,\n"+
            "    USER_ROLE_ID = ?\n"+
            "WHERE\n"+
            "    ID = ?;";


    public final static String UPDATE_USER_NAME_BY_LOGIN_SQL = "UPDATE USERS \n"+
            "SET \n"+
            "    NAME = ?,\n"+
            "    LASTNAME = ?\n"+
            "WHERE\n"+
            "    LOGIN LIKE ?;";


    private JdbcConstants() {}
}
