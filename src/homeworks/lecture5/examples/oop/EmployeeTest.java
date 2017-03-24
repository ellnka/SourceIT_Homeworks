package edu.source.it.lectures.lecture5.examples.oop;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee employee1 = new Employee("John", "Smith", 1000_00);
        Manager manager = new Manager("Mary", "Queen", 2000_00);

        manager.getSalary();
        manager.increaseSalary(100_00);
        System.out.println(employee1.salary);
        System.out.println(manager.salary);
        manager = new Manager();
    }
}
