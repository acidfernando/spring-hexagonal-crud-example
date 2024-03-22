package com.example.demo.students.domain;

public class StudentId {
    private final String id;

    private StudentId(String id) {
        this.id = id;
    }

    public static StudentId fromString(String id) {
        return new StudentId(id);
    }

    public String getValue() {
        return this.id;
    }
}
