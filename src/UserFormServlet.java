import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class UserFormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");
        String age = request.getParameter("age");

        out.println("<html><body>");
        out.println("<h2>Name: " + name + "</h2>");
        out.println("<h2>Age: " + age + "</h2>");
        out.println("</body></html>");
    }
}
