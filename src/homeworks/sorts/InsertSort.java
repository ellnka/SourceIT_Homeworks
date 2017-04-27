package homeworks.sorts;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {

        int[] hugeArray = ArrayFunctions.createRandomArray(100_000, 100);
        long start = System.currentTimeMillis();
        insertSortSwappingElements(hugeArray);
        long end = System.currentTimeMillis();
        System.out.println("Insert sort swapping elements took " + (end - start) + " ms");

        start = System.currentTimeMillis();
        insertSortCopyArray(hugeArray);
        end = System.currentTimeMillis();
        System.out.println("Insert sort copying arrays took " + (end - start) + " ms");
    }

    public static void insertSortSwappingElements(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j - 1] > array[j]; j--) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }

            }
        }
    }

    public static void insertSortCopyArray(int[] array) {
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
    }
}
