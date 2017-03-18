package homeworks.lecture3;

import java.util.Arrays;

// please ignore it. it's not ready!!!!! I still have no time to finish it

public class WaterVolumeCalculator {

    public static void main(String[] args) {
        int[] array = {2, 5, 1, 3, 1, 2, 1, 7, 7, 6};
        int result = 0;
        int leftPeak = 0;
        int rightPeak = 0;

        for (int i = 0; i < array.length - 1; i++) {
            int tempResult = 0;
            if (array[i + 1] < array[i]) {
                leftPeak = i;
            } else if (array[i + 1] >= array[i]) {
                rightPeak = i;
            }
        }

     }
}


