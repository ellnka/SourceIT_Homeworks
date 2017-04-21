package homeworks.sorts;


import java.util.Arrays;

/**
 * Created by Elena Y on 4/8/2017.
 */
public class SingleThreadedMergeSort {

    public static void main(String[] args) {
        int[] hugeArray = ArrayFunctions.createHugeArray(1000);
        long startTime = System.currentTimeMillis();
        int[] result = mergeSort(hugeArray);
        long endTime   = System.currentTimeMillis();
        System.out.println("Single threaded merge sort took " + (endTime - startTime) + " ms");
        //System.out.println(Arrays.toString(result));
    }

    public static int[] mergeSort(int[] array) {
        return doMergeSort(
                Arrays.copyOfRange(array, 0, array.length / 2),
                Arrays.copyOfRange(array, array.length / 2, array.length));
    }


    private static int[] doMergeSort(int[] left, int[] right) {
        if (left.length > 1) {
            left = doMergeSort(Arrays.copyOfRange(left, 0, left.length / 2),
                    Arrays.copyOfRange(left, left.length / 2, left.length));
        }
        if (right.length > 1) {
            right = doMergeSort(Arrays.copyOfRange(right, 0, right.length / 2),
                    Arrays.copyOfRange(right, right.length / 2, right.length));
        }
        int[] result = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        for (int index = 0; index < result.length; index++) {
            if (leftIndex > left.length - 1) {
                System.arraycopy(right, rightIndex, result, index, result.length - index);
                break; //for
            }
            if (rightIndex > right.length - 1) {
                System.arraycopy(left, leftIndex, result, index, result.length - index);
                break; //for
            }
            if (left[leftIndex] > right[rightIndex]) {
                result[index] = right[rightIndex++];
            } else {
                result[index] = left[leftIndex++];
            }
        }

        return result;
    }





}
