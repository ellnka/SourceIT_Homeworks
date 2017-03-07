package homeworks.lecture2;

public class ClockAngel {
    public static void main(String[] args) {
        float hours = 2;
        float mins = 30;
        float result = 0;


        if ( hours > 0 && hours <= 12 && mins > 0 && mins <= 60) {
            result = Math.abs((360.0f / 12.0f) * hours + 360.0f/12.0f/60.0f*mins - (360.0f / 60.0f) * mins);
            result = result > 180 ? 360 - result : result;
            System.out.println("Angle between hours and minute narrows is " + result);
        }
    }
}