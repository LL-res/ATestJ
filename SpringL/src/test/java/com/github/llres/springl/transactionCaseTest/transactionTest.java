package com.github.llres.springl.transactionCaseTest;

import com.github.llres.springl.pojo.Pojo1;
import com.github.llres.springl.transactionCase.App;
import com.github.llres.springl.transactionCase.H2Repository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = App.class)
public class transactionTest {
    @Autowired
    public H2Repository h2Repository;

    @Test
    public void t1() {
        System.out.println(h2Repository.findAll());
    }
}
