package com.github.llres.springl.transactionCase;

import com.github.llres.springl.pojo.Pojo1;
import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.github.llres.springl.transactionCase"})
@EntityScan(basePackages = {"com.github.llres.springl.pojo"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
