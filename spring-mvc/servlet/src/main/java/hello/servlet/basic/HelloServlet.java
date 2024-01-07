package hello.servlet.basic;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloSevlret", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(
            HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HELLO");
        System.out.println(request);
        System.out.println(response);

        String name = request.getParameter("name");
        System.out.println(name);

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("<html><body><h1>hello " + name + "</h1></body></html>");
    }
}
