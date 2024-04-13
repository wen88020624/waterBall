package com.example.demo.Manager;

import java.util.Collection;
import java.util.HashSet;

public class Manager extends Employee {
    private Collection<Employee> employees = new HashSet<>();
    public void manage(Employee employee) {
        employees.add(employee);
        employee.setManager(this);
    }
}
