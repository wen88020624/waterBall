package com.example.demo.registration;

public class Registration {
    private School school;
    private Student student;
    private int entranceScore;

    public Registration(School school, Student student, int entranceScore) {
        this.school = school;
        this.student = student;
        this.entranceScore = entranceScore;
    }
}
