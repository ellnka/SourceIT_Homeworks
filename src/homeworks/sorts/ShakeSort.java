package homeworks.sorts;


/**
 * Created by ElenaY on 20/04/2017.
 */
public class ShakeSort {
    public static void main(String[] args) {
        int[] hugeArray = ArrayFunctions.createRandomArray(100_000, 100);

        long start = System.currentTimeMillis();
        shakeSort(hugeArray);
        long end = System.currentTimeMillis();

        System.out.println("Shake sort took " + (end - start) + " ms");
        if (ArrayFunctions.isArraySorted(hugeArray)) {
            System.out.println("Success!");
        } else {
            System.out.println("Fail!");
        }
    }

    public static void shakeSort(int[] array) {
        if (array.length < 2) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            boolean isAlreadySorted = true;
            for (int j = i + 1; j < array.length - i; j++) {
                // -->
                if (array[j - 1] > array[j]) {
                    int t = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = t;
                    isAlreadySorted = false;
                }
                // <--
                if (array[array.length - j] < array[array.length  - j - 1]) {
                    int t = array[array.length - j];
                    array[array.length - j] = array[array.length - j - 1];
                    array[array.length - j - 1] = t;
                    isAlreadySorted = false;
                }
            }
            //System.out.println(Arrays.toString(array));
            if (isAlreadySorted) {
                return;
            }
        }
    }
}
