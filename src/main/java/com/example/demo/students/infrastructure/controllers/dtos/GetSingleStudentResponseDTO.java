package com.example.demo.students.infrastructure.controllers.dtos;

import com.example.demo.students.domain.Student;

import java.util.Date;

public record GetSingleStudentResponseDTO(String id, String name, String email, Date birthdate) {
    public static GetSingleStudentResponseDTO fromDomain(Student student) {
        var primitives = student.toPrimitives();
        return new GetSingleStudentResponseDTO(primitives.id(), primitives.name(), primitives.email(), primitives.birthdate());
    }
}
