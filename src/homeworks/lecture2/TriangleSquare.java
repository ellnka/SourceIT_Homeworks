package homeworks.lecture2;

public class TriangleSquare {
    public static void main(String[] args) {
        int x1 = 1000000000, y1 = 1000000000;
        int x2 = 1000000000, y2 = 700000000;
        int x3 = -300000000, y3 = 400000000;

        float length = 0;
        float square = 0;
        float p = 0;

        // the task requires float... so I've converted to float everywhere. double would not require converting


/*
        length  = (float) Math.sqrt((Math.pow((x1 - x2), 2))+(Math.pow((y1 - y2), 2)));
        length += (float) Math.sqrt((Math.pow((x2 - x3), 2))+(Math.pow((y2 - y3), 2)));
        length += (float) Math.sqrt((Math.pow((x1 - x3), 2))+(Math.pow((y1 - y3), 2)));
*/
        length =  (float) (Math.hypot(x1 - x2, y1 - y2) + Math.hypot(x2 - x3, y2 - y3) + Math.hypot(x1 - x3, y1 - y3));

        p = length/2;
        square = (float) Math.sqrt( p*(p - Math.hypot(x1 - x2, y1 - y2))*(p - Math.hypot(x2 - x3, y2 - y3))*(p - Math.hypot(x1 - x3, y1 - y3)) );

        System.out.println("Length of all sides is " + length);
        System.out.println("Square is " + square);
    }
}
