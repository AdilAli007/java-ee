package dao;

import java.util.List;

import model.Student;

public interface StudentDao {
	 int addStudent(Student student);
	 public List<Student> getAllStudents();
	 int updateStudent(Student student);
	 int deleteStudent(int id);
}
