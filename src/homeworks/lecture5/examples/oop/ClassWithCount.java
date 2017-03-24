package edu.source.it.lectures.lecture5.examples.oop;

public class ClassWithCount {
    private static int counter = 0;

    public ClassWithCount() {
        counter++;
    }

    public static int getCount() {
        return counter;
    }
}
