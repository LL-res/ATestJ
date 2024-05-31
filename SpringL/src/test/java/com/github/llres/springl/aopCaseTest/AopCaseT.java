package com.github.llres.springl.aopCaseTest;

import com.github.llres.springl.aopCase.App;
import com.github.llres.springl.aopCase.ElectricService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest(classes = {App.class})
public class AopCaseT {
    @Autowired
    ApplicationContext applicationContext;
    @Test
    public void t1() throws Exception {
        ElectricService bean = applicationContext.getBean(ElectricService.class);
        bean.charge();
    }
}
