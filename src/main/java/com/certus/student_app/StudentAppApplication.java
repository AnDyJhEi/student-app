package com.certus.student_app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.certus.student_app.model.Course;
import com.certus.student_app.repository.CourseRepository;

@SpringBootApplication
public class StudentAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentAppApplication.class, args);
    }

    // Cargar cursos iniciales (como dice la guía: cursos asociados del alumno)
    @Bean
    CommandLineRunner initData(CourseRepository courseRepo) {
        return args -> {
            if (courseRepo.count() == 0) {
                courseRepo.save(new Course(null, "Base de Datos MySQL"));
                courseRepo.save(new Course(null, "Matemáticas Avanzadas"));
                courseRepo.save(new Course(null, "Programación Java"));
                courseRepo.save(new Course(null, "Redes y Comunicaciones"));
            }
        };
    }
}
