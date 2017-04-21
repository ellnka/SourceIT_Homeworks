package homeworks.lecture4.sort;

import java.util.Random;

public class ArrayCreator {
    public static int[] createHugeArray(int n) {
        Random random = new Random();
        int[] result = new int[random.nextInt(1_000_000) + 1_000_000];
       // int[] result = new int[random.nextInt(10) + 10];
        for(int index = 0; index < result.length; index++) {
            result[index] = random.nextInt(n);
        }
        return result;
    }

}
