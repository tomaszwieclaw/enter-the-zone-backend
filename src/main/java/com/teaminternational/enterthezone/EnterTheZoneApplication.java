package com.teaminternational.enterthezone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class EnterTheZoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnterTheZoneApplication.class, args);
    }

}
