package com.lvl.university.model;

public class Employee extends Person {
    
    public Employee(String name) {
        super(name);
    }

    private double salary;
    
    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public void setName(String name, Person person) {
        person.name = name;
    }

}
