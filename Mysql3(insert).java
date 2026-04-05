/*11 c. Develop a JDBC project using JDBC to append  the fields empno,  empname and basicsalary into the table Emp of the database Employee by getting the fields  through keyboard using index.jsp  and Generate the report using Employee.jsp as follows

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

and generate a salary report as follows

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
Grand Salary   : 45000
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/







//JSP File(index.jsp


<html>
<body>

<h2>Enter Employee Details</h2>

<form action="insert.jsp" method="post">
    Emp No: <input type="text" name="empno" required><br><br>
    Emp Name: <input type="text" name="empname" required><br><br>
    Salary: <input type="text" name="salary" required><br><br>

    <input type="submit" value="Add employee">
</form>

<br>
<a href="report.jsp">View Salary Report</a>

</body>
</html>




//JSP File(insert.jsp)


<%@ page import="java.sql.*" %>

<%
String empno = request.getParameter("empno");
String name = request.getParameter("empname");
String salary = request.getParameter("salary");

try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/employee", "root", "root");

    PreparedStatement ps = con.prepareStatement(
        "INSERT INTO Emp VALUES (?, ?, ?)");

    ps.setInt(1, Integer.parseInt(empno));
    ps.setString(2, name);
    ps.setInt(3, Integer.parseInt(salary));

    int i = ps.executeUpdate();

    if(i > 0) {
        out.println("Employee Added Successfully!");
    }

    out.println("<br><a href='index.jsp'>Back</a>");

    con.close();

} catch(Exception e) {
    out.println("Error: " + e);
}
%>



//JSP File(report.jsp)


<%@ page import="java.sql.*" %>

<html>
<body>

<h2>Salary Report</h2>

<pre>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
</pre>

<%
int total = 0;

try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/employee", "root", "root");

    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM Emp");

    while(rs.next()) {

        int id = rs.getInt("Emp_NO");
        String name = rs.getString("Emp_Name");
        int sal = rs.getInt("Basicsalary");

        total += sal;
%>

<pre>
Emp_No     : <%=id%>
Emp_Name   : <%=name%>
Basic      : <%=sal%>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
</pre>

<%
    }

    con.close();

} catch(Exception e) {
    out.println(e);
}
%>

<pre>
Grand Salary : <%=total%>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
</pre>

</body>
</html>