package homeworks.lecture15;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import static java.lang.Class.forName;

public class DriverManagerExample {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        //Class.forName("com.mysql.jdbc.Driver");
        //Driver driver = (Driver) forName("com.mysql.jdbc.Driver").newInstance();
        /*DriverManager.registerDriver(driver);*/
        while (drivers.hasMoreElements()) {
            System.out.println(drivers.nextElement());
        }
    }
}
