package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student mariam = new Student(
                    "mariamgmail.com",
                    "mariam",
                    LocalDate.of(1999, Month.MAY, 3)
            );
            Student alex = new Student(
                    "alex@gmail.com",
                    "alex",
                    LocalDate.of(1999, Month.MAY, 3)
            );
            repository.saveAll(List.of(mariam, alex));
        };
    }
}
