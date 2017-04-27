package homeworks.lecture3;

import java.util.Arrays;



public class WaterVolumeCalculator {

    public static void main(String[] args) {
        int[] array = {2, 5, 5, 5, 8, 10, 8, 5, 5, 5, 10};
        int result = 0;

        int leftPeak = 0;
        int rightPeak = 0;
        int leftIndex = 0;
        int rightIndex = array.length - 1;

        while  (leftIndex < rightIndex) {
            //
            if (array[leftIndex] > leftPeak) {
                leftPeak = array[leftIndex];
            }

            if (array[rightIndex] > rightPeak) {
                rightPeak = array[rightIndex];
            }

            if (leftPeak >= rightPeak) {
                result += rightPeak - array[rightIndex--];
            } else {
                result += leftPeak - array[leftIndex++];
            }
        }
        System.out.println(result);

    }
}


