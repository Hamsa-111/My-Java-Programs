/*11d. Develop a JDBC project using JDBC to update  the fields empno,  empname and basicsalary into the table Emp of the database Employee  by getting the fields  through JSP  */




//JSP File(index.jsp)


<html>
<head>
    <title>Employee Update</title>
</head>
<body>

<h2>Enter Employee Details</h2>

<form action="update.jsp" method="post">
    Emp No: <input type="text" name="Emp_NO" required><br><br>
    Emp Name: <input type="text" name="Emp_Name" required><br><br>
    Basic Salary: <input type="text" name="Basicsalary" required><br><br>

    <input type="submit" value="Update">
</form>

</body>
</html>




//JSP File(update.jsp)


<%@ page import="java.sql.*" %>

<html>
<body>

<%
    int empno = Integer.parseInt(request.getParameter("Emp_NO"));
    String empname = request.getParameter("Emp_Name");
    double salary = Double.parseDouble(request.getParameter("Basicsalary"));

    Connection con = null;
    PreparedStatement ps = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/Employee",
            "root",
            "root"
        );

        String query = "UPDATE Emp SET Emp_Name=?, Basicsalary=? WHERE Emp_NO=?";
        ps = con.prepareStatement(query);

        ps.setString(1, empname);
        ps.setDouble(2, salary);
        ps.setInt(3, empno);

        int i = ps.executeUpdate();

        if (i > 0) {
%>
            <h3>Record Updated Successfully!</h3>
<%
        } else {
%>
            <h3>Employee Not Found!</h3>
<%
        }

    } catch (Exception e) {
        out.println(e);
    } finally {
        if (ps != null) ps.close();
        if (con != null) con.close();
    }
%>

<br><br>
<a href="report.jsp">View Salary Report</a><br>
<a href="index.jsp">Back</a>

</body>
</html>



//JSP File(report.jsp)


<%@ page import="java.sql.*" %>

<html>
<body>

<pre>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                        Salary Report
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
</pre>

<%
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    double grandTotal = 0;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/Employee",
            "root",
            "root"
        );

        st = con.createStatement();
        rs = st.executeQuery("SELECT * FROM Emp");

        while (rs.next()) {

            int empno = rs.getInt("Emp_NO");
            String name = rs.getString("Emp_Name");
            double salary = rs.getDouble("Basicsalary");

            grandTotal += salary;
%>

<pre>
Emp_No     : <%= empno %>
Emp_Name   : <%= name %>
Basic      : <%= salary %>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
</pre>

<%
        }
%>

<pre>
Grand Salary : <%= grandTotal %>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
</pre>

<%
    } catch (Exception e) {
        out.println(e);
    } finally {
        if (rs != null) rs.close();
        if (st != null) st.close();
        if (con != null) con.close();
    }
%>

<br>
<a href="index.jsp">Back</a>

</body>
</html>