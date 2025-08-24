package servlet;

import model.Student;
import service.StudentService;
import serviceimpl.StudentServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentService studentService;

    @Override
    public void init() throws ServletException {
        studentService = new StudentServiceImpl();
    }
   
    public StudentServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 listStudents(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       String action = request.getParameter("action");

	        switch (action) {
	            case "add":
	                addStudent(request, response);
	                break;
	            case "update":
	                updateStudent(request, response);
	                break;
	            case "delete":
	                deleteStudent(request, response);
	                break;
	            case "form":  
	                request.getRequestDispatcher("studentForm.jsp").forward(request, response);
	                break;    
	            case "edit":   
	                showEditForm(request, response);
	                break;    
	            default:
	                listStudents(request, response);
	                break;
	        }	
		
	}
	
    private void addStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Student student = new Student();
        student.setName(request.getParameter("name"));
        student.setFatherName(request.getParameter("fatherName"));
        student.setAge(Integer.parseInt(request.getParameter("age")));
        student.setGender(request.getParameter("gender"));
        student.setCity(request.getParameter("city"));
        student.setEducation(request.getParameter("education"));
        student.setDepartment(request.getParameter("department"));
        student.setAddress(request.getParameter("address"));

        studentService.addStudent(student);
        response.sendRedirect("StudentServlet");
    }
    
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Student student = new Student();
        student.setId(Integer.parseInt(request.getParameter("id")));
        student.setName(request.getParameter("name"));
        student.setFatherName(request.getParameter("fatherName"));
        student.setAge(Integer.parseInt(request.getParameter("age")));
        student.setGender(request.getParameter("gender"));
        student.setCity(request.getParameter("city"));
        student.setEducation(request.getParameter("education"));
        student.setDepartment(request.getParameter("department"));
        student.setAddress(request.getParameter("address"));

        request.setAttribute("student", student);
        request.getRequestDispatcher("studentUpdate.jsp").forward(request, response);
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student = new Student();
        student.setId(Integer.parseInt(request.getParameter("id")));
        student.setName(request.getParameter("name"));
        student.setFatherName(request.getParameter("fatherName"));
        student.setAge(Integer.parseInt(request.getParameter("age")));
        student.setGender(request.getParameter("gender"));
        student.setCity(request.getParameter("city"));
        student.setEducation(request.getParameter("education"));
        student.setDepartment(request.getParameter("department"));
        student.setAddress(request.getParameter("address"));

        studentService.updateStudent(student);
        response.sendRedirect("StudentServlet");
     
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentService.deleteStudent(id);
        response.sendRedirect("StudentServlet");
    }

    private void listStudents(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Student> students = studentService.getAllStudents();
        request.setAttribute("students", students);
        request.getRequestDispatcher("studentList.jsp").forward(request, response);
    }

}
