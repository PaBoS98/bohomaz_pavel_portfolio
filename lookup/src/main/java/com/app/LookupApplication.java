package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LookupApplication {

    B b;

    

    public static void main(String[] args) {
        SpringApplication.run(LookupApplication.class, args);

    }

}
