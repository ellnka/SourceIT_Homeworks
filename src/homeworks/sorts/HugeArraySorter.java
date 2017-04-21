package homeworks.sorts;


import java.util.Arrays;

public class HugeArraySorter {
    public static void main(String[] args) {
        int[] hugeArray = ArrayFunctions.createHugeArray(10);
        //System.out.println(Arrays.toString(hugeArray));


        //Solution#1 - much faster than #2
        int[] arrayOfCounters = new int [10];
        for (int i = 0; i < hugeArray.length; i++) {
            arrayOfCounters[hugeArray[i]]++;
        }

        int startPosition = 0;
        for(int i = 0; i < arrayOfCounters.length; i++) {
            Arrays.fill(hugeArray, startPosition, startPosition + arrayOfCounters[i], i);
            startPosition += arrayOfCounters[i];
        }


        /*
        //Solution #2
        int[] arrayOfCounters = new int [10];
        for (int i = 0; i < hugeArray.length; i++) {
            int element = hugeArray[i];

            int position = 0;
            for(int j = 0; j <= hugeArray[i]; j++) {
                position += arrayOfCounters[j];
            }
            System.arraycopy(hugeArray, position, hugeArray, position + 1, i - position );
            hugeArray[position] = element;
            arrayOfCounters[element]++;
        }*/

       // System.out.println(Arrays.toString(hugeArray));

        if (ArrayFunctions.isArraySorted(hugeArray)) {
            System.out.println("Success!");
        } else {
            System.out.println("Fail!");
        }
    }
}
