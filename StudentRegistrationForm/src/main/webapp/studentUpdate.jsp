<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="model.Student" %>
<html>
<head>
    <title>Update Student</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f4f4f9; padding: 30px; }
        h2 { color: #333; }
        form {
            background: #fff; padding: 20px; border-radius: 8px;
            box-shadow: 0 2px 6px rgba(0,0,0,0.1);
            max-width: 500px;
        }
        input, select {
            width: 100%; padding: 8px; margin: 8px 0;
            border: 1px solid #ccc; border-radius: 4px;
        }
        input[type=submit] {
            background: #2196F3; color: white; font-weight: bold;
            border: none; cursor: pointer;
        }
        input[type=submit]:hover { background: #1976D2; }
        .back-link {
            display: inline-block; margin-top: 15px; padding: 8px 15px;
            background: #4CAF50; color: white; text-decoration: none; border-radius: 4px;
        }
        .back-link:hover { opacity: 0.9; }
    </style>
</head>
<body>
    <h2>Update Student</h2>

    <%
        Student s = (Student) request.getAttribute("student");
    %>

    <form action="StudentServlet" method="post">
        <input type="hidden" name="action" value="update"/>
        <input type="hidden" name="id" value="<%= s.getId() %>"/>

        <label>Name:</label>
        <input type="text" name="name" value="<%= s.getName() %>" required/>

        <label>Father Name:</label>
        <input type="text" name="fatherName" value="<%= s.getFatherName() %>" required/>

        <label>Age:</label>
        <input type="number" name="age" value="<%= s.getAge() %>" required/>

        <label>Gender:</label>
        <select name="gender" required>
            <option value="Male" <%= "Male".equals(s.getGender()) ? "selected" : "" %>>Male</option>
            <option value="Female" <%= "Female".equals(s.getGender()) ? "selected" : "" %>>Female</option>
        </select>

        <label>City:</label>
        <input type="text" name="city" value="<%= s.getCity() %>" required/>

        <label>Education:</label>
        <input type="text" name="education" value="<%= s.getEducation() %>" required/>

        <label>Department:</label>
        <input type="text" name="department" value="<%= s.getDepartment() %>" required/>

        <label>Address:</label>
        <input type="text" name="address" value="<%= s.getAddress() %>" required/>

        <input type="submit" value="Update Student"/>
    </form>

    <a class="back-link" href="StudentServlet">⬅ Back to Student List</a>
</body>
</html>
