package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String title = request.getParameter("title");
        String isbn = request.getParameter("isbn");
        String year = request.getParameter("year");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/library_db", "root", "password");

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO books (title, isbn, year) VALUES (?, ?, ?)");
            ps.setString(1, title);
            ps.setString(2, isbn);
            ps.setInt(3, Integer.parseInt(year));
            ps.executeUpdate();

            out.println("<h2>Book added successfully!</h2>");
            con.close();
        } catch (Exception e) {
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
        }
    }
}
