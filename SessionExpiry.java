/*9c. Build a Session Management using JSP program for getting  session expiry time and 
your name through text box and press submit to display the message by greeting Hello your name!.
press the following link to check it within  the set session time  or wait there for the minutes set  to see the session expiry.
*/




//HTML File(index.html)

<html>
<head>
    <title>Session Login</title>
</head>
<body>

<h2>Enter Details</h2>

<form action="welcome.jsp" method="post">
    Name: <input type="text" name="username"><br><br>
    Session Time (in seconds): <input type="text" name="time"><br><br>
    <input type="submit" value="Submit">
</form>

</body>
</html>



//JSP File(welcome.jsp)

<%@ page language="java" %>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>

<%
String name = request.getParameter("username");
String timeStr = request.getParameter("time");

int time = Integer.parseInt(timeStr);

// Create session
session.setAttribute("user", name);

// Set session expiry time
session.setMaxInactiveInterval(time);
%>

<h2 style="color:blue;">
    Hello <%= name %>!
</h2>

<h3 style="color:green;">
    Session will expire in <%= time %> seconds.
</h3>

<br>

<a href="check.jsp">Click here to check session</a>

</body>
</html>




//JSP File(check.jsp)


<%@ page language="java" %>
<html>
<head>
    <title>Check Session</title>
</head>
<body>

<%
String user = (String) session.getAttribute("user");

if (user != null) {
%>

<h2 style="color:blue;">
    Hello again <%= user %>!
</h2>

<h3 style="color:green;">
    Session is still active.
</h3>

<%
} else {
%>

<h2 style="color:red;">
    Session expired! Please login again.
</h2>

<a href="index.jsp">Go back</a>

<%
}
%>

</body>
</html>