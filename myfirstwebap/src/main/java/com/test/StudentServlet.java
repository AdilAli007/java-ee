package com.test;


import model.Student;
import service.StudentService;
import serviceimpl.StudentServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/StudentServlet")


public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentService studentService;
    @Override
    public void init() throws ServletException {
        super.init();
        studentService = new StudentServiceImpl();
    }
	
    public StudentServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	PrintWriter out = response.getWriter();
    response.setContentType("text/html");
    String html = "<!DOCTYPE html>\r\n"
    		+ "<html lang=\"en\">\r\n"
    		+ "<head>\r\n"
    		+ "    <meta charset=\"UTF-8\">\r\n"
    		+ "    <title>Student CRUD</title>\r\n"
    		+ "    <style>\r\n"
    		+ "        body {\r\n"
    		+ "            font-family: Arial, sans-serif;\r\n"
    		+ "            background: #f3f6fa;\r\n"
    		+ "            margin: 0;\r\n"
    		+ "            padding: 0;\r\n"
    		+ "        }\r\n"
    		+ "        h2 {\r\n"
    		+ "            color: #333;\r\n"
    		+ "            text-align: center;\r\n"
    		+ "        }\r\n"
    		+ "        .container {\r\n"
    		+ "            width: 90%;\r\n"
    		+ "            max-width: 700px;\r\n"
    		+ "            margin: 20px auto;\r\n"
    		+ "            background: #fff;\r\n"
    		+ "            padding: 25px;\r\n"
    		+ "            border-radius: 12px;\r\n"
    		+ "            box-shadow: 0 4px 10px rgba(0,0,0,0.1);\r\n"
    		+ "        }\r\n"
    		+ "        form {\r\n"
    		+ "            margin-bottom: 30px;\r\n"
    		+ "        }\r\n"
    		+ "        label {\r\n"
    		+ "            display: block;\r\n"
    		+ "            margin: 8px 0 5px;\r\n"
    		+ "            font-weight: bold;\r\n"
    		+ "        }\r\n"
    		+ "        input[type=\"text\"], input[type=\"number\"], textarea {\r\n"
    		+ "            width: 100%;\r\n"
    		+ "            padding: 8px;\r\n"
    		+ "            border-radius: 6px;\r\n"
    		+ "            border: 1px solid #ccc;\r\n"
    		+ "            box-sizing: border-box;\r\n"
    		+ "        }\r\n"
    		+ "        textarea {\r\n"
    		+ "            resize: none;\r\n"
    		+ "            height: 60px;\r\n"
    		+ "        }\r\n"
    		+ "        .gender-group {\r\n"
    		+ "            margin: 8px 0;\r\n"
    		+ "        }\r\n"
    		+ "        .btn {\r\n"
    		+ "            display: inline-block;\r\n"
    		+ "            background: #4CAF50;\r\n"
    		+ "            color: #fff;\r\n"
    		+ "            border: none;\r\n"
    		+ "            padding: 10px 18px;\r\n"
    		+ "            margin-top: 10px;\r\n"
    		+ "            border-radius: 6px;\r\n"
    		+ "            cursor: pointer;\r\n"
    		+ "            transition: 0.3s;\r\n"
    		+ "        }\r\n"
    		+ "        .btn:hover {\r\n"
    		+ "            background: #45a049;\r\n"
    		+ "        }\r\n"
    		+ "        .btn-danger {\r\n"
    		+ "            background: #e74c3c;\r\n"
    		+ "        }\r\n"
    		+ "        .btn-danger:hover {\r\n"
    		+ "            background: #c0392b;\r\n"
    		+ "        }\r\n"
    		+ "        .btn-info {\r\n"
    		+ "            background: #3498db;\r\n"
    		+ "        }\r\n"
    		+ "        .btn-info:hover {\r\n"
    		+ "            background: #2980b9;\r\n"
    		+ "        }\r\n"
    		+ "        hr {\r\n"
    		+ "            margin: 25px 0;\r\n"
    		+ "            border: none;\r\n"
    		+ "            border-top: 1px solid #eee;\r\n"
    		+ "        }\r\n"
    		+ "    </style>\r\n"
    		+ "</head>\r\n"
    		+ "<body>\r\n"
    		+ "\r\n"
    		+ "<div class=\"container\">\r\n"
    		+ "    <h2>Student Registration Form</h2>\r\n"
    		+ "\r\n"
    		+ "    <!-- Add Student -->\r\n"
    		+ "    <form action=\"StudentServlet\" method=\"post\">\r\n"
    		+ "        <h3>Add Student</h3>\r\n"
    		+ "        <label>ID:</label>\r\n"
    		+ "        <input type=\"text\" name=\"id\" required>\r\n"
    		+ "\r\n"
    		+ "        <label>Name:</label>\r\n"
    		+ "        <input type=\"text\" name=\"name\" required>\r\n"
    		+ "\r\n"
    		+ "        <label>Father Name:</label>\r\n"
    		+ "        <input type=\"text\" name=\"father_name\">\r\n"
    		+ "\r\n"
    		+ "        <label>Age:</label>\r\n"
    		+ "        <input type=\"number\" name=\"age\">\r\n"
    		+ "\r\n"
    		+ "        <label>Gender:</label>\r\n"
    		+ "        <div class=\"gender-group\">\r\n"
    		+ "            <input type=\"radio\" name=\"gender\" value=\"Male\"> Male\r\n"
    		+ "            <input type=\"radio\" name=\"gender\" value=\"Female\"> Female\r\n"
    		+ "        </div>\r\n"
    		+ "\r\n"
    		+ "        <label>City:</label>\r\n"
    		+ "        <input type=\"text\" name=\"city\">\r\n"
    		+ "\r\n"
    		+ "        <label>Education:</label>\r\n"
    		+ "        <input type=\"text\" name=\"education\">\r\n"
    		+ "\r\n"
    		+ "        <label>Department:</label>\r\n"
    		+ "        <input type=\"text\" name=\"department\">\r\n"
    		+ "\r\n"
    		+ "        <label>Address:</label>\r\n"
    		+ "        <textarea name=\"address\"></textarea>\r\n"
    		+ "\r\n"
    		+ "        <input type=\"hidden\" name=\"action\" value=\"add\">\r\n"
    		+ "        <button type=\"submit\" class=\"btn\">Add Student</button>\r\n"
    		+ "    </form>\r\n"
    		+ "\r\n"
    		+ "    <hr>\r\n"
    		+ "\r\n"
    		+ "    <!-- Update Student -->\r\n"
    		+ "    <form action=\"StudentServlet\" method=\"post\">\r\n"
    		+ "        <h3>Update Student</h3>\r\n"
    		+ "        <label>ID (required):</label>\r\n"
    		+ "        <input type=\"text\" name=\"id\" required>\r\n"
    		+ "\r\n"
    		+ "        <label>New Name:</label>\r\n"
    		+ "        <input type=\"text\" name=\"name\">\r\n"
    		+ "\r\n"
    		+ "        <label>Father Name:</label>\r\n"
    		+ "        <input type=\"text\" name=\"father_name\">\r\n"
    		+ "\r\n"
    		+ "        <label>Age:</label>\r\n"
    		+ "        <input type=\"number\" name=\"age\">\r\n"
    		+ "\r\n"
    		+ "        <label>Gender:</label>\r\n"
    		+ "        <div class=\"gender-group\">\r\n"
    		+ "            <input type=\"radio\" name=\"gender\" value=\"Male\"> Male\r\n"
    		+ "            <input type=\"radio\" name=\"gender\" value=\"Female\"> Female\r\n"
    		+ "        </div>\r\n"
    		+ "\r\n"
    		+ "        <label>City:</label>\r\n"
    		+ "        <input type=\"text\" name=\"city\">\r\n"
    		+ "\r\n"
    		+ "        <label>Education:</label>\r\n"
    		+ "        <input type=\"text\" name=\"education\">\r\n"
    		+ "\r\n"
    		+ "        <label>Department:</label>\r\n"
    		+ "        <input type=\"text\" name=\"department\">\r\n"
    		+ "\r\n"
    		+ "        <label>Address:</label>\r\n"
    		+ "        <textarea name=\"address\"></textarea>\r\n"
    		+ "\r\n"
    		+ "        <input type=\"hidden\" name=\"action\" value=\"update\">\r\n"
    		+ "        <button type=\"submit\" class=\"btn btn-info\">Update Student</button>\r\n"
    		+ "    </form>\r\n"
    		+ "\r\n"
    		+ "    <hr>\r\n"
    		+ "\r\n"
    		+ "    <!-- Delete Student -->\r\n"
    		+ "    <form action=\"StudentServlet\" method=\"post\">\r\n"
    		+ "        <h3>Delete Student</h3>\r\n"
    		+ "        <label>ID (required):</label>\r\n"
    		+ "        <input type=\"text\" name=\"id\" required>\r\n"
    		+ "        <input type=\"hidden\" name=\"action\" value=\"delete\">\r\n"
    		+ "        <button type=\"submit\" class=\"btn btn-danger\">Delete Student</button>\r\n"
    		+ "    </form>\r\n"
    		+ "\r\n"
    		+ "    <hr>\r\n"
    		+ "\r\n"
    		+ "    <!-- View All Students -->\r\n"
    		+ "    <form action=\"StudentServlet\" method=\"get\">\r\n"
    		+ "        <h3>View All Students</h3>\r\n"
    		+ "        <input type=\"hidden\" name=\"action\" value=\"list\">\r\n"
    		+ "        <button type=\"submit\" class=\"btn btn-info\">Get All Students</button>\r\n"
    		+ "    </form>\r\n"
    		+ "</div>\r\n"
    		+ "\r\n"
    		+ "</body>\r\n"
    		+ "</html>\r\n";
    
    		out.write(html);
    		
            String action = request.getParameter("action");

            if (action == null || action.equals("list")) {
                listStudents(request, response);
            }
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

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
            default:
                listStudents(request, response);
                break;
        }
}
	
    
		private void addStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String fatherName = request.getParameter("father_name");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        String city = request.getParameter("city");
        String education = request.getParameter("education");
        String department = request.getParameter("department");
        String address = request.getParameter("address");

        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setFatherName(fatherName);
        student.setAge(age);
        student.setGender(gender);
        student.setCity(city);
        student.setEducation(education);
        student.setDepartment(department);
        student.setAddress(address);
        boolean status = studentService.addStudent(student);

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        if (status) {
            out.println("<h3>Student Added Successfully!</h3>");
        } else {
            out.println("<h3>Error adding student.</h3>");
        }
        out.println("<a href='student_form.html'>Back</a>");
    }
		
	    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        String name = request.getParameter("name");
	        String fatherName = request.getParameter("father_name");
	        int age = Integer.parseInt(request.getParameter("age"));
	        String gender = request.getParameter("gender");
	        String city = request.getParameter("city");
	        String education = request.getParameter("education");
	        String department = request.getParameter("department");
	        String address = request.getParameter("address");

	        Student student = new Student();
	        student.setId(id);
	        student.setName(name);
	        student.setFatherName(fatherName);
	        student.setAge(age);
	        student.setGender(gender);
	        student.setCity(city);
	        student.setEducation(education);
	        student.setDepartment(department);
	        student.setAddress(address);
	        boolean status = studentService.updateStudent(student);

	        PrintWriter out = response.getWriter();
	        response.setContentType("text/html");
	        if (status) {
	            out.println("<h3>Student Updated Successfully!</h3>");
	        } else {
	            out.println("<h3>Error updating student.</h3>");
	        }
	        out.println("<a href='student_form.html'>Back</a>");
	    }
	    
	    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        boolean status = studentService.deleteStudent(id);

	        PrintWriter out = response.getWriter();
	        response.setContentType("text/html");
	        if (status) {
	            out.println("<h3>Student Deleted Successfully!</h3>");
	        } else {
	            out.println("<h3>Error deleting student.</h3>");
	        }
	        out.println("<a href='student_form.html'>Back</a>");
	    }
	    
	    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws IOException {
	        List<Student> list = studentService.getAllStudents();

	        PrintWriter out = response.getWriter();
	        response.setContentType("text/html");

	        out.println("<h2>All Students</h2>");
	        out.println("<table border='1' cellpadding='5' cellspacing='0'>");
	        out.println("<tr><th>ID</th><th>Name</th><th>Father Name</th><th>Age</th><th>Gender</th><th>City</th><th>Education</th><th>Department</th><th>Address</th></tr>");

	        for (Student s : list) {
	            out.println("<tr>");
	            out.println("<td>" + s.getId() + "</td>");
	            out.println("<td>" + s.getName() + "</td>");
	            out.println("<td>" + s.getFatherName() + "</td>");
	            out.println("<td>" + s.getAge() + "</td>");
	            out.println("<td>" + s.getGender() + "</td>");
	            out.println("<td>" + s.getCity() + "</td>");
	            out.println("<td>" + s.getEducation() + "</td>");
	            out.println("<td>" + s.getDepartment() + "</td>");
	            out.println("<td>" + s.getAddress() + "</td>");
	            out.println("</tr>");
	        }
	        out.println("</table>");
	        out.println("<br><a href='student_form.html'>Back</a>");
	    }
	}

		


	
	



