package daoimpl;

import dao.StudentDao;
import db.DBConnection;
import model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public int addStudent(Student student) {
        int rows = 0;
        String sql = "INSERT INTO student (id, name, father_name, age, gender, city, education, department, address) VALUES (?,?,?,?,?,?,?,?,?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setString(3, student.getFatherName());
            ps.setInt(4, student.getAge());
            ps.setString(5, student.getGender());
            ps.setString(6, student.getCity());
            ps.setString(7, student.getEducation());
            ps.setString(8, student.getDepartment());
            ps.setString(9, student.getAddress());
            
            rows = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }
    
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setFatherName(rs.getString("father_name"));
                s.setAge(rs.getInt("age"));
                s.setGender(rs.getString("gender"));
                s.setCity(rs.getString("city"));
                s.setEducation(rs.getString("education"));
                s.setDepartment(rs.getString("department"));
                s.setAddress(rs.getString("address"));
                students.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
    
    @Override
    public int updateStudent(Student student) {
        String sql = "UPDATE student SET name=?, father_name=?, age=?, gender=?, city=?, education=?, department=?, address=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getFatherName());
            ps.setInt(3, student.getAge());
            ps.setString(4, student.getGender());
            ps.setString(5, student.getCity());
            ps.setString(6, student.getEducation());
            ps.setString(7, student.getDepartment());
            ps.setString(8, student.getAddress());
            ps.setInt(9, student.getId());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteStudent(int id) {
        String sql = "DELETE FROM student WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    
    
}
