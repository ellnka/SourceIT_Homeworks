package homeworks.lecture4.sort;

public class HugeArraySorter {
    public static void main(String[] args) {
        int[] hugeArray = ArrayCreator.createHugeArray(10);

        /*your code here*/

        for (int index = 0; index < hugeArray.length - 1; index++) {
            if (hugeArray[index] > hugeArray[index + 1]) {
                System.out.println("Sort failed!!!");
                return;
            }
        }

        System.out.println("Sort successful!!");
    }
}
