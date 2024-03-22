package com.example.demo.students.domain.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="No such Student")
public class StudentNotFoundError extends RuntimeException {
    public StudentNotFoundError(String studentId) {
        super("Student with id " + studentId + " was not found");
    }
}
