package com.example.demo.students.domain;

public class StudentName {
    private final String name;

    private StudentName(String name) {
        this.name = name;
    }

    public static StudentName fromString(String name) {
        return new StudentName(name);
    }

    public String getValue() {
        return name;
    }
}
