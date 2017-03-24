package edu.source.it.lectures.lecture5.examples.oop;

public class TestObject {
    private int smth;

    public TestObject() {
        this(Integer.MIN_VALUE);
    }

    public TestObject(int smth) {
        this.smth = smth;
    }

    public TestObject(Object o) {

    }

    public static void main(String[] args) {
        TestObject testObject = new TestObject();
        TestObject testObject1 = new TestObject(1);
    }
}
