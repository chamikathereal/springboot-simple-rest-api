package io.github.chamikathereal.simplerestapi.Domain.service;

import io.github.chamikathereal.simplerestapi.Application.dto.request.CreateStudentDTO;
import io.github.chamikathereal.simplerestapi.Application.dto.response.StudentDTO;
import io.github.chamikathereal.simplerestapi.Domain.entity.Student;
import io.github.chamikathereal.simplerestapi.Domain.exception.StudentNotFoundException;
import io.github.chamikathereal.simplerestapi.External.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
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

    public ResponseEntity<Student> addStudent(CreateStudentDTO createStudentDTO) {
        Student student = new Student();
        student.setName(createStudentDTO.getName());
        student.setAddress(createStudentDTO.getAddress());
        student.setEmail(createStudentDTO.getEmail());
        student.setGrade(createStudentDTO.getGrade());
        studentRepository.save(student);
        log.info("Student added successfully");
        ResponseEntity<Student> responseEntity = ResponseEntity.ok(student);
        return responseEntity;
    }

    public ResponseEntity<String> deleteStudent(Integer id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            studentRepository.deleteById(id);
            return ResponseEntity.ok("Deleted student");
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<String> updateStudent(Integer id, String newName) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setName(newName);
            studentRepository.save(student);
            return ResponseEntity.ok("Updated student");
        }else {
            throw new StudentNotFoundException("Student Not Found!");
        }
    }
}
