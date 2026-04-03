/*7b. Construct a Cookie Management program using JSP to get the fields  Name, Domain and Max Expiry Age ( in sec) and press the button Add Cookie for displaying the set cookie information. Then it has to go to show the active cookie list when you press the link go to the active cookie list */


//JSP File(index.jsp)

<!DOCTYPE html>
<html>
<head>
    <title>Cookie Management</title>
</head>
<body>

<h2>Add Cookie</h2>

<form action="addCookie.jsp" method="post">
    Name: <input type="text" name="cname" required><br><br>
    Domain: <input type="text" name="cdomain" required><br><br>
    Max Age (seconds): <input type="number" name="cage" required><br><br>

    <input type="submit" value="Add Cookie">
</form>

<br>
<a href="showCookies.jsp">Go to Active Cookie List</a>

</body>
</html>



//JSP File(addCookies.jsp)


<%@ page import="javax.servlet.http.Cookie" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cookie Added</title>
</head>
<body>

<%
    String name = request.getParameter("cname");
    String domain = request.getParameter("cdomain");
    int age = Integer.parseInt(request.getParameter("cage"));

    // Store domain + age together (important fix)
    String value = domain + "|" + age;

    Cookie cookie = new Cookie(name, value);

    cookie.setMaxAge(age);   // works correctly on server side
    response.addCookie(cookie);
%>

<h2>Cookie Added Successfully</h2>

<p>Name: <%= name %></p>
<p>Domain: <%= domain %></p>
<p>Max Age: <%= age %> seconds</p>

<br>
<a href="showCookies.jsp">Go to Active Cookie List</a>

</body>
</html>




//JSP File(showCookies.jsp)



<%@ page import="javax.servlet.http.Cookie" %>
<!DOCTYPE html>
<html>
<head>
    <title>Active Cookies</title>
</head>
<body>

<h2>Active Cookie List</h2>

<%
    Cookie[] cookies = request.getCookies();

    if (cookies != null) {
        for (Cookie c : cookies) {

            String[] data = c.getValue().split("\\|");

            String domain = data[0];
            String age = (data.length > 1) ? data[1] : "Not Available";
%>

<p>
    Name: <%= c.getName() %> |
    Domain: <%= domain %> |
    Max Age: <%= age %> seconds
</p>

<%
        }
    } else {
%>
        <p>No cookies found</p>
<%
    }
%>

<br>
<a href="index.jsp">Back</a>

</body>
</html>
