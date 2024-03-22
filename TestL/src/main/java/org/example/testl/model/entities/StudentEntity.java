package org.example.testl.model.entities;

import jakarta.persistence.*;
import org.example.testl.model.BO.Student;
import org.example.testl.model.converter.ListConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class StudentEntity {
    @Id
    private Integer id;
    private String name;
    private Integer classID;
    @Convert(converter = ListConverter.class)
    private List<String> friends;
    public StudentEntity(){

    }
    public StudentEntity(Student student){
        this.id = student.getId();
        this.classID = student.getClassID();
        this.name = student.getName();
        if(student.getFriends() != null){
            this.friends = student.getFriends().stream().map(Object::toString).collect(Collectors.toList());
        }else {
            this.friends = new ArrayList<>();
        }
    }
    public Student toStudent(){
        Student student = new Student();
        student.setId(this.id);
        student.setClassID(this.classID);
        student.setName(this.name);
        student.setFriends(this.friends.stream().map(Integer::valueOf).collect(Collectors.toList()));
        return student;
    }
}
