package com.example.demo;

import com.example.demo.controller.LoggingController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AirlinemanagementApplication {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(AirlinemanagementApplication.class);

        SpringApplication.run(AirlinemanagementApplication.class, args);
        logger.info("Airline Reservation System Launched");

    }

}
