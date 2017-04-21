package homeworks.sorts;


/**
 * Created by ElenaY on 21/04/2017.
 * "сортировка рассчёской"
 */
public class CombSort {
    public static void main(String[] args) {
        int[] hugeArray = ArrayFunctions.createRandomArray(100_000, 100);
        long start = System.currentTimeMillis();
        combSort(hugeArray);
        long end = System.currentTimeMillis();
        System.out.println("Comb sort took " + (end - start) + " ms");
        if (ArrayFunctions.isArraySorted(hugeArray)) {
            System.out.println("Success!");
        } else {
            System.out.println("Fail!");
        }
    }

    public static void combSort(int[] array) {
        if (array.length < 2) {
            return;
        }
        // Reduction factor = 1 / (1 - 1/Math.pow(e, phi))
        double factor = 1.247330950103979;
        int step = (int)(array.length / factor);

        while (step > 0) {
            step--;
            int i = 0;
            while ((i + step) < array.length) {
                if (array[i] > array[i + step]) {
                    int t = array[i];
                    array[i] = array[i + step];
                    array[i + step] = t;
                }
                i++;
            }
        }
    }
}
