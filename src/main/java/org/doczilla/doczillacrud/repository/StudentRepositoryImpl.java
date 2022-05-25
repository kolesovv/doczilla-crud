package org.doczilla.doczillacrud.repository;

import java.util.List;
import org.doczilla.doczillacrud.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  private final RowMapper<Student> rowMapper = (rs, rowNum) -> {
    return new Student(rs.getLong("id"),
        rs.getString("first_name"),
        rs.getString("last_name"),
        rs.getString("middle_name"),
        rs.getDate("birth_date").toLocalDate(),
        rs.getString("group_name"));
  };

  @Override
  public List<Student> findAll() {

    String sql = "SELECT * FROM student";
    return jdbcTemplate.query(sql, rowMapper);
  }

  @Override
  public Student findById(long id) {

    String sql = "SELECT * FROM student WHERE id=?";
    return jdbcTemplate.queryForObject(sql, rowMapper, id);
  }

  @Override
  public long deleteById(long id) {

    String sql = "DELETE FROM student WHERE id=?";
    return jdbcTemplate.update(sql, id);
  }

  @Override
  public Student save(Student s) {

    String sql = "INSERT INTO student(first_name, last_name, middle_name, birth_date, group_name) VALUES (?,?,?,?,?)";
    jdbcTemplate.update(sql, s.getName(), s.getSurname(), s.getMiddleName(), s.getDateOfBirth(), s.getGroupName());

    return s;
  }

  @Override
  public Student update(Student s) {

    String sql = "UPDATE student "
        + "SET first_name=?, last_name=?, middle_name=?, birth_date=?, group_name=? "
        + "WHERE id=?";
    jdbcTemplate.update(sql, s.getName(), s.getSurname(), s.getMiddleName(), s.getDateOfBirth(), s.getGroupName(),
        s.getId());

    return s;
  }
}
