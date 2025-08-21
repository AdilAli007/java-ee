package serviceimpl;

import java.util.List;

import dao.StudentDao;
import daoimpl.StudentDaoImpl;
import model.Student;
import service.StudentService;

public class StudentServiceImpl implements StudentService {
	private StudentDao studentDao = new StudentDaoImpl();
    @Override
    public boolean addStudent(Student student) {
        int rows = studentDao.addStudent(student);
        return rows > 0;
    }
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents(); 
    }
    @Override
    public boolean updateStudent(Student student) {
        return studentDao.updateStudent(student) > 0;
    }

    @Override
    public boolean deleteStudent(int id) {
        return studentDao.deleteStudent(id) > 0;
    }

    
}
