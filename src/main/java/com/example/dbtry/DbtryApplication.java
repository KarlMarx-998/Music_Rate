package com.example.dbtry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.example.dbtry")
@EntityScan(basePackages = "com.example.dbtry")
//@ComponentScan(basePackages = "com.example.dbtry")
@SpringBootApplication
public class DbtryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbtryApplication.class, args);
    }

}
