package homeworks.lecture3;

import java.util.Arrays;

public class MatrixInverter {
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3, 4},
                {3, 4, 5, 6},
                {7, 5, 4, 1},
                {7, 5, 4, 1}
        };

        /* Solution: */

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != array.length) {
                System.out.println("Sorry, we cannot invert your matrix. It's not a square");
                break;
            }
            for (int j = 0; j < i && i < array[i].length; j++) {
                int temp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = temp;
            }
        }

        for (int[] arrayRow: array) {
            System.out.println(Arrays.toString(arrayRow));
        }


    }
}
