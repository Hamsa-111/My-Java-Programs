/*10b. Build an Application to get Rollno, Studentname, Sub1, Sub2, Sub3, Sub4 and Sub5  through JSP called index.jsp with client sided validation and submit to the servlet called ResultServlet and process all the fields with server sided validation and display all the data along with result ( Pass if all subjects greater than 40%) and Average marks through result.jsp with a link to move to the client side*/




//Servlet(ResultServlet)

package com.example;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rollno = request.getParameter("rollno");
        String name = request.getParameter("name");

        int s1 = Integer.parseInt(request.getParameter("sub1"));
        int s2 = Integer.parseInt(request.getParameter("sub2"));
        int s3 = Integer.parseInt(request.getParameter("sub3"));
        int s4 = Integer.parseInt(request.getParameter("sub4"));
        int s5 = Integer.parseInt(request.getParameter("sub5"));

        // Server-side validation
        if (rollno== null || name == null || name.trim().isEmpty()) {
            response.getWriter().println("Invalid Input");
            return;
        }

        int total = s1 + s2 + s3 + s4 + s5;
        double avg = total / 5.0;

        String result = "Fail";

        if (s1 >= 40 && s2 >= 40 && s3 >= 40 && s4 >= 40 && s5 >= 40) {
            result = "Pass";
        }

        // Send data to JSP
        request.setAttribute("rollno", rollno);
        request.setAttribute("name", name);
        request.setAttribute("s1", s1);
        request.setAttribute("s2", s2);
        request.setAttribute("s3", s3);
        request.setAttribute("s4", s4);
        request.setAttribute("s5", s5);
        request.setAttribute("avg", avg);
        request.setAttribute("result", result);

        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }
}





//JSP File(index.jsp)


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Result</title>

<script>
function validateForm() {
    let roll = document.forms["myForm"]["rollno"].value;
    let name = document.forms["myForm"]["name"].value;

    if (roll === "" || name === "") {
        alert("USN and Name must be filled out");
        return false;
    }

    let subjects = ["sub1","sub2","sub3","sub4","sub5"];

    for (let i = 0; i < subjects.length; i++) {
        let marks = document.forms["myForm"][subjects[i]].value;

        if (marks === "" || isNaN(marks) || marks < 0 || marks > 100) {
            alert("Enter valid marks (0-100)");
            return false;
        }
    }
    return true;
}
</script>

</head>

<body>
<h2>Enter Student Details</h2>

<form name="myForm" action="ResultServlet" method="post" onsubmit="return validateForm()">

Roll No: <input type="text" name="rollno"><br><br>
Name: <input type="text" name="name"><br><br>

Sub1: <input type="text" name="sub1"><br><br>
Sub2: <input type="text" name="sub2"><br><br>
Sub3: <input type="text" name="sub3"><br><br>
Sub4: <input type="text" name="sub4"><br><br>
Sub5: <input type="text" name="sub5"><br><br>

<input type="submit" value="Submit">

</form>

</body>
</html>



//Jsp File (result.jsp)


<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
</head>
<body>

<h2>Student Result</h2>

Roll No: ${rollno} <br><br>
Name: ${name} <br><br>

Marks:<br>
Sub1: ${s1} <br>
Sub2: ${s2} <br>
Sub3: ${s3} <br>
Sub4: ${s4} <br>
Sub5: ${s5} <br><br>

Average: ${avg} <br><br>
Result: ${result} <br><br>

<a href="index.jsp">Go Back</a>

</body>
</html>