package com.example.demo.students.infrastructure.controllers;

import com.example.demo.students.application.useCases.GetStudents;
import com.example.demo.students.infrastructure.controllers.dtos.GetStudentsItemResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetStudentsController {
    private final GetStudents getStudents;

    public GetStudentsController(GetStudents getStudents) {
        this.getStudents = getStudents;
    }

    @GetMapping("api/v1/students")
    public List<GetStudentsItemResponseDTO> getStudentsEndpoint() {
        var students = this.getStudents.execute();
        return students.stream().map(GetStudentsItemResponseDTO::fromDomain).toList();
    }
}
