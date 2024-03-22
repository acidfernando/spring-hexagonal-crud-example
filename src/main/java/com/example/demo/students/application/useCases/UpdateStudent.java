package com.example.demo.students.application.useCases;

import com.example.demo.students.domain.*;
import com.example.demo.students.domain.errors.StudentNotFoundError;
import org.springframework.stereotype.Service;

@Service
public class UpdateStudent {

    private final StudentsRepository studentsRepository;

    public UpdateStudent(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public void execute(StudentId studentId, StudentName studentName, StudentEmail studentEmail, StudentBirthdate studentBirthdate) {
        var studentOptional = this.studentsRepository.getStudentById(studentId);

        if (studentOptional.isEmpty()) {
            throw new StudentNotFoundError(studentId.getValue());
        }

        var student = studentOptional.get();
        student.update(studentName, studentEmail, studentBirthdate);

        this.studentsRepository.updateStudent(student);
    }
}
