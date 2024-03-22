package com.example.demo.students.infrastructure.controllers.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CreateStudentRequestDTO {
    @NotBlank
    public String name;

    @NotBlank
    @Email
    public String email;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull
    public Date birthdate;
}
