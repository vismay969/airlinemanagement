package com.example.demo;

import com.example.demo.util.ARSLogging;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AirlinemanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirlinemanagementApplication.class, args);
        ARSLogging.log.info("Info level log message");
        ARSLogging.log.debug("Debug level log message");
        ARSLogging.log.error("Error level log message");

    }

}
