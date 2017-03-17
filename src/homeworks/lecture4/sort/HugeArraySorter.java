package homeworks.lecture4.sort;

import java.util.Arrays;

public class HugeArraySorter {
    public static void main(String[] args) {
        int[] hugeArray = ArrayCreator.createHugeArray(10);
        //System.out.println(Arrays.toString(hugeArray));


        //Solution#1 - much faster than #2
        int[] arrayCounter = new int [10];
        for (int i = 0; i < hugeArray.length; i++) {
            arrayCounter[hugeArray[i]]++;
        }

        int startPosition = 0;
        for(int i = 0; i < arrayCounter.length; i++) {
            Arrays.fill(hugeArray, startPosition, startPosition + arrayCounter[i], i);
            startPosition += arrayCounter[i];
        }


        /*
        //Solution #2
        int[] arrayCounter = new int [10];
        for (int i = 0; i < hugeArray.length; i++) {
            int element = hugeArray[i];

            int position = 0;
            for(int j = 0; j <= hugeArray[i]; j++) {
                position += arrayCounter[j];
            }
            System.arraycopy(hugeArray, position, hugeArray, position + 1, i - position );
            hugeArray[position] = element;
            arrayCounter[element]++;
        }*/

       // System.out.println(Arrays.toString(hugeArray));

        for (int index = 0; index < hugeArray.length - 1; index++) {
            if (hugeArray[index] > hugeArray[index + 1]) {
                System.out.println("Sort failed!!!");
                return;
            }
        }



        System.out.println("Sort successful!!");
    }
}
