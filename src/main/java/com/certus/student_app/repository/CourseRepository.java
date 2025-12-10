package com.certus.student_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.certus.student_app.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}