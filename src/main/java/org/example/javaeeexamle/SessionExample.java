package org.example.javaeeexamle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Session Example", value = "/session")
public class SessionExample extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        Integer sessionCounter = (Integer) session.getAttribute("sessionCounter");
        if (sessionCounter == null) {
            sessionCounter = 1;
            session.setAttribute("sessionCounter", 1);
        }
        session.setAttribute("sessionCounter", sessionCounter + 1);

        out.println("<html>");
        out.println("<h1>Session example page</h1>");
        out.printf("<p>you visited this page <b>%d</b> times</p>", sessionCounter);
        out.println("<br>");
        out.println("<br>  <a href=\"http://localhost:8080/\">homepage</a> <br>\n");
        out.println("</html>");
    }
}
