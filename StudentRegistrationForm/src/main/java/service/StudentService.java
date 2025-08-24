package service;

import java.util.List;

import model.Student;

public interface StudentService {
	boolean addStudent(Student student);
	List<Student> getAllStudents();
    boolean updateStudent(Student student);
    boolean deleteStudent(int id);
}
