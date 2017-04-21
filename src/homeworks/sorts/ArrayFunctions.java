package homeworks.sorts;

import java.util.Random;

public class ArrayFunctions {
    public static int[] createHugeArray(int maxRange) {
        Random random = new Random();
        int[] result = new int[random.nextInt(1_000_000) + 1_000_000];
       // int[] result = new int[random.nextInt(10) + 10];
        for(int index = 0; index < result.length; index++) {
            result[index] = random.nextInt(maxRange);
        }
        return result;
    }

    public static int[] createRandomArray(int length, int maxRange) {
        Random random = new Random();
        int[] result = new int[length];
        // int[] result = new int[random.nextInt(10) + 10];
        for(int index = 0; index < result.length; index++) {
            result[index] = random.nextInt(maxRange);
        }
        return result;
    }

    public static boolean isArraySorted (int[] array) {
        for (int index = 0; index < array.length - 1; index++) {
            if (array[index] > array[index + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void swapElements(int[] array, int firstIndex, int secondIndex) {
        if (firstIndex != secondIndex && array.length > firstIndex && array.length > secondIndex) {
            int t = array[firstIndex];
            array[firstIndex] = array[secondIndex];
            array[secondIndex] = t;
        }
    }


}
