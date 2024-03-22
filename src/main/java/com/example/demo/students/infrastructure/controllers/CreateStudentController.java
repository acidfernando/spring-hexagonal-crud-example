package com.example.demo.students.infrastructure.controllers;

import com.example.demo.students.application.useCases.CreateStudent;
import com.example.demo.students.domain.StudentBirthdate;
import com.example.demo.students.domain.StudentEmail;
import com.example.demo.students.domain.StudentId;
import com.example.demo.students.domain.StudentName;
import com.example.demo.students.infrastructure.controllers.dtos.CreateStudentRequestDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController()
public class CreateStudentController {

    private final CreateStudent createStudent;

    public CreateStudentController(CreateStudent createStudent) {
        this.createStudent = createStudent;
    }

    @PostMapping("/api/v1/students")
    public void createStudentEndpoint(@Valid @RequestBody CreateStudentRequestDTO body) {
        var studentId = StudentId.fromString(UUID.randomUUID().toString());
        this.createStudent.execute(studentId, StudentName.fromString(body.name), StudentEmail.fromString(body.email), StudentBirthdate.fromDate(body.birthdate));
    }
}
