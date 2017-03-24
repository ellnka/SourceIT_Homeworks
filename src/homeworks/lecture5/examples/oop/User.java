package edu.source.it.lectures.lecture5.examples.oop;

public class User {

    public static int count;

    static {
        count = 123;
        System.out.println("Static init");
    }

    {
        System.out.println("Before Constructor");
        count = 0;
    }
    public User() {
        System.out.println("User's constructor");
    }

    public static void doNothing() {} //For magic
}
