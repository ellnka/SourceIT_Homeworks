package homeworks.lecture7;

public class StringReverterExample {
    public static void main(String[] args) {

        String s = "BLA-bla-Bla...";
        System.out.println("Original string: " + s);
        System.out.println("Reversion using a string array: " + StringReverter.revertUsingStringArray(s));
        System.out.println("Reversion using a char array: " + StringReverter.revertUsingCharArray(s));
        System.out.println("Reversion using collections: " + StringReverter.revertUsingCollections(s));
        System.out.println("Reversion using the StringBuilder: " + StringReverter.revertUsingStringBuilder(s));

    }


}
