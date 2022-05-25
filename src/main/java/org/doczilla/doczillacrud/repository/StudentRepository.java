package org.doczilla.doczillacrud.repository;

import java.util.List;
import org.doczilla.doczillacrud.model.Student;

public interface StudentRepository {

  List<Student> findAll();

  Student findById(long id);

  long deleteById(long id);

  Student save(Student s);

  Student update(Student s);
}
