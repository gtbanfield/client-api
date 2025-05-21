package com.example.controller;

import com.example.entity.Student;
import com.example.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public void saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable String id) {
        return studentService.getStudent(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
    }
}

