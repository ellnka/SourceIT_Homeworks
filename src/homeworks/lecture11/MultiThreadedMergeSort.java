package homeworks.lecture11;

import homeworks.lecture4.sort.ArrayCreator;

import java.util.Arrays;

/**
 * Created by Elena Y on 4/8/2017.
 */
public class MultiThreadedMergeSort {
    public static final int MAX_THREADS = 5;

    public static void main(String[] args) {
        int[] hugeArray = ArrayCreator.createHugeArray(1000);

        long startTime = System.currentTimeMillis();
        MultiThreadedMergeSort multiThreadedMergeSort = new MultiThreadedMergeSort();
        int[] result = multiThreadedMergeSort.mergeSort(hugeArray);
        long endTime   = System.currentTimeMillis();
        System.out.println("Multithreaded merge sort took " + (endTime - startTime) + "ms");
        //System.out.println(Arrays.toString(result));

        System.out.println((isArraySorted(result)) ? "Sort successful!!" : "Sort failed!!!" );

    }

    public int[] mergeSort(int[] array) {
        return this.doMergeSort(
                Arrays.copyOfRange(array, 0, array.length / 2),
                Arrays.copyOfRange(array, array.length / 2, array.length),
                MAX_THREADS);
    }

    public static boolean isArraySorted (int[] array) {
        for (int index = 0; index < array.length - 1; index++) {
            if (array[index] > array[index + 1]) {
                return false;
            }
        }
        return true;
    }



    class MergeSortRunnable implements Runnable {
        public int[] leftArray;
        public int[] rightArray;
        public int numberOfThreads;
        public int[] result;

        public MergeSortRunnable(int[] leftArray, int[] rightArray, int numberOfThreads) {
            this.leftArray = leftArray;
            this.rightArray = rightArray;
            this.numberOfThreads = numberOfThreads;
        }

        @Override
        public void run() {
            result = doMergeSort(leftArray,rightArray, numberOfThreads);
        }

        public int[] getResult() {
            return result;
        }

    }

    private  int[] doMergeSort(int[] left, int[] right, int numberOfThreads) {
        MergeSortRunnable mergeSortRunnable = null;
        Thread thread = null;
        if (left.length > 1) {
            if(numberOfThreads <= 1) {
                left = doMergeSort(Arrays.copyOfRange(left, 0, left.length / 2),
                        Arrays.copyOfRange(left, left.length / 2, left.length), 
                                   numberOfThreads);
            } else {
                mergeSortRunnable = new MergeSortRunnable(Arrays.copyOfRange(left, 0, left.length / 2),
                        Arrays.copyOfRange(left, left.length / 2, left.length), 
                                   numberOfThreads - 1);
                thread = new Thread(mergeSortRunnable);
                thread.start();
            }
        }

        if (right.length > 1) {
            right = doMergeSort(Arrays.copyOfRange(right, 0, right.length / 2),
                    Arrays.copyOfRange(right, right.length / 2, right.length),
                                    1);
        }

        if (numberOfThreads > 1) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            left = mergeSortRunnable.getResult();
        }

        return mergeLeftAndRight(left, right);
    }


    public int[] mergeLeftAndRight(int[] left, int[] right) {
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
