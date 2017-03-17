package homeworks.lecture4.sort;

import java.util.Arrays;

public class HugeArraySorter {
    public static void main(String[] args) {
        int[] hugeArray = ArrayCreator.createHugeArray(10);
        System.out.println(Arrays.toString(hugeArray));

        int[] arrayCounter = new int [10];
        for (int i = 0; i < hugeArray.length; i++) {
            int tmp = hugeArray[i];
            System.out.println(tmp);

            int position = 0;
            for(int j = 0; j <= hugeArray[i]; j++) {
                position += arrayCounter[j];
            }
            System.out.println(position);
            System.out.println(Arrays.toString(arrayCounter));
            System.arraycopy(hugeArray, position + 1, hugeArray, position + 1, hugeArray.length - position - 1);
            hugeArray[position] = tmp;
            System.out.println(Arrays.toString(hugeArray));
            arrayCounter[tmp]++;
            System.out.println("");
        }




        /*
        Solution#2
        int[] arrayCounter = new int [10];
        for (int i = 0; i < hugeArray.length; i++) {
            arrayCounter[hugeArray[i]]++;
        }

        int startPosition = 0;
        for(int i = 0; i < arrayCounter.length; i++) {
            Arrays.fill(hugeArray, startPosition, startPosition + arrayCounter[i], i);
            startPosition += arrayCounter[i];
        }
        */

        System.out.println(Arrays.toString(hugeArray));

        for (int index = 0; index < hugeArray.length - 1; index++) {
            if (hugeArray[index] > hugeArray[index + 1]) {
                System.out.println("Sort failed!!!");
                return;
            }
        }



        System.out.println("Sort successful!!");
    }
}
