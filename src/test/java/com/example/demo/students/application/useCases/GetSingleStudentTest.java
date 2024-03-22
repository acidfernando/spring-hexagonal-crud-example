package com.example.demo.students.application.useCases;

import com.example.demo.students.domain.*;
import com.example.demo.students.domain.errors.StudentNotFoundError;
import com.example.demo.students.infrastructure.repositories.MemoryStudentsRepository;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class GetSingleStudentTest {

    @Test
    public void getsASingleStudy() {
        var studentId = StudentId.fromString(UUID.randomUUID().toString());
        var student = Student.createStudent(studentId, StudentName.fromString("Name"), StudentEmail.fromString("email@email.com"), StudentBirthdate.fromDate(Date.from(Instant.now())));
        var memoryStudentsRepository = new MemoryStudentsRepository();
        memoryStudentsRepository.createStudent(student);

        var useCase = new GetSingleStudent(memoryStudentsRepository);

        assertDoesNotThrow(() -> useCase.execute(studentId));
    }

    @Test
    public void throwsAnErrorIfStudentDoesntExist() {
        var studentId = StudentId.fromString(UUID.randomUUID().toString());
        var memoryStudentsRepository = new MemoryStudentsRepository();

        var useCase = new GetSingleStudent(memoryStudentsRepository);

        assertThrows(StudentNotFoundError.class, () -> useCase.execute(studentId));
    }
}