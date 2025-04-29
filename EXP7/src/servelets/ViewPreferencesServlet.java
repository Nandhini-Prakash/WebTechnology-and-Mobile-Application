package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class ViewPreferencesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String theme = "Not set";
        String language = "Not set";

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("theme")) {
                    theme = c.getValue();
                }
                if (c.getName().equals("language")) {
                    language = c.getValue();
                }
            }
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Your Preferences</h2>");
        out.println("Theme: " + theme + "<br>");
        out.println("Language: " + language + "<br><br>");
        out.println("<a href='preferences.html'>Change Preferences</a>");
    }
}
