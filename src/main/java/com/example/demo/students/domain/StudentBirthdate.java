package com.example.demo.students.domain;

import java.util.Date;

public class StudentBirthdate {
    private final Date birthdate;

    private StudentBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public static StudentBirthdate fromDate(Date birthdate) {
        return new StudentBirthdate(birthdate);
    }

    public Date getValue() {
        return birthdate;
    }
}
