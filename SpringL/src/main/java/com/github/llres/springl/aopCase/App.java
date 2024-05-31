package com.github.llres.springl.aopCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner{
    @Autowired
    private ElectricService electricService;
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }

    @Override
    public void run(String... args) throws Exception {
        electricService.charge();
    }
}
