package org.example.testl.noCtxTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.testl.model.BO.Student;
import org.junit.jupiter.api.Test;

public class NoCtxTest {
    @Test
    void t1() throws JsonProcessingException {
        Student student = new Student();
        student.setName("Su");
        student.setId(1);
        student.setClassID(2);
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(student));
    }
}
