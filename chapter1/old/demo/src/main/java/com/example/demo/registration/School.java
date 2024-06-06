package com.example.demo.registration;

import java.util.Collection;
import java.util.HashSet;

public class School {
    private Collection<Registration> registrations = new HashSet<>();

    public Registration register(Student student, int entranceScore) {
        var registration = new Registration(this, student, entranceScore);
        registrations.add(registration);
        student.setRegistration(registration);
        return registration;
    }
}
