package com.certus.student_app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.certus.student_app.model.Course;
import com.certus.student_app.model.Student;
import com.certus.student_app.repository.CourseRepository;
import com.certus.student_app.repository.StudentRepository;

@Controller
public class StudentController {

    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;

    public StudentController(StudentRepository studentRepo, CourseRepository courseRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/students";
    }

    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentRepo.findAll());
        return "students";
    }

    @GetMapping("/students/new")
    public String showCreateForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("courses", courseRepo.findAll());
        return "student_form";
    }

    @PostMapping("/students")
    public String saveStudent(
            @ModelAttribute("student") Student student,
            @RequestParam(value = "courseIds", required = false) List<Long> courseIds) {

        if (courseIds != null) {
            List<Course> selectedCourses = courseRepo.findAllById(courseIds);
            student.setCourses(selectedCourses);
        }
        studentRepo.save(student);
        return "redirect:/students";
    }
}
