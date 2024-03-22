package com.example.demo.students.application.useCases;

import com.example.demo.students.domain.StudentId;
import com.example.demo.students.domain.StudentsRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteStudent {
    private final StudentsRepository studentsRepository;

    public DeleteStudent(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public void execute(StudentId studentId) {
        this.studentsRepository.deleteStudent(studentId);
    }
}
