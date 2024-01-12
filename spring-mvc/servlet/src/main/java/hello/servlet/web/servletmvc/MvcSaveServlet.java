package hello.servlet.web.servletmvc;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.apache.coyote.Request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name ="mvcSaveServlet", urlPatterns = "/servlet-mvc/members/save")
public class MvcSaveServlet extends HttpServlet {
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MvcSaveServlet.service");

        String name = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(name, age);
        memberRepository.save(member);

        // Model에 데이터를 보관
        request.setAttribute("member", member);

        String path = "/WEB-INF/views/mvc-save.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }
}
