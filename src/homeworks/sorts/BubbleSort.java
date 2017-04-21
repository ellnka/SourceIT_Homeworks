package homeworks.sorts;

/**
 * Created by ElenaY on 20/04/2017.
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] hugeArray = ArrayFunctions.createRandomArray(100_000, 100);

        long start = System.currentTimeMillis();
        bubbleSort(hugeArray);
        long end = System.currentTimeMillis();
        System.out.println("Bubble sort took " + (end - start) + " ms");

        if (ArrayFunctions.isArraySorted(hugeArray)) {
            System.out.println("Success!");
        } else {
            System.out.println("Fail!");
        }
    }

    public static void bubbleSort(int[] array) {
        if (array.length < 2) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            boolean isAlreadySorted = true;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                   ArrayFunctions.swapElements(array, j - 1, j);
                   isAlreadySorted = false;
                }
            }
            if (isAlreadySorted) {
                return;
            }
        }
    }
}
