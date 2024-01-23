package org.example.javaeeexamle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Get Cookies Servlet", value = "/get-cookies")
public class GetCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<h1>get cookies page</h1>");

        for (Cookie cookie : cookies) {
            out.println("<p>" + cookie.getName() + " : " + cookie.getValue() + "</p>");
        }

        out.println("<br>  <a href=\"http://localhost:8080/\"\">homepage</a> <br>\n");
        out.println("</html>");

    }
}
