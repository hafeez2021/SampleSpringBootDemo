package com.show.app2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class App2Runner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running App2");
    }
}
