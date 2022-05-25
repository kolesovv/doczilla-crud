package org.doczilla.doczillacrud.controller;

import java.util.List;
import org.doczilla.doczillacrud.model.Student;
import org.doczilla.doczillacrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("api/v1/student")
public class StudentController {

  @Autowired
  StudentService studentService;

  @GetMapping("/all")
  public String findAll(Model model) {

    List<Student> students = studentService.findAll();
    model.addAttribute("students", students);
    return "students";
  }

  @GetMapping("/add")
  public String getStudentAddForm(Model model) {

    model.addAttribute("student", new Student());
    return "student-form";
  }

  @PostMapping("/save")
  public String createStudent(@ModelAttribute("student") Student student) {

    studentService.save(student);
    return "redirect:/api/v1/student/all";
  }

  @PostMapping("/delete/{id}")
  public String deleteStudentById(@PathVariable Long id) {

    studentService.deleteById(id);
    return "redirect:/api/v1/student/all";
  }
}
