package com.example.demo.students.domain;

import com.example.demo.students.domain.primitives.StudentPrimitives;

import java.util.Date;

public class Student {
    private StudentId id;
    private StudentName name;
    private StudentEmail email;
    private StudentBirthdate birthdate;

    private int age;


    private Student(StudentId id, StudentName name, StudentEmail email, StudentBirthdate birthdate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthdate = birthdate;
    }

    public static Student createStudent(StudentId id, StudentName name, StudentEmail email, StudentBirthdate birthdate) {
        return new Student(id, name, email, birthdate);
    }

    public StudentPrimitives toPrimitives() {
        return new StudentPrimitives(id.getValue(), name.getValue(), email.getValue(), birthdate.getValue());
    }

    public static Student fromPrimitives(StudentPrimitives primitives) {
        return Student.createStudent(StudentId.fromString(primitives.id()), StudentName.fromString(primitives.name()), StudentEmail.fromString(primitives.email()), StudentBirthdate.fromDate(primitives.birthdate()));
    }

    public void update(StudentName name, StudentEmail email, StudentBirthdate birthdate) {
        this.name = name;
        this.email = email;
        this.birthdate = birthdate;
    }
}
