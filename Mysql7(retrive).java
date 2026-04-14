/*12c. Develop a JDBC project using MySQL to append  the fields empno,  empname and basicsalary into the table Emp of the database Employee by getting the fields  through JSP and Generate the report as follows

CREATE TABLE Emp (
  Emp_NO INTEGER PRIMARY KEY,
  Emp_Name TEXT NOT NULL,
  Basicsalary  INTEGER 
);

-- insert
INSERT INTO EMPLOYEE VALUES (101, 'Ramesh', 25000);
INSERT INTO EMPLOYEE VALUES (102, 'Ravi', 20000);
…..
Add 5 records into Emp table of Employee database through Java with JDBC 

and generate a salary report as follows by executing query Emp name starting with R

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~````
Salary Report
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Emp_No     : 101
Emp_Name: Ramesh'
Basic           : 25000
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Emp_No     : 102
Emp_Name: Ravi
Basic           : 20000
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
….
…

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~````
*/




JSP FILE(emp.jsp)

<!DOCTYPE html>
<html>
<head>
    <title>Add Employee</title>
</head>

<body style="text-align:center;">

<h2>Enter Employee Details</h2>

<form action="insert.jsp" method="post">
    Emp No: <input type="text" name="empno"><br><br>
    Emp Name: <input type="text" name="empname"><br><br>
    Basic Salary: <input type="text" name="salary"><br><br>

    <input type="submit" value="Add Employee">
</form>

<br><br>
<a href="index.jsp">Back</a>

</body>
</html>




JSP FILE(index.jsp)

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Employee System</title>
</head>

<body style="text-align:center; font-family: Arial;">

<h1>Employee Management System</h1>
<hr>

<a href="emp.jsp">Add Employee</a>
<br><br>

<a href="report.jsp"> Salary Report</a>

</body>
</html>




JSP File(insert.jsp)


<%@ page import="java.sql.*" %>

<%
String empno = request.getParameter("empno");
String name = request.getParameter("empname");
String salary = request.getParameter("salary");

try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3307/Employee","root","");

    PreparedStatement ps = con.prepareStatement(
        "INSERT INTO Emp VALUES (?, ?, ?)");

    ps.setInt(1, Integer.parseInt(empno));
    ps.setString(2, name);
    ps.setInt(3, Integer.parseInt(salary));

    ps.executeUpdate();

    out.println("<h3>Employee Added Successfully!</h3>");
    out.println("<a href='index.jsp'>Go Home</a>");

    con.close();

} catch(Exception e) {
    out.println(e);
}
%>





JSP FILE(report.jsp)



<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<body>

<pre>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Salary Report
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
</pre>

<%
try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3307/Employee","root","");

    Statement st = con.createStatement();

    ResultSet rs = st.executeQuery(
        "SELECT * FROM Emp WHERE Emp_Name LIKE 'R%'");

    while(rs.next()) {
%>

<pre>
Emp_No     : <%= rs.getInt("Emp_NO") %>
Emp_Name   : <%= rs.getString("Emp_Name") %>
Basic      : <%= rs.getInt("Basicsalary") %>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
</pre>

<%
    }

    con.close();

} catch(Exception e) {
    out.println(e);
}
%>

<br>
<a href="index.jsp">Back</a>

</body>
</html>