package homeworks.lecture15;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static homeworks.lecture15.constants.JdbcConstants.CONNECTION_URL;
import static homeworks.lecture15.constants.JdbcConstants.DELETE_USER_SQL;

public class DeleteUserById {
    public static void main(String[] args) {
        Connection connection = null;
        try  {
            connection = DriverManager.getConnection(CONNECTION_URL);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);

            PreparedStatement stmt = connection.prepareStatement(DELETE_USER_SQL);
            stmt.setLong(1, 8);

            int deletedRows = stmt.executeUpdate();
            System.out.println(deletedRows + " were deleted");
            connection.commit();

        } catch (SQLException exception) {
            exception.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException rollbackException) {}
            }
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {}
            }
        }
    }
}
