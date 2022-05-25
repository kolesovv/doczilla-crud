package org.doczilla.doczillacrud.service;

import java.util.List;
import org.doczilla.doczillacrud.model.Student;
import org.doczilla.doczillacrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

  @Autowired
  private StudentRepository studentRepository;

  @Override
  public List<Student> findAll() {

    return studentRepository.findAll();
  }

  @Override
  public Student findById(long id) {

    return studentRepository.findById(id);
  }

  @Override
  public long deleteById(long id) {

    return studentRepository.deleteById(id);
  }

  @Override
  public Student save(Student s) {

    return studentRepository.save(s);
  }

  @Override
  public Student update(Student s) {

    return studentRepository.update(s);
  }
}
