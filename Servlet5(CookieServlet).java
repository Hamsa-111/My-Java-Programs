/*8b. Build a servlet program to  create a cookie to get your name through text box and press submit button( through HTML)
  to display the message by greeting Welcome back your name ! , you have visited this page n times ( n = number of your visit ) 
 along with the list of cookies and its setvalues and demonstrate the expiry of cookie also. */



//Sevlet(CookieServlet)

package com.cookieservlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("userName");

        // Step 1: Create cookies
        if (userName != null && !userName.isEmpty()) {

            Cookie userCookie = new Cookie("user", userName);
            userCookie.setMaxAge(30); // expires in 30 sec
            response.addCookie(userCookie);

            Cookie countCookie = new Cookie("count", "1");
            countCookie.setMaxAge(30);
            response.addCookie(countCookie);
        }

        // Step 2: Read cookies
        Cookie[] cookies = request.getCookies();

        String existingUser = null;
        int count = 0;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("user")) {
                    existingUser = c.getValue();
                }
                if (c.getName().equals("count")) {
                    count = Integer.parseInt(c.getValue());
                }
            }
        }

        // Step 3: Increase visit count
        if (existingUser != null) {
            count++;
            Cookie countCookie = new Cookie("count", String.valueOf(count));
            countCookie.setMaxAge(30);
            response.addCookie(countCookie);
        }

        // Step 4: Output
        out.println("<html><body>");

        if (existingUser != null) {
            out.println("<h2 style='color:blue;'>Welcome back, " + existingUser + "!</h2>");
            out.println("<h2 style='color:magenta;'>You have visited this page " + count + " times</h2>");
        } else {
            out.println("<h2 style='color:red;'>No cookie found (expired or first visit)</h2>");
        }

        // Step 5: Display all cookies
        out.println("<h3>Cookies List:</h3>");

        if (cookies != null) {
            for (Cookie c : cookies) {
                out.println("Name: " + c.getName() + " | Value: " + c.getValue() + "<br>");
            }
        } else {
            out.println("No cookies available");
        }

        out.println("<br><h3>Note: Cookie expires in 30 seconds. Refresh after 30 sec to see expiry.</h3>");

        out.println("</body></html>");
    }
}





//HTML File(index.html)

<!DOCTYPE html>
<html>
<head>
    <title>Cookie Login</title>
</head>
<body>

<h2 style="color:red;">Enter Your Name</h2>

<form action="CookieServlet" method="get">
    Name: <input type="text" name="userName">
    <input type="submit" value="Submit">
</form>

</body>
</html>
