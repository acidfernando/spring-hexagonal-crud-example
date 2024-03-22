package com.example.demo.students.domain.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason="Student already created")

public class StudentAlreadyCreatedError extends RuntimeException {
    public StudentAlreadyCreatedError(String email) {
        super("Student with email " + email + " already exists");
    }

}
