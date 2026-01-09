package io.github.chamikathereal.simplerestapi.Application.controller;

import io.github.chamikathereal.simplerestapi.Application.dto.request.CreateStudentDTO;
import io.github.chamikathereal.simplerestapi.Application.dto.response.StudentDTO;
import io.github.chamikathereal.simplerestapi.Domain.entity.Student;
import io.github.chamikathereal.simplerestapi.Domain.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addStudent")
    public ResponseEntity<Student> addStudent(@RequestBody CreateStudentDTO createStudentDTO) {
        return studentService.addStudent(createStudentDTO);
    }

    @DeleteMapping("/deleteStudent")
    public ResponseEntity<String> deleteStudent(@RequestParam Integer id) {
        return studentService.deleteStudent(id);
    }

    @PutMapping("/updateStudent")
    public ResponseEntity<String> updateStudent(@RequestParam Integer id, @RequestBody String newName) {
        return studentService.updateStudent(id,newName);
    }

}
