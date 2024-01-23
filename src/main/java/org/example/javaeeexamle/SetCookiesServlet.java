package org.example.javaeeexamle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Set Cookies Servlet", value = "/set-cookies")
public class SetCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie1 = new Cookie("id", "123");
        Cookie cookie2 = new Cookie("name", "Tom");

        // срок действия в секундах, здесь 1 день
        cookie1.setMaxAge(60 * 60 * 24);
        cookie2.setMaxAge(60 * 60 * 24);

        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<h1>set cookies page</h1>");

        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
        out.println("<br>  <a href=\"http://localhost:8080/\"\">homepage</a> <br>\n");
        out.println("</html>");
    }
}
