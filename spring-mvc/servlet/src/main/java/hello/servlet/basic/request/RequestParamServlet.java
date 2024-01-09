package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("REQUETS PARAM");
        System.out.println("전체 파라미터 조회 - start");
        request.getParameterNames().asIterator()
                        .forEachRemaining(paramName -> System.out.println(paramName + "=" + request.getParameter(paramName)));
        System.out.println("전체 파라미터 조회 - END");
        System.out.println();
        System.out.println("단일 파라미터 조회");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println(name);
        System.out.println(age);
        System.out.println();

        System.out.println("이름이 같은 복수 파라미터 조회");
        String[] userNames = request.getParameterValues("name");
        for (String s : userNames) {
            System.out.println(s);
        }

        response.setContentType("text/html; charset=utf-8");
        response.getWriter().write("<h2>OK</h2>");
    }
}
