package io.github.chamikathereal.simplerestapi.External.repository;

import io.github.chamikathereal.simplerestapi.Domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    //Derived Query Methods

//    // Translates to: SELECT * FROM student WHERE name = ?
//    //List<Student> findByName(String name);
//    Optional<Student> findByName(String name);
//
//    // Translates to: SELECT * FROM student WHERE email = ?
//    Student findByEmail(String email);
//
//    // Translates to: SELECT * FROM student WHERE age > ?
//    List<Student> findByAgeGreaterThan(int age);
//
//    // Translates to: SELECT * FROM student WHERE name = ? AND age = ?
//    Student findByNameAndAge(String name, int age);
//
//    //JPQL (Java Persistence Query Language)
//    // ?1 means "The first parameter" (name)
//    // ?2 means "The second parameter" (age)
//    @Query("SELECT s FROM Student s WHERE s.name = ?1 AND s.age = ?2")
//    Student findStudentCustom(String name, int age);
//
//    //Native Queries (Raw SQL)
//    // nativeQuery = true means "This is pure SQL, don't try to translate it."
//    @Query(value = "SELECT * FROM tbl_students WHERE email_address = ?1", nativeQuery = true)
//    Student findStudentByEmailNative(String email);
}

