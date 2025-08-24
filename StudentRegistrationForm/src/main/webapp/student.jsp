<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add Student</title>
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
            background: #4CAF50; color: white; font-weight: bold;
            border: none; cursor: pointer;
        }
        input[type=submit]:hover { background: #45a049; }
        .back-link {
            display: inline-block; margin-top: 15px; padding: 8px 15px;
            background: #2196F3; color: white; text-decoration: none; border-radius: 4px;
        }
        .back-link:hover { opacity: 0.9; }
    </style>
</head>
<body>
    <h2>Add New Student</h2>

    <form action="StudentServlet" method="post">
        <input type="hidden" name="action" value="add"/>

        <label>Name:</label>
        <input type="text" name="name" required/>

        <label>Father Name:</label>
        <input type="text" name="fatherName" required/>

        <label>Age:</label>
        <input type="number" name="age" required/>

        <label>Gender:</label>
        <select name="gender" required>
            <option value="">-- Select Gender --</option>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
        </select>

        <label>City:</label>
        <input type="text" name="city" required/>

        <label>Education:</label>
        <input type="text" name="education" required/>

        <label>Department:</label>
        <input type="text" name="department" required/>

        <label>Address:</label>
        <input type="text" name="address" required/>

        <input type="submit" value="Add Student"/>
    </form>

    <a class="back-link" href="StudentServlet">⬅ Show All Students</a>
</body>
</html>
