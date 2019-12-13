package de.htw.foodnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan
public class FoodNetApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodNetApplication.class, args);
    }
}