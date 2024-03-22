package org.example.testl.controller;

import jakarta.websocket.server.PathParam;
import org.example.testl.model.BO.Student;
import org.example.testl.repository.StudentRepository;
import org.example.testl.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("/create")
    public void createStudent(@RequestBody Student student){
        studentService.create(student);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Integer id){
        return studentService.getByID(id);
    }

}
