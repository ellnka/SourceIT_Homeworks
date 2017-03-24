package edu.source.it.lectures.lecture5.examples.oop;

public class InitSectionsExample {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        User.doNothing();
        System.out.println(User.count);
        User user = new User();
        System.out.println(User.count);

    }
}
