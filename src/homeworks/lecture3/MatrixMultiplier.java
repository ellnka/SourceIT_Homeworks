package homeworks.lecture3;

import java.util.Arrays;

public class MatrixMultiplier {
    public static void main(String[] args) {
        
        int[][] first = {
                {1, 2, 3, 4},
                {3, 4, 5, 6},
                {7, 5, 4, 1}
        };

        int[][] second = {
                {1, 2, 3},
                {3, 4, 6},
                {7, 5, 1},
                {3, 4, 6}
        };


        /*  Solution: */

        if (first.length > 0 && first[0].length != second.length) {
            System.out.println( "Matrices cannot be multiplied. " +
                "The number of columns of the first matrix must be the same " +
                    "as the number of rows of the second matrix.");
            return;
        }

        int height = first.length;
        int width = second.length > 0 ? second[0].length : 0;
        int[][] result = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                for(int k = 0; k < second.length; k++ ) {
                    result[i][j] += first[i][k] * second[k][j];
                }
            }
        }

        for (int[] array: result) {
             System.out.println(Arrays.toString(array));
        }


    }
}
