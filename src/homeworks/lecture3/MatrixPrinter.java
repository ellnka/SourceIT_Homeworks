package homeworks.lecture3;

import java.util.Arrays;

public class MatrixPrinter {
    public static void main(String[] args) {
        int[][] array = {
            {1, 2, 3, 4},
            {3, 4, 5, 6},
            {7, 5, 4, 1}
        };

        /* Possible solution: */

        for (int[] arrayRow: array) {
            for (int i = 0; i < arrayRow.length; i++) {
                System.out.print((i > 0 ? ", " : "") + arrayRow[i]);
            }
            System.out.println("");
           // System.out.println(Arrays.toString(arrayRow));
        }

    }
}
