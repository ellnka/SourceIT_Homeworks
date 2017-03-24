package edu.source.it.lectures.lecture5.examples.oop;

public class CounterTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        ClassWithCount first = new ClassWithCount();
        ClassWithCount second = new ClassWithCount();
        ClassWithCount third = new ClassWithCount();
        ClassWithCount fourth = ClassWithCount.class.newInstance();

        System.out.println("It was created " + ClassWithCount.getCount() +
                " instance(s) of " + ClassWithCount.class.getSimpleName());
    }
}
