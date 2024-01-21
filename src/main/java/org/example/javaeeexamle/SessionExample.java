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
        /*
        // example with user authorization
        String user = session.getAttribute("current_user");
        if (user == null) {
            // response for anonymous user
            // authorization
            // registration
            session.setAttribute("current_user", id);
        } else {
            // response for authorized user
        }*/


        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        Integer sessionCounter = (Integer) session.getAttribute("sessionCounter");

        Cart cart = (Cart) session.getAttribute("cart");
        String productName = req.getParameter("pName");
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        if (sessionCounter == null) {
            sessionCounter = 1;
            session.setAttribute("sessionCounter", 1);
        }
        session.setAttribute("sessionCounter", sessionCounter + 1);

        if (cart == null) {
            cart = new Cart();
            cart.setProductName(productName);
            cart.setQuantity(quantity);
        }
        session.setAttribute("cart", cart);
        session.setAttribute("name", name);
        session.setAttribute("surname", surname);


        out.println("<html>");
        out.println("<h1>Session example page</h1>");
        out.printf("<p>you visited this page <b>%d</b> times</p>", sessionCounter);
        out.println("<br>");
        out.println("<br>  <a href=\"http://localhost:8080/showCart.jsp\">show cart content</a> <br>\n");
        out.println("<br>  <a href=\"http://localhost:8080/\"\">homepage</a> <br>\n");
        out.println("</html>");

        // instant redirect to /showCart.jsp page
//        getServletContext().getRequestDispatcher("/showCart.jsp").forward(req, resp);
    }
}
