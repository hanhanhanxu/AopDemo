package com.example.aopdemo.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class Test2Service implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Test2Service");
    }
}
