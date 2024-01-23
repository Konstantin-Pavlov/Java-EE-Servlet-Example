package org.example.javaeeexamle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Delete Cookies Servlet", value = "/delete-cookies")
public class DeleteCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("id", ""); // перезаписываем ключ id
        cookie.setMaxAge(0); // 0 секунд, сразу же удалится
//        cookie.setMaxAge(-1); // куки удаляются тогда когда пользователи закроют браузер
        resp.addCookie(cookie);

        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<h1>delete cookies page</h1>");

        out.println("<br>  <a href=\"http://localhost:8080/\"\">homepage</a> <br>\n");
        out.println("</html>");
    }
}
