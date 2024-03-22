package org.example.testl.service;

import jakarta.transaction.Transactional;
import org.example.testl.model.BO.Student;
import org.example.testl.model.entities.StudentEntity;
import org.example.testl.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public void create(Student student){
        StudentEntity studentEntity = new StudentEntity(student);
        studentRepository.save(studentEntity);
    }
    public Student getByID(Integer id){
        if (studentRepository.findById(id).isPresent()) {
            return studentRepository.findById(id).get().toStudent();
        }
        return null;

    }
}
