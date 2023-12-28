package org.example.javaeeexamle;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FirstServlet", value = "/hello-servlet")
public class FirstServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello servlet!!!";
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Handle GET requests
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.printf("<h1>%s</h1>%n", message);
        out.println("<h2>" + "wow" + " </h2>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}