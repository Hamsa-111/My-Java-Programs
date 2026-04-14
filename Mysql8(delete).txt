/*12d. Develop a JDBC project using MySQL to delete the records in the table Emp of the database Employee by getting the name starting with ‘S’   through JSP  and Generate the report as follows


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

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/





JSP FILE(index.jsp)


<!DOCTYPE html>
<html>
<body style="text-align:center;">

<h1>Employee Management</h1>
<hr>

<a href="delete.jsp">Delete Employees (Name starts with S)</a><br><br>
<a href="report.jsp">View Salary Report</a>

</body>
</html>



JSP FILE(delete.jsp)



<!DOCTYPE html>
<html>
<body style="text-align:center;">

<h2>Delete Employees whose name starts with 'S'</h2>

<form action="delete_process.jsp" method="post">
    <input type="submit" value="Delete Now">
</form>

<br>
<a href="index.jsp">Back</a>

</body>
</html>




JSP FILE(delete_process.jsp)



<%@ page import="java.sql.*" %>

<%
try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3307/Employee?useSSL=false&serverTimezone=UTC",
        "root",
        ""
    );

    PreparedStatement ps = con.prepareStatement(
        "DELETE FROM Emp WHERE Emp_Name LIKE 'S%'"
    );

    int rows = ps.executeUpdate();

    ps.close();
    con.close();

    // Redirect to report after delete
    response.sendRedirect("report.jsp");

} catch(Exception e) {
    out.println(e);
}
%>





JSP FILE(report.jsp)



<%@ page import="java.sql.*" %>

<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>

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
        "jdbc:mysql://localhost:3307/Employee?useSSL=false&serverTimezone=UTC",
        "root",
        ""
    );

    Statement st = con.createStatement();

    ResultSet rs = st.executeQuery("SELECT * FROM Emp");

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

    rs.close();
    st.close();
    con.close();

} catch(Exception e) {
    out.println(e);
}
%>

<br>
<a href="index.jsp">Back</a>

</body>
</html>

