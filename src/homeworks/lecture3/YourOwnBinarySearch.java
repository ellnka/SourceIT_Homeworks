package homeworks.lecture3;

public class YourOwnBinarySearch {


    /* Your code here */
    public static void main(String[] args) {
        int[] array = {1, 4, 7, 10, 17, 30, 48};
        int element = 10;
        System.out.println(binarySearch(array, element));
    }

    public static int binarySearch(int[] array, int element) {
        int left = 0;
        int right = array.length - 1;
        int result = -1;

        while (left <= right) {
            int m = (left + right)/2;

            if (array[m] == element) {
                result = m;
                break;
            }

            left = (array[m] < element) ? m + 1 : left ;
            right = (array[m] > element) ? m - 1 : right ;
        }
        return result;
    }



}
