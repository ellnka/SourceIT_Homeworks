package edu.source.it.lectures.lecture5.examples.oop;

public class Employee {
    private String firstName;
    private String lastName;
    protected int salary;

    public Employee() {
        System.out.println("In employee constructor");
    }

    public Employee(String firstName, String lastName, int salary) {
        //System.out.println("In Employee constructor");
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public void increaseSalary(int amount) {
        salary += amount;
    }

    public int getSalary() {
        return salary;
    }
}
