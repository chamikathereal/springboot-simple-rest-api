package io.github.chamikathereal.simplerestapi.Application.controller;

import io.github.chamikathereal.simplerestapi.Application.dto.response.StudentDTO;
import io.github.chamikathereal.simplerestapi.Domain.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {

    //@Autowired tells Spring: "I need a StudentService. Please find one in your memory and give it to me."
    private StudentService studentService;

    @GetMapping("/getStudent")
    public ResponseEntity<StudentDTO> getStudent(@RequestParam Integer id) {
        return studentService.getStudent(id);
    }

}
