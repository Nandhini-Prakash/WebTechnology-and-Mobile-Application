package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class PreferenceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String theme = request.getParameter("theme");
        String language = request.getParameter("language");

        Cookie themeCookie = new Cookie("theme", theme);
        Cookie langCookie = new Cookie("language", language);

        // Set cookies to last for 1 day
        themeCookie.setMaxAge(60 * 60 * 24);
        langCookie.setMaxAge(60 * 60 * 24);

        response.addCookie(themeCookie);
        response.addCookie(langCookie);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>Preferences saved!</h3>");
        out.println("<a href='viewPreferences'>View Preferences</a>");
    }
}
