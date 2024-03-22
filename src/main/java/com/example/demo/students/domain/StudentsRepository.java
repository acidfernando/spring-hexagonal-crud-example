package com.example.demo.students.domain;

import java.util.List;
import java.util.Optional;

public interface StudentsRepository {
    List<Student> getStudents();
    Optional<Student> getStudentById(StudentId studentId);

    void createStudent(Student student);

    Optional<Student> getStudentByEmail(StudentEmail email);

    void updateStudent(Student student);
    void deleteStudent(StudentId studentId);
}
