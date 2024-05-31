package com.github.llres.springl.transactionCase;

import com.github.llres.springl.pojo.Pojo1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceDemo {
    @Autowired
    public H2Repository repository;

    public void saveNewPojo(Integer p) throws Exception{
        if (p<0) {
            throw new Exception("msg");
        }
        repository.save(new Pojo1());
    }

}
