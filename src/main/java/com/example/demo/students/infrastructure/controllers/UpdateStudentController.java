package com.example.demo.students.infrastructure.controllers;

import com.example.demo.students.application.useCases.UpdateStudent;
import com.example.demo.students.domain.StudentBirthdate;
import com.example.demo.students.domain.StudentEmail;
import com.example.demo.students.domain.StudentId;
import com.example.demo.students.domain.StudentName;
import com.example.demo.students.infrastructure.controllers.dtos.UpdateStudentRequestDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateStudentController {
    private final UpdateStudent updateStudent;

    public UpdateStudentController(UpdateStudent updateStudent) {
        this.updateStudent = updateStudent;
    }

    @PutMapping("api/v1/students/{studentId}")
    public void updateStudentEndpoint(@PathVariable String studentId, @Validated @RequestBody UpdateStudentRequestDTO body) {
        this.updateStudent.execute(StudentId.fromString(studentId), StudentName.fromString(body.name), StudentEmail.fromString(body.email), StudentBirthdate.fromDate(body.birthdate));
    }
}
