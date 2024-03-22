package com.example.demo.students.application.useCases;

import com.example.demo.students.domain.Student;
import com.example.demo.students.domain.StudentId;
import com.example.demo.students.domain.StudentsRepository;
import com.example.demo.students.domain.errors.StudentNotFoundError;
import org.springframework.stereotype.Service;

@Service
public class GetSingleStudent {
    private final StudentsRepository studentsRepository;

    public GetSingleStudent(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public Student execute(StudentId studentId) {
        var student = this.studentsRepository.getStudentById(studentId);

        if (student.isEmpty()) {
            throw new StudentNotFoundError(studentId.getValue());
        }

        return student.get();
    }
}
