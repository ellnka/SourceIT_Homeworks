package homeworks.lecture3;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] array = {100, 5, 7, 9, 15, 100, -1, 10, -1, 8, -1, 100};

        /* Solution#2 (using an arraycopy): */
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[i]) {
                    int temp = array[i];
                    System.arraycopy(array, j, array, j + 1, i - j);
                    array[j] = temp;
                    break;
                }
            }
        }

        /* Solution#1 (swapping elements): */
        /*
        //
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j - 1] > array[j]; j--) {

                if (array[j - 1] > array[j]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }

            }
        }
        */

        System.out.println(Arrays.toString(array));
    }
}
