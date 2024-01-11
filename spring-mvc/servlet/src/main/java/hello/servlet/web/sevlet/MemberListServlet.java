package hello.servlet.web.sevlet;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter writer = response.getWriter();

        writer.write("<html>");
        writer.write("<head><title>Member List</title></head>");
        writer.write("<body>");
        writer.write("<h1>Member List</h1>");
        writer.write("<ul>");

        for (Member member : members) {
            writer.write("<li>" + member.getId() + ": " + member.getUsername() + " - " + member.getAge() + "</li>");
        }

        writer.write("</ul>");
        writer.write("<a href=\"/index.html\">메인</a>\n");
        writer.write("</body>");
        writer.write("</html>");


    }
}
