package de.htw.foodnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoodNetApplication {

    public static void main(String[] args) {
        System.out.println(System.getenv());
        SpringApplication.run(FoodNetApplication.class, args);
    }

}
