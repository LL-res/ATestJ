package com.github.llres.springl.transactionCase;

import com.github.llres.springl.pojo.Pojo1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    public ServiceDemo serviceDemo;

    @GetMapping("/index")
    public String saveOne(@RequestParam("p") Integer p) {
        try {
            serviceDemo.saveNewPojo(p);
        } catch (Exception e) {
            return "fail";
        }
        return "success";
    }
}
