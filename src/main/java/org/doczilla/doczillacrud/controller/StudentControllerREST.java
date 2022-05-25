package org.doczilla.doczillacrud.controller;

import java.util.List;
import org.doczilla.doczillacrud.model.Student;
import org.doczilla.doczillacrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v2/student")
public class StudentControllerREST {

  @Autowired
  StudentService studentService;

  @GetMapping("/all")
  public List<Student> findAll() {

    return studentService.findAll();
  }

  @GetMapping("/find/{id}")
  public Student getStudentById(@PathVariable Long id) {

    return studentService.findById(id);
  }

  @PostMapping("/add")
  public Student createStudent(@RequestBody Student student) {

    return studentService.save(student);
  }

  @PostMapping("/update")
  public Student updateStudent(@RequestBody Student student) {

    return studentService.update(student);
  }

  @DeleteMapping("/delete/{id}")
  public long deleteStudentById(@PathVariable Long id) {

    return studentService.deleteById(id);
  }
}
