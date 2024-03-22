package com.example.demo.students.infrastructure.controllers;

import com.example.demo.students.application.useCases.DeleteStudent;
import com.example.demo.students.application.useCases.GetSingleStudent;
import com.example.demo.students.domain.StudentId;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteStudentController {

    private final DeleteStudent deleteStudent;

    public DeleteStudentController(DeleteStudent deleteStudent) {
        this.deleteStudent = deleteStudent;
    }

    @DeleteMapping("api/v1/students/{studentId}")
    public void deleteStudentEndpoint(@PathVariable String studentId) {
        this.deleteStudent.execute(StudentId.fromString(studentId));
    }
}
