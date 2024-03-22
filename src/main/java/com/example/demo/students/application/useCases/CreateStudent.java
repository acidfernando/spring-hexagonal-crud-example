package com.example.demo.students.application.useCases;

import com.example.demo.students.domain.*;
import com.example.demo.students.domain.errors.StudentAlreadyCreatedError;
import org.springframework.stereotype.Service;
@Service
public class CreateStudent {
    private final StudentsRepository studentsRepository;

    public CreateStudent(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public void execute(StudentId studentId, StudentName name, StudentEmail email, StudentBirthdate birthdate) {
        var foundStudentOptional = studentsRepository.getStudentByEmail(email);

        if (foundStudentOptional.isPresent()) {
            throw new StudentAlreadyCreatedError(email.getValue());
        }

        var student = Student.createStudent(studentId, name, email, birthdate);

        this.studentsRepository.createStudent(student);
    }
}
