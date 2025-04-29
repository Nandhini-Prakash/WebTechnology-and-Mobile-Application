package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session != null)
            session.invalidate();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>Logged out successfully.</h3>");
        out.println("<a href='login.html'>Login again</a>");
    }
}
