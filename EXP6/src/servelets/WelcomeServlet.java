package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class WelcomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            String username = (String) session.getAttribute("username");
            out.println("<h2>Welcome, " + username + "</h2>");
            out.println("<a href='logout'>Logout</a>");
        } else {
            out.println("<h3>Login first</h3><a href='login.html'>Login</a>");
        }
    }
}
