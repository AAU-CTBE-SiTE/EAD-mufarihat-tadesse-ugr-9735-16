package com.craft.studentcrud.controller;

import com.craft.studentcrud.model.Student;
import com.craft.studentcrud.service.StudentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // READ ALL STUDENTS
    @GetMapping
    public Student[] getAllStudents() {
        return studentService.getAllStudents();
    }

    // READ STUDENT BY ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    // CREATE STUDENT
    @PostMapping
    public ResponseEntity<Student> addStudent(
            @RequestBody Student student) {

        Student savedStudent = studentService.addStudent(student);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedStudent);
    }

    // UPDATE STUDENT
    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable int id,
            @RequestBody Student student) {

        return studentService.updateStudent(id, student);
    }

    // DELETE STUDENT
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(
            @PathVariable int id) {

        studentService.deleteStudent(id);

        return ResponseEntity.noContent().build();
    }
}
