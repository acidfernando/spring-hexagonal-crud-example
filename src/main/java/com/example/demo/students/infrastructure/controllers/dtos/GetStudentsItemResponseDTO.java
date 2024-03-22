package com.example.demo.students.infrastructure.controllers.dtos;

import com.example.demo.students.domain.Student;

import java.util.Date;

public record GetStudentsItemResponseDTO(String id, String name, String email, Date birthdate) {

    public static GetStudentsItemResponseDTO fromDomain(Student student) {
        var primitives = student.toPrimitives();
        return new GetStudentsItemResponseDTO(primitives.id(), primitives.name(), primitives.email(), primitives.birthdate());
    }
}
