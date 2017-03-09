package homeworks.lecture2;

public class SwitchValues {

    public static void main(String[] args) {

        int first = 1;
        int second = 122;

        first = first + second;
        second = first - second;
        first =  first - second;

        System.out.println("First = " + first + " , second = " + second);
    }

}
