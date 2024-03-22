package com.example.demo.students.infrastructure.repositories;

import com.example.demo.students.domain.Student;
import com.example.demo.students.domain.StudentEmail;
import com.example.demo.students.domain.StudentId;
import com.example.demo.students.domain.StudentsRepository;
import com.example.demo.students.domain.primitives.StudentPrimitives;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MemoryStudentsRepository implements StudentsRepository {
    private List<StudentPrimitives> students = new ArrayList<>();

    @Override
    public List<Student> getStudents() {
        return this.students.stream().map(Student::fromPrimitives).toList();
    }

    @Override
    public Optional<Student> getStudentById(StudentId studentId) {
        var foundStudent = this.students.stream().filter(student -> student.id().equals(studentId.getValue())).findAny();

        return foundStudent.map(Student::fromPrimitives);
    }

    @Override
    public void createStudent(Student student) {
        this.students.add(student.toPrimitives());
    }

    @Override
    public Optional<Student> getStudentByEmail(StudentEmail email) {
        var foundStudent = this.students.stream().filter(student -> student.email().equals(email.getValue())).findAny();

        return foundStudent.map(Student::fromPrimitives);
    }

    @Override
    public void updateStudent(Student student) {
        var studentPrimitives = student.toPrimitives();
        var updatedStudents = this.students.stream().map(savedStudent -> {
            if (savedStudent.id().equals(studentPrimitives.id())) {
                return student.toPrimitives();
            }

            return savedStudent;
        });

        this.students = updatedStudents.toList();
    }

    @Override
    public void deleteStudent(StudentId studentId) {
        this.students = this.students.stream().filter(student -> !student.id().equals(studentId.getValue())).toList();
    }
}
