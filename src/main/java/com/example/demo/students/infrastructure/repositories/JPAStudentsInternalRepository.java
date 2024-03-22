package com.example.demo.students.infrastructure.repositories;

import com.example.demo.students.domain.Student;
import com.example.demo.students.infrastructure.repositories.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JPAStudentsInternalRepository extends JpaRepository<StudentEntity, String> {
    Optional<StudentEntity> findByEmail(String email);
}
