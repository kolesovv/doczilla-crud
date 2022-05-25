package org.doczilla.doczillacrud.service;

import java.util.List;
import org.doczilla.doczillacrud.model.Student;

public interface StudentService {

  List<Student> findAll();

  Student findById(long id);

  long deleteById(long id);

  Student save(Student s);

  Student update(Student s);
}
