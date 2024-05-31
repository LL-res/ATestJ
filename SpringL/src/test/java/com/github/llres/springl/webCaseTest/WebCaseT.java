package com.github.llres.springl.webCaseTest;

import com.github.llres.springl.webCase.App;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootTest(classes = {App.class})
public class WebCaseT {
    @Autowired
    ApplicationContext applicationContext;
    @Test
    public void t1(){
        System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));
    }

}
