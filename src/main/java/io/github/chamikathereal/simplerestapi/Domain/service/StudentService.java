package io.github.chamikathereal.simplerestapi.Domain.service;

import io.github.chamikathereal.simplerestapi.Application.dto.response.StudentDTO;
import io.github.chamikathereal.simplerestapi.Domain.entity.Student;
import io.github.chamikathereal.simplerestapi.External.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    public ResponseEntity<StudentDTO> getStudent(Integer id) {
        StudentDTO studentDTO = new StudentDTO();
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            studentDTO.setId(student.getId());
            studentDTO.setName(student.getName());
            studentDTO.setGrade(student.getGrade());
            return ResponseEntity.ok(studentDTO);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
