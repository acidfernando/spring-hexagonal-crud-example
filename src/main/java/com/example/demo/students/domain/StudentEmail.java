package com.example.demo.students.domain;

public class StudentEmail {
    private final String email;

    private StudentEmail(String email) {
        this.email = email;
    }

    public static StudentEmail fromString(String email) {
        return new StudentEmail(email);
    }

    public String getValue() {
        return email;
    }
}
