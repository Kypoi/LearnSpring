package com.learn.demo.Student;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class StudentConfig {
  @Bean
  CommandLineRunner commandLineRunner( StudentRepository repository){
    return args -> {
      Student Miguel = new Student("Miguel", "miguel@mail.com", LocalDate.of(2004, Month.APRIL, 7), 19);
      Student Carolina = new Student("Carolina", "carolina@mail.com", LocalDate.of(2004, Month.AUGUST, 25), 19);
      repository.saveAll(List.of(Miguel,Carolina));

    };
  }
}
