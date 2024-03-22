package com.example.demo.students.application.useCases;

import com.example.demo.students.domain.Student;
import com.example.demo.students.domain.StudentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetStudents {
    private final StudentsRepository studentsRepository;

    public GetStudents(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public List<Student> execute() {
        return this.studentsRepository.getStudents();
    }
}
