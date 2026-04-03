/*7a. Build a servlet program to  create a cookie to get your name through text box and press submit button to display the message by greeting Welcome back your name ! , you have visited this page n times ( n = number of your visit ) and demonstrate the expiry of cookie also. */


Sevlet(CookieServlet)

package com.cookieservlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("userName");

        // Step 1: Create cookie if user enters name
        if (userName != null && !userName.isEmpty()) {

            Cookie userCookie = new Cookie("user", userName);
            userCookie.setMaxAge(60); // 1 minute
            response.addCookie(userCookie);

            Cookie countCookie = new Cookie("count", "1");
            countCookie.setMaxAge(60);
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
            countCookie.setMaxAge(60);
            response.addCookie(countCookie);
        }

        // Step 4: HTML Output
        out.println("<html><body>");

        if (existingUser == null) {

            //  FIRST PAGE (Login Form)
            
            out.println("<h2 style='color:red;'>Welcome Guest! You have been logged out or kindly login if first time</h2>");
            out.println("<form action='CookieServlet' method='get' target='_blank'>");
            out.println("Enter your name: <input type='text' name='userName'>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
            

        } else {

            //  SECOND PAGE (New Tab Output)
            
            out.println("<h1 style='color:blue;'>Welcome back, " + existingUser + "!</h1>");
            out.println("<h1 style='color:magenta;'>You have visited this page " + count + " times!</h1>");
        
        }

        out.println("</body></html>");
    }
}