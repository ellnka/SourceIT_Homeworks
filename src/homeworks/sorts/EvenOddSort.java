package homeworks.sorts;


import java.util.Arrays;

/**
 * Created by ElenaY on 20/04/2017.
 */
public class EvenOddSort {

    public static void main(String[] args) {
        int[] hugeArray = ArrayFunctions.createRandomArray(100_000, 100);
        long start = System.currentTimeMillis();
        evenOddSort(hugeArray);
        long end = System.currentTimeMillis();
        System.out.println("Even-Odd sort took " + (end - start) + " ms");
        if (ArrayFunctions.isArraySorted(hugeArray)) {
            System.out.println("Success!");
        } else {
            System.out.println("Fail!");
        }
    }

    public static void evenOddSort(int[] array) {
        if (array.length < 2) {
            return;
        }

        boolean isOddLoop = false;
        int sortedLoopCount = 0;
        int i = 0;
        while (sortedLoopCount < 2) {
            if ((i + 1) >= array.length) {
                sortedLoopCount++;
                isOddLoop = !isOddLoop;
                i = (isOddLoop) ? 1 : 0;
            }

            if (array[i] > array[i + 1]) {
                int t = array[i + 1];
                array[i + 1] = array[i];
                array[i] = t;
                sortedLoopCount = 0;
            }
            i += 2;
        }
    }
}
