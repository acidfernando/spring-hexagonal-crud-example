package com.example.demo.students.infrastructure.repositories.entities;

import com.example.demo.students.domain.Student;
import com.example.demo.students.domain.primitives.StudentPrimitives;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class StudentEntity {
    @Id
    private String id;

    private String name;

    private String email;

    private Date birthdate;

    public Student toDomain() {
        var studentPrimitives = new StudentPrimitives(id, name, email, birthdate);
        return Student.fromPrimitives(studentPrimitives);
    }

    public static StudentEntity fromDomain(Student student) {
        var primitives = student.toPrimitives();
        var studentEntity = new StudentEntity();
        studentEntity.id = primitives.id();
        studentEntity.name = primitives.name();
        studentEntity.email = primitives.email();
        studentEntity.birthdate = primitives.birthdate();

        return studentEntity;
    }
}
