package homeworks.lecture8;

import java.util.*;

public class AnagramSorter {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("done", "none", "node", "neno", "onion", "deno", "gram", "ramg", "nioon");

        Map<String, LinkedList<String>> mapOfAnagramms = new HashMap<>();
        for (String string: strings) {
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            String sortedString = new String(chars);

            LinkedList<String> listOfAnagramms = mapOfAnagramms.get(sortedString);
            if (listOfAnagramms == null) {
                listOfAnagramms = new LinkedList<>();
            }
            listOfAnagramms.add(string);

            mapOfAnagramms.put(sortedString, listOfAnagramms);
        }

        for (Map.Entry<String, LinkedList<String>> entry : mapOfAnagramms.entrySet()) {
            System.out.println(entry.getKey() + ":  " + entry.getValue().toString());
        }
    }




}
