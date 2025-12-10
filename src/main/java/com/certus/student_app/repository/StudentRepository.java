package com.certus.student_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.certus.student_app.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
