package homeworks.lecture2;

public class TriangleSquare {
    
    public static void main(String[] args) {
        int x1 = 1, y1 = 1;
        int x2 = 10, y2 = 7;
        int x3 = -3, y3 = 4;

        float length = 0;
        float square = 0;

        /*your code here*/

        float p = 0;
        float a = (float) Math.hypot(x1 - x2, y1 - y2);
        float b = (float) Math.hypot(x2 - x3, y2 - y3);
        float c = (float) Math.hypot(x1 - x3, y1 - y3);

/*
        length  = (float) Math.sqrt((Math.pow((x1 - x2), 2))+(Math.pow((y1 - y2), 2)));
        length += (float) Math.sqrt((Math.pow((x2 - x3), 2))+(Math.pow((y2 - y3), 2)));
        length += (float) Math.sqrt((Math.pow((x1 - x3), 2))+(Math.pow((y1 - y3), 2)));
*/
        length =  a + b + c;
        p = length/2;
        square = (float) Math.sqrt( p*(p - a)*(p - b)*(p - c));

        System.out.println("Length of all sides is " + length);
        System.out.println("Square is " + square);
    }
    
}
