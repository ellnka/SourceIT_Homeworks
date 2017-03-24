package edu.source.it.lectures.lecture5.examples.oop;

public class Manager extends Employee {
    private Employee[] employees = new Employee[10];

    public Manager(String firstName, String lastName, int salary) {
        super(firstName, lastName, salary);
    }

    public Manager() {
        super();
        System.out.println("In Manager constructor");
    }

    public void add(Employee employee) {

    }

    @Override
    public void increaseSalary(int amount) {
        increaseSalary(2 * amount);
    }

    //Overload
    public void increaseSalary(int amount, int x) {

    }

    public void remove(Employee emploee) {

    }
}
