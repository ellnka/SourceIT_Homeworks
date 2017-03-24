package homeworks.lecture6.tanks;

public class TankTest {
    public static void main(String[] args) {
        try {
            Tank tank = new Tank(2);
            tank.fire();
            tank.load();
            tank.load();
            tank.fire();
            tank.load();
            tank.fire();
            tank.load();
        } catch (TankException te) {
            System.err.println(te.getMessage());
        }
    }
}
