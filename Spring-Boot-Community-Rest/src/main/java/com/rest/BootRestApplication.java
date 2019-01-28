package com.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RestController
@SpringBootApplication
public class BootRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootRestApplication.class, args);
    }

    @GetMapping
    public String HelloWorld() {
        return "Hello World";
    }


}

