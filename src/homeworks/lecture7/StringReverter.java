package homeworks.lecture7;

import java.util.ArrayList;
import java.util.Collections;

public class StringReverter {

    public static String revertUsingCharArray(String string) {
        if (!canIncomingStringBeReverted(string)) {
            return string;
        }

        char[] charArray = string.toCharArray();
        int fullLength = charArray.length;
        int halfLength = fullLength / 2;
        for (int i = 0; i < halfLength; i++)
        {
            char temp = charArray[i];
            charArray[i] = charArray[fullLength - 1 - i];
            charArray[fullLength - 1 - i] = temp;
        }
        return new String(charArray);
    }


    public static String revertUsingStringArray(String string) {
        if (!canIncomingStringBeReverted(string)) {
            return string;
        }

        String result = "";
        String[] stringArray = string.split("");
        for (int i = stringArray.length - 1; i >= 0; i--) {
            result += stringArray[i];
        }

        return result;
    }



    public static String revertUsingCollections(String string) {
        if (!canIncomingStringBeReverted(string)) {
            return string;
        }

        ArrayList<String> stringArrayList = new ArrayList<>();
        for(String c: string.split("")) {
            stringArrayList.add(c);
        }
        Collections.reverse(stringArrayList);

        String result = "";
        for (int i = 0; i < stringArrayList.size(); i++) {
            result += stringArrayList.get(i);
        }

        return result;
    }


    public static String revertUsingStringBuilder(String string) {
        if (!canIncomingStringBeReverted(string)) {
            return string;
        }

        return new StringBuilder(string).reverse().toString();
    }


    public static boolean canIncomingStringBeReverted(String string) {
        if (string == null || string.trim().length() < 2 ) {
            return false;
        }
        return true;
    }
}
