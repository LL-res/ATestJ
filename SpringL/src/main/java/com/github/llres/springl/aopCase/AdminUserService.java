package com.github.llres.springl.aopCase;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class AdminUserService {
    @Getter
    public User adminUser = new User("202101166");

    public void login() {
        System.out.println("admin user login...");
    }
}