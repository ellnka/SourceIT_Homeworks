package homeworks.lecture2;

public class ClockAngel {

    public static void main(String[] args) {
        int hours = 4;
        int mins = 45;
        float result = 0;

        if(hours >= 0 && hours <= 12 && mins >= 0 && mins <= 60) {
            result = Math.abs((360.00f / 12.00f) * hours + (360.00f / 12.00f / 60.00f * mins) - (360.00f / 60.00f) * mins);
            result = result > 180 ? 360 - result : result;
            System.out.println("Angle between hours and minute narrows is " + result);
        } else {
            System.out.println("Please enter correct hours and minutes");
        }
    }

}
