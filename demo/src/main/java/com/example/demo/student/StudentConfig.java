package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student mary = new Student(
                    "Mary",
                    "mary@gmail.com",
                    LocalDate.of(2000, APRIL, 5)
            );
            Student ashley = new Student(
                    "Ashley",
                    "ashley@gmail.com",
                    LocalDate.of(1997, OCTOBER, 28)
            );

            repository.saveAll(List.of(mary, ashley)); //Hibernate works
        };
    }

}
