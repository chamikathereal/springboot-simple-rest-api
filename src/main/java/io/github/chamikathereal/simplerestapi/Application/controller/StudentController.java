package io.github.chamikathereal.simplerestapi.Application.controller;

import io.github.chamikathereal.simplerestapi.Domain.entity.Student;
import io.github.chamikathereal.simplerestapi.External.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {

    private final StudentRepository studentRepository;

    @GetMapping("/list")
    public List<Student> getStudentL() {
        return studentRepository.findAll();
        //return "Student List";
    }

    @PostMapping("/add")
    public String addStudent() {
        return "Student Add";
    }
}
