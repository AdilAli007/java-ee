<%@ page import="java.util.*, model.Student" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>All Students</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f4f4f9; padding: 30px; }
        h2 { color: #333; margin-bottom: 20px; }

        table {
            width: 100%; border-collapse: collapse; margin-top: 10px;
            background: #fff; box-shadow: 0 2px 6px rgba(0,0,0,0.1);
            border-radius: 8px; overflow: hidden;
        }
        th, td {
            border: 1px solid #ddd; padding: 12px; text-align: center;
        }
        th {
            background: #4CAF50; color: white; text-transform: uppercase;
        }
        tr:nth-child(even) { background: #f9f9f9; }

        form { display: inline; }

        /* Buttons */
        input[type=submit] {
            border: none; padding: 6px 12px; border-radius: 4px; cursor: pointer;
            font-weight: bold; color: white;
        }
        .update-btn { background: #2196F3; }
        .update-btn:hover { background: #1976D2; }
        .delete-btn { background: #f44336; }
        .delete-btn:hover { background: #d32f2f; }

        /* Add link */
        .add-link {
            display: inline-block; margin-top: 20px; padding: 10px 18px;
            background: #4CAF50; color: white; text-decoration: none; border-radius: 6px;
            font-weight: bold;
        }
        .add-link:hover { background: #45a049; }
    </style>
</head>
<body>
    <h2>All Students</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Father Name</th>
            <th>Age</th>
            <th>Gender</th>
            <th>City</th>
            <th>Education</th>
            <th>Department</th>
            <th>Address</th>
            <th>Actions</th>
        </tr>
        <%
            List<Student> list = (List<Student>) request.getAttribute("students");
            if (list != null && !list.isEmpty()) {
                for (Student s : list) {
        %>
        <tr>
            <td><%= s.getId() %></td>
            <td><%= s.getName() %></td>
            <td><%= s.getFatherName() %></td>
            <td><%= s.getAge() %></td>
            <td><%= s.getGender() %></td>
            <td><%= s.getCity() %></td>
            <td><%= s.getEducation() %></td>
            <td><%= s.getDepartment() %></td>
            <td><%= s.getAddress() %></td>
            <td>
                <!-- Update -->
                <form action="StudentServlet" method="post">
                    <input type="hidden" name="action" value="edit"/>
                    <input type="hidden" name="id" value="<%= s.getId() %>"/>
                    <input type="hidden" name="name" value="<%= s.getName() %>"/>
                    <input type="hidden" name="fatherName" value="<%= s.getFatherName() %>"/>
                    <input type="hidden" name="age" value="<%= s.getAge() %>"/>
                    <input type="hidden" name="gender" value="<%= s.getGender() %>"/>
                    <input type="hidden" name="city" value="<%= s.getCity() %>"/>
                    <input type="hidden" name="education" value="<%= s.getEducation() %>"/>
                    <input type="hidden" name="department" value="<%= s.getDepartment() %>"/>
                    <input type="hidden" name="address" value="<%= s.getAddress() %>"/>
                    <input type="submit" value="Update" class="update-btn"/>
                </form>
                <!-- Delete -->
                <form action="StudentServlet" method="post">
                    <input type="hidden" name="action" value="delete"/>
                    <input type="hidden" name="id" value="<%= s.getId() %>"/>
                    <input type="submit" value="Delete" class="delete-btn"/>
                </form>
            </td>
        </tr>
        <%      }
            } else {
        %>
        <tr><td colspan="10">No students found.</td></tr>
        <% } %>
    </table>

    <a class="add-link" href="student.jsp">➕ Add New Student</a>
</body>
</html>
