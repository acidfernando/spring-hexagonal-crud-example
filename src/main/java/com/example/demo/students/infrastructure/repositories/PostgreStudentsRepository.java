package com.example.demo.students.infrastructure.repositories;

import com.example.demo.students.domain.Student;
import com.example.demo.students.domain.StudentEmail;
import com.example.demo.students.domain.StudentId;
import com.example.demo.students.domain.StudentsRepository;
import com.example.demo.students.domain.errors.StudentNotFoundError;
import com.example.demo.students.infrastructure.repositories.entities.StudentEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PostgreStudentsRepository implements StudentsRepository {
    private final JPAStudentsInternalRepository repository;

    public PostgreStudentsRepository(JPAStudentsInternalRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Student> getStudents() {
        return this.repository.findAll().stream().map(StudentEntity::toDomain).toList();
    }

    @Override
    public Optional<Student> getStudentById(StudentId studentId) {
        var student = this.repository.findById(studentId.getValue());

        return student.map(StudentEntity::toDomain);
    }

    @Override
    public void createStudent(Student student) {
        this.repository.save(StudentEntity.fromDomain(student));
    }

    @Override
    public Optional<Student> getStudentByEmail(StudentEmail email) {
        return this.repository.findByEmail(email.getValue()).map(StudentEntity::toDomain);
    }

    @Override
    public void updateStudent(Student student) {
        this.repository.save(StudentEntity.fromDomain(student));
    }

    @Override
    public void deleteStudent(StudentId studentId) {
        this.repository.deleteById(studentId.getValue());
    }
}
