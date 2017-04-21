package homeworks.sorts;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by ElenaY on 21/04/2017.
 */

public class QuickSort {

    public static void main(String[] args) {
        int[] hugeArray = ArrayFunctions.createRandomArray(100_000, 100);

        long startTime = System.currentTimeMillis();
        quickSort(hugeArray);
        long endTime   = System.currentTimeMillis();
        System.out.println("Quick sort took " + (endTime - startTime) + " ms");

        if (ArrayFunctions.isArraySorted(hugeArray)) {
            System.out.println("Success!");
        } else {
            System.out.println("Fail!");
        }
    }

    public static void quickSort(int[] array) {
        if (array.length < 2) {
            return;
        }
        doQuickSort(array, 0, array.length - 1);
        //System.out.println(Arrays.toString(array));
    }

    public static void doQuickSort(int[] array, int left, int right) {
        Random random = new Random();
        if(left >= right) {
            return;
        }

        int keyIndex = left + random.nextInt((right - left));
        int keyValue = array[keyIndex];

        ArrayFunctions.swapElements(array, keyIndex, right);
        int pivotIndex = left;
        for (int i = left; i < right; i++) {
            if (array[i] < keyValue) {
                ArrayFunctions.swapElements(array, i, pivotIndex++);
            }
        }
        ArrayFunctions.swapElements(array, pivotIndex, right);

        doQuickSort(array,left, pivotIndex - 1);
        doQuickSort(array,pivotIndex + 1, right);
    }

}
