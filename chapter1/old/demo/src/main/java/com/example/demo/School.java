package com.example.demo;

import java.util.Collection;
import java.util.HashSet;

public class School {
    private final Collection<Teacher> teachers = new HashSet<>();
    

    public void employ(Teacher teacher) {
        teachers.add(teacher);
        teacher.setSchool(this);
    }

    public Collection<Teacher> getTeachers() {
        return teachers;
    }
}
