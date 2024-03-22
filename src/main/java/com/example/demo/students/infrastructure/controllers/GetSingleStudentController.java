package com.example.demo.students.infrastructure.controllers;

import com.example.demo.students.application.useCases.GetSingleStudent;
import com.example.demo.students.domain.StudentId;
import com.example.demo.students.infrastructure.controllers.dtos.GetSingleStudentResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetSingleStudentController {
    private final GetSingleStudent getSingleStudent;

    public GetSingleStudentController(GetSingleStudent getSingleStudent) {
        this.getSingleStudent = getSingleStudent;
    }

    @GetMapping("api/v1/students/{studentId}")
    public GetSingleStudentResponseDTO getSingleStudentEndpoint(@PathVariable String studentId) {
        var student = this.getSingleStudent.execute(StudentId.fromString(studentId));

        return GetSingleStudentResponseDTO.fromDomain(student);
    }
}
