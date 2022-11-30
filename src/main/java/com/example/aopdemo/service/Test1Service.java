package com.example.aopdemo.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class Test1Service implements CommandLineRunner {

    public Test1Service() {
        System.out.println("Test1Service()");
    }

    @PostConstruct
    public void func() {
        System.out.println("Test1Service.func() @PostConstruct");
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Test1Service");
    }

    public void print() {
        System.out.println("Test1Service.print()");
    }
}
